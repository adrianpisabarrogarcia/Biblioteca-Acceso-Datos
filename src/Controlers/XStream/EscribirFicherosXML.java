package Controlers.XStream;

import Models.Alquiler;
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
}
