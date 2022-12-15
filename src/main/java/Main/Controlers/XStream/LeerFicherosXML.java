package Main.Controlers.XStream;

import Main.Controlers.XStream.SpecificModels.CategoriaLibros;
import Main.Models.Alquiler;
import Main.Models.Categoria;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LeerFicherosXML {
    /*
        public static ArrayList<Alquiler> leerEstadisticasAlquileres(int month, int year) {
            ArrayList<Alquiler> alquileres = new ArrayList<>();
            //Crear fichero XML
            XStream xstream = new XStream(new DomDriver());
            //Allow all classes
            xstream.addPermission(AnyTypePermission.ANY);



            //Añadir alias
            xstream.alias("AlquileresEstadisticasMonth"+month+"Year"+year, ListaCategoriasLibros.class);
            xstream.alias("Alquiler", Alquiler.class);
            xstream.addImplicitCollection(ListaCategoriasLibros.class,"alquileres");


            //Acceder al fichero XML
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("AlquileresEstadisticas.xml");
            } catch (FileNotFoundException e) {
                System.out.println("Error al leer el fichero XML, no existe");
                System.out.println(e.getMessage());
            }

            //Deserializar
                ListaCategoriasLibros listaAlquileresEstadisticas = (ListaCategoriasLibros) xstream.fromXML(fis);
                alquileres = (ArrayList<CategoriaLibros>) listaAlquileresEstadisticas.getCategoriaLibros();

            return alquileres;
        }

    */

}
