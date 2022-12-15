package Main.Controlers.Conveters;

import Main.Models.Categoria;
import Main.Models.Libro;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.log4j.Logger;

public class LibrosConverter implements Converter {

    private static final Logger logger = Logger.getLogger(LibrosConverter.class.getName());

    @Override
    public void marshal(Object objeto, HierarchicalStreamWriter writer, MarshallingContext context) {
        Libro libro = (Libro) objeto;
        writer.addAttribute("id", String.valueOf(libro.getId()));
        writer.startNode("titulo");
        writer.setValue(libro.getTitulo());
        writer.endNode();
        writer.startNode("autor");
        writer.setValue(libro.getAutor());
        writer.endNode();
        writer.startNode("editorial");
        writer.setValue(libro.getEditorial());
        writer.endNode();
        writer.startNode("anio");
        writer.setValue(String.valueOf(libro.getAnio()));
        writer.endNode();
        writer.startNode("isbn");
        writer.setValue(libro.getIsbn());
        writer.endNode();
        writer.startNode("categoria");
        context.convertAnother(libro.getCategoria());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            Libro libro = new Libro();
            libro.setId(Integer.parseInt(reader.getAttribute("id")));
            reader.moveDown();
            libro.setTitulo(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            libro.setAutor(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            libro.setEditorial(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            libro.setAnio(Integer.parseInt(reader.getValue()));
            reader.moveUp();
            reader.moveDown();
            libro.setIsbn(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            libro.setCategoria((Categoria) context.convertAnother(libro, Categoria.class));
            reader.moveUp();
            return libro;
        }catch (Exception e) {
            logger.error("Error al convertir el objeto", e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Libro.class);
    }
}
