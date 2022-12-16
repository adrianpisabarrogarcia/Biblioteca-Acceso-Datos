package Main.Controlers;


import Main.Controlers.existdb.ExistDB;
import Main.Models.Usuario;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;

public class UsuariosController {

    private static final Logger logger = Logger.getLogger(UsuariosController.class);

    public static void insertar(Usuario usuario) {
        logger.info("Insertar usuario");

        //Pasar de objeto a String XML
        XStream xstream = new XStream();
        xstream = Usuario.prepararXStream();
        String xml = xstream.toXML(usuario);


        //Insertar en existdb
        ExistDB.insertarElemento("Usuarios",xml,"/list");

        logger.info("Insertado usuario en existdb");
    }

    public static void modificar(Usuario usuario) {
        logger.info("Modificar usuario");

        eliminar(usuario);
        insertar(usuario);

        logger.info("Modificar usuario");
    }

    public static boolean existe(Usuario usuario) {
        logger.info("Existe usuario");
        boolean existe = false;

        //Comprobar si existe en existdb
        existe = ExistDB.existeElemento("Usuarios","/list/usuario", usuario.getId());

        return existe;
    }

    public static void eliminar(Usuario usuario) {
        logger.info("Eliminar usuario");

        String id = ""+usuario.getId();
        String elemento = "/list/usuario[@id='"+id+"']";
        ExistDB.eliminarElemento("Usuarios",elemento);

        logger.info("Eliminado usuario en existdb");
    }

    public static ArrayList<Usuario> buscar(Usuario usuario) {
        logger.info("Buscar usuario");
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = "/list/usuario";
        //montar la query
        if(usuario.getId() != -1){
            String id = ""+usuario.getId();
            query += "[@id='"+id+"']";
        }
        if(usuario.getNombre() != null){
            query += "[nombre='"+usuario.getNombre()+"']";
        }
        if (usuario.getApellidos() != null){
            query += "[apellidos='"+usuario.getApellidos()+"']";
        }
        if (usuario.getFechaNacimiento() != null){
            String dia = ""+usuario.getFechaNacimiento().getDate();
            String mes = ""+usuario.getFechaNacimiento().getMonth();
            if(mes.length() == 1){
                mes = "0"+mes;
            }
            if (dia.length() == 1){
                dia = "0"+dia;
            }
            int anyo = usuario.getFechaNacimiento().getYear()+1900;
            query += "[fechaNacimiento='"+dia+"/"+mes+"/"+anyo+"']";
        }
        if (usuario.getEmail() != null){
            query += "[email='"+usuario.getEmail()+"']";
        }
        if (usuario.getDireccion() != null){
            query += "[direccion='"+usuario.getDireccion()+"']";
        }

        query = "for $i in doc('Usuarios.xml')"+query+" return $i";
        System.out.println(query);


        //Buscar en existdb
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Usuario.prepararXStream();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    usuario = (Usuario) xStream.fromXML(resultado.nextResource().getContent().toString());
                    usuarios.add(usuario);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar usuarios");
            logger.error(e.getMessage());
        }


        return usuarios;
    }

    public static Usuario buscarPorId(Usuario usuario) {
        logger.info("Buscar usuario");

        String id = ""+usuario.getId();
        String elemento = "/list/usuario[@id='"+id+"']";
        String xml = ExistDB.buscarElementoPorId("Usuarios","/list/usuario", usuario.getId());
        if(xml.equals("")){
            return null;
        }
        //Pasar de String XML a objeto
        XStream xstream = Usuario.prepararXStream();
        Usuario usuarioEncontrado = (Usuario) xstream.fromXML(xml);
        return usuarioEncontrado;
    }

    public static ArrayList<Usuario> listar() {
        logger.info("Listar usuarios");
        String query = "for $x in doc('Usuarios.xml')//usuario return $x";
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Usuario.prepararXStream();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    Usuario usuario = (Usuario) xStream.fromXML(resultado.nextResource().getContent().toString());
                    usuarios.add(usuario);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar usuarios");
            logger.error(e.getMessage());
        }

        return usuarios;
    }
}
