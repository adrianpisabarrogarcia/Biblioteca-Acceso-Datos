package Main.Controlers.Conveters;

import Main.Models.Alquiler;
import Main.Models.Categoria;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AlquilerConverter implements Converter {

    private static final Logger logger = Logger.getLogger(AlquilerConverter.class.getName());

    //date format
    //utc date format
    String patternFecha = "dd/MM/yyyy";
    DateFormat formatoFecha = new SimpleDateFormat(patternFecha);

    @Override
    public void marshal(Object objeto, HierarchicalStreamWriter writer, MarshallingContext context) {
        Alquiler alquiler = (Alquiler) objeto;
        //add atributo id
        writer.addAttribute("id", String.valueOf(alquiler.getId()));
        //new nodo usuario
        writer.startNode("usuario");
        //add atributo id
        writer.addAttribute("id", String.valueOf(alquiler.getIdUsuario()));
        //end nodo usuario
        writer.endNode();
        //new nodo libro
        writer.startNode("libro");
        //add atributo id
        writer.addAttribute("id", String.valueOf(alquiler.getIdLibro()));
        //end nodo libro
        //fecha alquiler parse to date
        writer.startNode("fechaAlquiler");
        writer.setValue(formatoFecha.format(alquiler.getFechaAlquiler()));
        writer.endNode();
        //fecha devolucion parse to date
        writer.startNode("fechaDevolucion");
        writer.setValue(formatoFecha.format(alquiler.getFechaDevolucion()));
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            Alquiler alquiler = new Alquiler();
            //add atributo id
            alquiler.setId(Integer.parseInt(reader.getAttribute("id")));
            //new nodo usuario
            reader.moveDown();

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
