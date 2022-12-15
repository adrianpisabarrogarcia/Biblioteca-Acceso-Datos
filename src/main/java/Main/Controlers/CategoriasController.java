package Main.Controlers;


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
        System.out.println("Insertar categoria");
    }

    public static void modificar(Categoria categoria) {
        logger.info("Modificar categoria");
    }

    public static void eliminar(Categoria categoria) {
        logger.info("Eliminar categoria");
    }

    public static void buscar(Categoria categoria) {
        logger.info("Buscar categoria");
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
                    System.out.println(categoria);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (XMLDBException e) {
            logger.error("Error al listar categorias");
            logger.error(e.getMessage());
        }
        logger.info("Categorias listadas");

        return categorias;
    }
}
