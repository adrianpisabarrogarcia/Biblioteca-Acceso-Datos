package Main.Controlers;

import Main.Controlers.existdb.ExistDB;
import Main.Models.Categoria;
import Main.Models.Libro;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;

public class LibrosController {

    private static final Logger logger = Logger.getLogger(LibrosController.class);

    public static void insertar(Libro libro) {
        logger.info("Insertar libro");

        //Pasar de objeto a String XML
        XStream xstream = new XStream();
        xstream = Libro.prepararXStream();
        String xml = xstream.toXML(libro);


        //Insertar en existdb
        ExistDB.insertarElemento("Libros",xml,"/list");

        logger.info("Insertado libro en existdb");
    }

    public static void modificar(Libro libro) {
        logger.info("Modificar libro");

        eliminar(libro);
        insertar(libro);

        logger.info("Modificado libro en existdb");
    }

    public static boolean existe(Libro libro) {
        logger.info("Existe libro");
        boolean existe = false;

        //Comprobar si existe en existdb
        existe = ExistDB.existeElemento("Libros","/list/libro", libro.getId());

        return existe;
    }

    public static void eliminar(Libro libro) {
        logger.info("Eliminar libro");

        String id = ""+libro.getId();
        String elemento = "/list/libro[@id='"+id+"']";
        ExistDB.eliminarElemento("Libros",elemento);

        logger.info("Eliminado libro en existdb");
    }

    public static ArrayList<Libro> buscar(Libro libro) {
        logger.info("Buscar libro");
        ArrayList<Libro> libros = new ArrayList<>();

        String query = "/list/libro";
        //montar la query
        if(libro.getId() != -1){
            String id = ""+libro.getId();
            query += "[@id='"+id+"']";
        }
        if(libro.getTitulo() != null){
            query += "[titulo='"+libro.getTitulo()+"']";
        }
        if(libro.getAutor() != null){
            query += "[autor='"+libro.getAutor()+"']";
        }
        if(libro.getEditorial() != null){
            query += "[editorial='"+libro.getEditorial()+"']";
        }
        if(libro.getAnio() != -1){
            query += "[anio='"+libro.getAnio()+"']";
        }
        if(libro.getIsbn() != null){
            query += "[isbn='"+libro.getIsbn()+"']";
        }


        query = "for $i in doc('Libros.xml')"+query+" return $i";


        System.out.println(query);
        //Buscar en existdb
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Libro.prepararXStream();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    libro = (Libro) xStream.fromXML(resultado.nextResource().getContent().toString());
                    libros.add(libro);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar libros");
            logger.error(e.getMessage());
        }


        return libros;
    }

    public static Libro buscarPorId(Libro libro) {
        logger.info("Buscar libro");

        String id = ""+libro.getId();
        String elemento = "/list/libro[@id='"+id+"']";
        String xml = ExistDB.buscarElementoPorId("Libros","/list/libro", libro.getId());
        if(xml.equals("")){
            return null;
        }
        //Pasar de String XML a objeto
        XStream xstream = Libro.prepararXStream();
        Libro encontrado = (Libro) xstream.fromXML(xml);
        return encontrado;
    }

    public static ArrayList<Libro> listar() {
        logger.info("Listar libros");
        String query = "for $x in doc('Libros.xml')//libro return $x";
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Libro.prepararXStream();
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    Libro libro = (Libro) xStream.fromXML(resultado.nextResource().getContent().toString());
                    libros.add(libro);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar libros");
            logger.error(e.getMessage());
        }
        logger.info("Listado de libros hecho");

        return libros;
    }


    public static ArrayList<Libro> buscarPorCategoria(Libro libro){
        Categoria categoria = libro.getCategoria();
        String query = "for $x in doc('Libros.xml')//libro where $x/categoria[@id='"+categoria.getId()+"'] return $x";
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Libro.prepararXStream();
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    Libro libroEncontrado = (Libro) xStream.fromXML(resultado.nextResource().getContent().toString());
                    libros.add(libroEncontrado);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar libros");
            logger.error(e.getMessage());
        }
        return libros;
    }


}
