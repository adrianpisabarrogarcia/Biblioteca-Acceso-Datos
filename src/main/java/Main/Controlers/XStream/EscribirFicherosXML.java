package Main.Controlers.XStream;

import Main.Controlers.Conveters.UsuarioConverter;
import Main.Controlers.XStream.SpecificModels.AlquilerLibroUsuario;
import Main.Controlers.XStream.SpecificModels.CategoriaLibros;
import Main.Main;
import Main.Models.Alquiler;
import Main.Models.Categoria;
import Main.Models.Libro;
import Main.Models.Usuario;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class EscribirFicherosXML {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(EscribirFicherosXML.class);


    //Objetos normales
    public static void generarLibros(ArrayList<Libro> librosArrayList) {
        //Convertir arraylist a lista
        //ListaCategoriasLibros listaCategoriasLibros = new ListaCategoriasLibros(categoriaLibrosArrayList);

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());
        //No hacer referencias
        xstream.setMode(XStream.NO_REFERENCES);

        //Añadir alias
        xstream.alias("libro", Libro.class);
        xstream.alias("categoria", Categoria.class);
        //Añadir atributos
        xstream.useAttributeFor(Libro.class, "id");
        xstream.useAttributeFor(Categoria.class, "id");

        //Escribir fichero XML
        try {
            xstream.toXML(librosArrayList, new FileOutputStream("Libros.xml"));
            logger.info("Fichero XML ListaCategoriasLibros.xml generado");
        } catch (Exception e) {
            logger.error("Error al escribir el fichero XML");
            logger.error(e.getMessage());
        }
    }
    public static void generarCategorias(ArrayList<Categoria> categoriasArrayList) {
        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());
        //No hacer referencias
        xstream.setMode(XStream.NO_REFERENCES);

        //Añadir alias
        xstream.alias("categoria", Categoria.class);
        //Añadir atributos
        xstream.useAttributeFor(Categoria.class, "id");

        //Escribir fichero XML
        try {
            xstream.toXML(categoriasArrayList, new FileOutputStream("Categorias.xml"));
            logger.info("Fichero XML GestionarCategoriasView.xml generado");
        } catch (Exception e) {
            logger.error("Error al escribir GestionarCategoriasView el fichero XML");
            logger.error(e.getMessage());
        }
    }
    public static void generarUsuarios(ArrayList<Usuario> usuariosArrayList) {

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());
        //No hacer referencias
        xstream.setMode(XStream.NO_REFERENCES);

        //Añadir alias
        xstream.alias("usuario", Usuario.class);
        //Añadir atributos
        xstream.useAttributeFor(Usuario.class, "id");

        //utilizar usuarioConverter
        xstream.registerConverter(new UsuarioConverter());

        //Escribir fichero XML
        try {
            xstream.toXML(usuariosArrayList, new FileOutputStream("Usuarios.xml"));
            logger.info("Fichero XML Usuarios.xml generado");
        } catch (Exception e) {
            logger.error("Error al escribir Usuarios el fichero XML");
            logger.error(e.getMessage());
        }
    }

    //Relaciones
    public static void generarCategoriasLibros(ArrayList<CategoriaLibros> categoriaLibrosArrayList) {
        //Convertir arraylist a lista
        ListaCategoriasLibros listaCategoriasLibros = new ListaCategoriasLibros(categoriaLibrosArrayList);

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());
        //No hacer referencias
        xstream.setMode(XStream.NO_REFERENCES);

        //Añadir alias
        xstream.alias("Lista", ListaCategoriasLibros.class);
        xstream.alias("Categoria", CategoriaLibros.class);
        xstream.alias("Libro", Libro.class);
        //xstream.addImplicitCollection(ListaCategoriasLibros.class,"listaCategorias");
        //Añadir atributos
        xstream.useAttributeFor(CategoriaLibros.class, "id");
        xstream.useAttributeFor(Libro.class, "id");

        //Escribir fichero XML
        try {
            xstream.toXML(listaCategoriasLibros, new FileOutputStream("ListaCategoriasLibros.xml"));
            logger.info("Fichero XML ListaCategoriasLibros.xml generado");
        } catch (Exception e) {
            logger.error("Error al escribir el fichero XML");
            logger.error(e.getMessage());
        }
    }
    public static void generarAlquileresLibrosUsuarios(ArrayList<AlquilerLibroUsuario> alquileres) {
        //Convertir arraylist a lista
        ListaAlquileresLibrosUsuarios listaAlquileresLibrosUsuarios = new ListaAlquileresLibrosUsuarios(alquileres);

        //Crear fichero XML
        XStream xstream = new XStream(new DomDriver());
        //Make no references on the XML
        xstream.setMode(XStream.NO_REFERENCES);

        //Añadir alias
        xstream.alias("AlquileresLibrosUsuarios", ListaAlquileresLibrosUsuarios.class);
        //Añadir alias al alquiler
        xstream.alias("alquiler", AlquilerLibroUsuario.class);
        //Añadir aleas al usuario
        xstream.alias("usuario", Usuario.class);
        //Añadir alias al libro
        xstream.alias("libro", Libro.class);
        //Añadir alias a la categoria
        xstream.alias("categoria", Categoria.class);
        //Añadir alias a la lista
        //xstream.addImplicitCollection(ListaCategoriasLibros.class,"alquileres");
        //Añadir el id del alquiler como atributo
        xstream.useAttributeFor(AlquilerLibroUsuario.class, "id");
        //Añadir el id de usuario como atributo
        xstream.useAttributeFor(Usuario.class, "id");
        //Añadir el id del libro como atributo
        xstream.useAttributeFor(Libro.class, "id");
        //Añadir el id de categoria como atributo
        xstream.useAttributeFor(Categoria.class, "id");

        //Escribir fichero XML
        try {
            xstream.toXML(listaAlquileresLibrosUsuarios, new FileOutputStream("AlquileresLibrosCategoriasUsuarios.xml"));
            logger.info("Fichero XML generado correctamente. AlquileresLibrosCategoriasUsuarios.xml");
        } catch (Exception e) {
            logger.error("Error al escribir el fichero XML. AlquileresLibrosCategoriasUsuarios.xml");
            logger.error(e.getMessage());

        }
    }
}
