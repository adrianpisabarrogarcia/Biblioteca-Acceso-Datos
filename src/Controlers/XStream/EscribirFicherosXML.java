package Controlers.XStream;

import Controlers.XStream.SpecificModels.AlquilerLibroUsuario;
import Models.Alquiler;
import Models.Libro;
import Models.Usuario;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EscribirFicherosXML {

    public static void generarEstadisticasAlquileres(ArrayList<Alquiler> alquileres, int month, int year) {
        //Convertir arraylist a lista
        ListaAlquileresEstadisticas listaAlquileres = new ListaAlquileresEstadisticas(alquileres);

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());

        //Añadir alias
        xstream.alias("AlquileresEstadisticasMonth"+month+"Year"+year, ListaAlquileresEstadisticas.class);
        xstream.alias("Alquiler", Alquiler.class);
        xstream.addImplicitCollection(ListaAlquileresEstadisticas.class,"alquileres");

        //Escribir fichero XML
        try {
            xstream.toXML(listaAlquileres, new FileOutputStream("AlquileresEstadisticas.xml"));
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero XML");
        }
    }


    public static void generarAlquileresLibrosUsuarios(ArrayList<AlquilerLibroUsuario> alquileres) {
        //Convertir arraylist a lista
        ListaAlquileresLibrosUsuarios listaAlquileresLibrosUsuarios = new ListaAlquileresLibrosUsuarios(alquileres);

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());

        //Añadir alias
        xstream.alias("AlquileresLibrosUsuarios", ListaAlquileresLibrosUsuarios.class);
        xstream.alias("alquiler", Alquiler.class);
        xstream.alias("usuario", Usuario.class);
        xstream.alias("libro", Libro.class);
        xstream.addImplicitCollection(ListaAlquileresEstadisticas.class,"alquileres");

        //Escribir fichero XML
        try {
            xstream.toXML(listaAlquileresLibrosUsuarios, new FileOutputStream("AlquileresLibrosUsuarios.xml"));
            System.out.println("Fichero XML generado correctamente. AlquileresLibrosUsuarios.xml");
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero XML");
        }
    }
}
