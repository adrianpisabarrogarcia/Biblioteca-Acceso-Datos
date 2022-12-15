package Main.Controlers;


import Main.Controlers.Conveters.CategoriaConverter;
import Main.Controlers.XStream.EscribirFicherosXML;
import Main.Controlers.existdb.ExistDB;
import Main.Models.Categoria;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.util.ArrayList;

public class CategoriasController {

    private static final Logger logger = Logger.getLogger(CategoriasController.class);

    public static void insertar(Categoria categoria) {
        logger.info("Insertar categoria");

        //Pasar de objeto a String XML
        XStream xstream = new XStream();
        xstream = Categoria.prepararXStream();
        String xml = xstream.toXML(categoria);


        //Insertar en existdb
        ExistDB.insertarElemento("Categorias",xml,"/list");

        logger.info("Insertada categoria en existdb");
    }

    public static void modificar(Categoria categoria) {
        logger.info("Modificar categoria");

        eliminar(categoria);
        insertar(categoria);

        logger.info("Modificada categoria en existdb");
    }

    public static boolean existe(Categoria categoria) {
        logger.info("Existe categoria");
        boolean existe = false;

        //Comprobar si existe en existdb
        existe = ExistDB.existeElemento("Categorias","/list/categoria", categoria.getId());
        System.out.println("Existe: " + existe);

        return existe;
    }

    public static void eliminar(Categoria categoria) {
        logger.info("Eliminar categoria");

        String id = ""+categoria.getId();
        String elemento = "/list/categoria[@id='"+id+"']";
        ExistDB.eliminarElemento("Categorias",elemento);

        logger.info("Eliminada categoria en existdb");
    }

    public static ArrayList<Categoria> buscar(Categoria categoria) {
        logger.info("Buscar categoria");
        ArrayList<Categoria> categorias = new ArrayList<>();

        String query = "/list/categoria";
        //montar la query
        if(categoria.getId() != -1){
            String id = ""+categoria.getId();
            query += "[@id='"+id+"']";
        }
        if(categoria.getNombre() != null){
            query += "[nombre='"+categoria.getNombre()+"']";
        }
        if(categoria.getDescripcion() != null){
            query += "[descripcion='"+categoria.getDescripcion()+"']";
        }

        query = "for $i in doc('Categorias.xml')"+query+" return $i";


        //Buscar en existdb
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Categoria.prepararXStream();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    categoria = (Categoria) xStream.fromXML(resultado.nextResource().getContent().toString());
                    categorias.add(categoria);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar categorias");
            logger.error(e.getMessage());
        }


        return categorias;
    }

    public static Categoria buscarPorId(Categoria categoria) {
        logger.info("Buscar categoria");

        String id = ""+categoria.getId();
        String elemento = "/list/categoria[@id='"+id+"']";
        String xml = ExistDB.buscarElementoPorId("Categorias","/list/categoria", categoria.getId());
        if(xml.equals("")){
            return null;
        }
        //Pasar de String XML a objeto
        XStream xstream = Categoria.prepararXStream();
        Categoria categoriaEncontrada = (Categoria) xstream.fromXML(xml);
        return categoriaEncontrada;
    }

    public static ArrayList<Categoria> listar() {
        logger.info("Listar categorias");
        String query = "for $x in doc('Categorias.xml')//categoria return $x";
        ResourceIterator resultado = ExistDB.consulta(query);
        XStream xStream = Categoria.prepararXStream();
        ArrayList<Categoria> categorias = new ArrayList<>();
        try{
            while (resultado.hasMoreResources()) {
                try {
                    Categoria categoria = (Categoria) xStream.fromXML(resultado.nextResource().getContent().toString());
                    categorias.add(categoria);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar categorias");
            logger.error(e.getMessage());
        }
        logger.info("GestionarCategoriasView listadas");

        return categorias;
    }
}
