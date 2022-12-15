package Main.Controlers.existdb;

import Main.Models.Categoria;
import org.apache.log4j.Logger;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

public class ExistDB {

    //Variables de la clase para la conexion con existdb
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/Biblioteca";
    private static final String USUARIO = "admin";
    private static final String PASSWORD = "";

    //Log4j
    private static final Logger logger = org.apache.log4j.Logger.getLogger(ExistDB.class);

    //Conectar
    public static Collection conectar() {
        try {
            logger.info("Conectando a existdb");
            Class cl = Class.forName(DRIVER); //Cargar del driver
            Database database = (Database) cl.getDeclaredConstructor().newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            Collection collection = null;
            collection = DatabaseManager.getCollection(URI, USUARIO, PASSWORD); //Conectar a la BD
            logger.info("Conectado a existdb");

            //devolver la coleccion
            return collection;

        } catch (XMLDBException e) {
            logger.error("Error al inicializar la BD eXist.");
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error("Error en el driver.");
            logger.error(e.getMessage());
        } catch (InstantiationException e) {
            logger.error("Error al instanciar la BD 1.");
            logger.error(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.error("Error al instanciar la BD 2.");
            logger.error(e.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("Error al instanciar la BD 3.");
            logger.error(e.getMessage());
        } catch (NoSuchMethodException e) {
            logger.error("Error al instanciar la BD 4.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("Error general en conectar()");
            logger.error(e.getMessage());
        }

        return null;
    }

    //Desconectar
    public static void desconectar(Collection collection) {
        try {
            logger.info("Desconectando de existdb");
            collection.close();
            logger.info("Desconectado de existdb");
        } catch (XMLDBException e) {
            logger.error("Error al desconectar de existdb");
            logger.error(e.getMessage());
        }
    }

    //Importar
    public static void cargarXML(String nombreXML) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();

        //Cargar el XML
        File archivoXML = new File("./"+nombreXML+".xml");
        // Inicializamos el recurso
        XMLResource res = null;
        try {
            res = (XMLResource) collection.createResource(nombreXML+".xml", "XMLResource");
        } catch (Exception e) {
            logger.error("Error al crear el recurso");
            logger.error(e.getMessage());
        }
        try {
            res.setContent(archivoXML);
        } catch (XMLDBException e) {
            logger.error("Error al cargar el contenido del recurso");
            logger.error(e.getMessage());
        }
        try {
            collection.storeResource(res);
        } catch (XMLDBException e) {
            logger.error("Error al guardar el recurso");
            logger.error(e.getMessage());
        }

        //Listar los recursos
        try {
            for (String recurso : collection.listResources()) {
                logger.info("Recurso: " + recurso);
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar los recursos");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);
    }

    //Listar un objeto
    public static String listarObjeto(String nombreXML) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();

        //Listar el XML
        String resultado = "";
        try {
            XMLResource res = (XMLResource) collection.getResource(nombreXML+".xml");
            resultado = res.getContent().toString();
        } catch (XMLDBException e) {
            logger.error("Error al listar el recurso");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);

        //Devolver el resultado
        return resultado;
    }

    //hacer una consulta
    public static ResourceIterator consulta(String query) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();
        XPathQueryService servicio;

        String resultado = "";

        try {
            servicio = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            //Preparamos la consulta
            ResourceSet result = servicio.query(query);
            //Recorrer los datos del recurso.
            ResourceIterator i;
            i = result.getIterator();
            return i;
        } catch (XMLDBException e) {
            logger.error("Error al listar el recurso");
            logger.error(e.getMessage());
        }
        //Desconectar de existdb
        ExistDB.desconectar(collection);

        return null;




    }

    //Insertar un elemento
    public static void insertarElemento(String nombreXML, String stringXML, String elemento) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();
        ResourceSet result = null;
        //Insertar el elemento
        try {
            XMLResource res = (XMLResource) collection.getResource(nombreXML+".xml");
            XPathQueryService servicio = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            result= servicio.query("update insert " + stringXML + " into "+elemento);

        } catch (XMLDBException e) {
            logger.error("Error al insertar el elemento");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);
    }

    //Eliminar un elemento
    public static void eliminarElemento(String nombreXML, String elemento) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();
        ResourceSet result = null;
        //Eliminar el elemento
        try {
            XMLResource res = (XMLResource) collection.getResource(nombreXML+".xml");
            XPathQueryService servicio = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            result= servicio.query("update delete "+elemento);

        } catch (XMLDBException e) {
            logger.error("Error al eliminar el elemento");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);
    }

    //Mirar si existe un elemento
    public static boolean existeElemento(String nombreXML, String elemento, int id) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();
        ResourceSet result = null;
        //Eliminar el elemento
        try {
            XMLResource res = (XMLResource) collection.getResource( nombreXML+".xml");
            XPathQueryService servicio = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            result= servicio.query("for $x in "+elemento+" where $x/@id = '" + id + "' return $x");

        } catch (XMLDBException e) {
            logger.error("Error al eliminar el elemento");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);
        try {
            return result.getSize()>0;
        } catch (XMLDBException e) {
            throw new RuntimeException(e);
        }
    }

    //Devuelve el resultado de la busqueda por id del elemento
    public static String buscarElementoPorId(String categorias, String elemento, int id) {
        //Conectar a existdb
        Collection collection = null;
        collection = ExistDB.conectar();
        ResourceSet result = null;
        //Buscar el elemento
        try {
            XMLResource res = (XMLResource) collection.getResource(categorias+".xml");
            XPathQueryService servicio = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            result= servicio.query("for $x in "+elemento+" where $x/@id = '" + id + "' return $x");

        } catch (XMLDBException e) {
            logger.error("Error al eliminar el elemento");
            logger.error(e.getMessage());
        }

        //Desconectar de existdb
        ExistDB.desconectar(collection);
        try {
            return result.getResource(0).getContent().toString();
        } catch (Exception e) {
            return "";
        }
    }
}
