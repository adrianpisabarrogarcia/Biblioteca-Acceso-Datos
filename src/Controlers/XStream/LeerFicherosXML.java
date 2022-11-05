package Controlers.XStream;

import Models.Alquiler;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeerFicherosXML {

        public static ArrayList<Alquiler> leerEstadisticasAlquileres(int month, int year) {
            ArrayList<Alquiler> alquileres = new ArrayList<>();
            //Crear fichero XML
            XStream xstream = new XStream(new DomDriver());
            //Allow all classes
            xstream.addPermission(AnyTypePermission.ANY);



            //Añadir alias
            xstream.alias("AlquileresEstadisticasMonth"+month+"Year"+year, ListaAlquileresEstadisticas.class);
            xstream.alias("Alquiler", Models.Alquiler.class);
            xstream.addImplicitCollection(ListaAlquileresEstadisticas.class,"alquileres");


            //Acceder al fichero XML
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("AlquileresEstadisticas.xml");
            } catch (FileNotFoundException e) {
                System.out.println("Error al leer el fichero XML, no existe");
                System.out.println(e.getMessage());
            }

            //Deserializar
                ListaAlquileresEstadisticas listaAlquileresEstadisticas = (ListaAlquileresEstadisticas) xstream.fromXML(fis);
                alquileres = (ArrayList<Alquiler>) listaAlquileresEstadisticas.getAlquileres();

            return alquileres;
        }
}
