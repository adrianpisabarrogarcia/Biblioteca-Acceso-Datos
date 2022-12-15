package Main.Controlers;

import Main.Controlers.existdb.ExistDB;
import Main.Models.Libro;
import org.apache.log4j.Logger;

public class LibrosController {

    private static final Logger logger = Logger.getLogger(LibrosController.class);

    public static void insertar(Libro libro) {
        logger.info("Insertar libro");

    }

    public static void modificar(Libro libro) {
        System.out.println("Modificar libro");
    }

    public static void eliminar(Libro libro) {
        System.out.println("Eliminar libro");
    }

    public static void buscar(Libro libro) {
        System.out.println("Buscar libro");
    }

    public static void listar() {
        System.out.println("Listar libros");
    }
}
