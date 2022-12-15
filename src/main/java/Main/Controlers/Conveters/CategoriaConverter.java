package Main.Controlers.Conveters;

import Main.Models.Categoria;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.log4j.Logger;

public class CategoriaConverter implements Converter {

    private static final Logger logger = Logger.getLogger(CategoriaConverter.class.getName());

    @Override
    public void marshal(Object objeto, HierarchicalStreamWriter writer, MarshallingContext context) {
        Categoria categoria = (Categoria) objeto;
        //add atributos
        writer.addAttribute("id", String.valueOf(categoria.getId()));
        //add elementos
        writer.startNode("nombre");
        writer.setValue(categoria.getNombre());
        writer.endNode();
        writer.startNode("descripcion");
        writer.setValue(categoria.getDescripcion());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            Categoria categoria = new Categoria();
            //add atributos
            categoria.setId(Integer.parseInt(reader.getAttribute("id").trim()));
            //add elementos
            reader.moveDown();
            categoria.setNombre(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            categoria.setDescripcion(reader.getValue());
            reader.moveUp();
            return categoria;
        }catch (Exception e) {
            logger.error("Error al convertir el objeto", e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Categoria.class);
    }
}
