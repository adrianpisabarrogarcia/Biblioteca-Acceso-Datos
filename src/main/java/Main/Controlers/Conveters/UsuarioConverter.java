package Main.Controlers.Conveters;

import Main.Models.Categoria;
import Main.Models.Usuario;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UsuarioConverter implements Converter {

    //date format
    //utc date format
    String patternFecha = "dd/MM/yyyy";
    DateFormat formatoFecha = new SimpleDateFormat(patternFecha);


    private static final Logger logger = Logger.getLogger(UsuarioConverter.class.getName());

    @Override
    public void marshal(Object objeto, HierarchicalStreamWriter writer, MarshallingContext context) {
        Usuario usuario = (Usuario) objeto;
        //add atributos
        writer.addAttribute("id", String.valueOf(usuario.getId()));
        //add elementos
        writer.startNode("nombre");
        writer.setValue(usuario.getNombre());
        writer.endNode();
        writer.startNode("apellidos");
        writer.setValue(usuario.getApellidos());
        writer.endNode();
        //date
        writer.startNode("fechaNacimiento");
        writer.setValue(formatoFecha.format(usuario.getFechaNacimiento()));
        writer.endNode();
        writer.startNode("email");
        writer.setValue(usuario.getEmail());
        writer.endNode();
        writer.startNode("direccion");
        writer.setValue(usuario.getDireccion());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(reader.getAttribute("id")));
            reader.moveDown();
            usuario.setNombre(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            usuario.setApellidos(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            usuario.setFechaNacimiento(formatoFecha.parse(reader.getValue()));
            reader.moveUp();
            reader.moveDown();
            usuario.setEmail(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            usuario.setDireccion(reader.getValue());
            reader.moveUp();
            return usuario;
        }catch (Exception e) {
            logger.error("Error al convertir el objeto", e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Usuario.class);
    }
}
