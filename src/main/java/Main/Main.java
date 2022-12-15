package Main;

import Main.Controlers.AnadirObjetos;
import Main.Controlers.CategoriasController;
import Main.Controlers.XStream.EscribirFicherosXML;
import Main.Controlers.XStream.LeerFicherosXML;
import Main.Controlers.XStream.ListaAlquileresLibrosUsuarios;
import Main.Controlers.XStream.SpecificModels.AlquilerLibroUsuario;
import Main.Controlers.XStream.SpecificModels.CategoriaLibros;
import Main.Controlers.dat.EscribirFicheros;
import Main.Controlers.dat.LeerFicheros;
import Main.Controlers.existdb.ExistDB;
import Main.Models.Alquiler;
import Main.Models.Categoria;
import Main.Models.Libro;
import Main.Models.Usuario;
import Main.Views.PantallaPrincipal;
import org.apache.log4j.Logger;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //Generar los archivos xmls del punto 1
        generarXMLAlquilerLibroCategoriaUsuario();
        generarXMLCategoriaLibro();
        generarXMLUsuarios();
        generarXMLCategoria();
        generarXMLLibro();

        //Cargar los archivos xmls en existdb
        ExistDB.cargarXML("AlquileresLibrosCategoriasUsuarios");
        ExistDB.cargarXML("ListaCategoriasLibros");
        ExistDB.cargarXML("Libros");
        ExistDB.cargarXML("Categorias");
        ExistDB.cargarXML("Usuarios");

        //Cargar la vista principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);

        ArrayList<Categoria> categorias = CategoriasController.listar();


    }

    private static void generarXMLLibro() {
        logger.info("Generando XML Libros");
        ArrayList<Categoria> categorias = AnadirObjetos.anadirCategoriasLibros();
        ArrayList<Libro> libros = AnadirObjetos.anadirLibros(categorias);
        EscribirFicherosXML.generarLibros(libros);
        logger.info("XML Libros generado");
    }

    private static void generarXMLCategoria() {
        logger.info("Generando XML Categorias");
        ArrayList<Categoria> categorias = AnadirObjetos.anadirCategoriasLibros();
        EscribirFicherosXML.generarCategorias(categorias);
        logger.info("XML Categorias generado");
    }

    private static void generarXMLUsuarios() {
        logger.info("Generando XML Categorias");
        ArrayList<Usuario> usuarios = AnadirObjetos.anadirUsuarios();
        EscribirFicherosXML.generarUsuarios(usuarios);
        logger.info("XML Categorias generado");
        
    }

    private static void generarXMLCategoriaLibro() {
        logger.info("Generando XML de categorias y libros");
        //Crear objetos
        ArrayList<Categoria> categoriasLibros = AnadirObjetos.anadirCategoriasLibros();
        ArrayList<Libro> libros = AnadirObjetos.anadirLibros(categoriasLibros);

        //Crear lista de categorias y libros
        ArrayList<CategoriaLibros> listaCategoriasLibros = new ArrayList<CategoriaLibros>();
        for (Categoria categoria : categoriasLibros) {
            CategoriaLibros categoriaLibros = new CategoriaLibros();
            categoriaLibros.setId(categoria.getId());
            categoriaLibros.setNombre(categoria.getNombre());
            categoriaLibros.setDescripcion(categoria.getDescripcion());
            for (Libro libro : libros) {
                if (libro.getCategoria().getId() == categoria.getId()) {
                    categoriaLibros.getLibros().add(libro);
                }
            }
            listaCategoriasLibros.add(categoriaLibros);
        }
        EscribirFicherosXML.generarCategoriasLibros(listaCategoriasLibros);
        logger.info("Generado XML de categorias y libros");
    }

    private static void generarXMLAlquilerLibroCategoriaUsuario() {
        logger.info("Generando XML de Alquileres, Libros, Categorias y Usuarios");
        //Crear objetos
        ArrayList<Usuario> usuarios = AnadirObjetos.anadirUsuarios();
        ArrayList<Categoria> categoriasLibros = AnadirObjetos.anadirCategoriasLibros();
        ArrayList<Libro> libros = AnadirObjetos.anadirLibros(categoriasLibros);
        ArrayList<Alquiler> alquileres = AnadirObjetos.anadirAlquileres();

        //Generar XMLs
        ArrayList<AlquilerLibroUsuario> alquileresLibroUsuarios = new ArrayList<>();
        for (Alquiler alquiler : alquileres) {
            AlquilerLibroUsuario alquilerLibroUsuario = new AlquilerLibroUsuario();
            alquilerLibroUsuario.setId(alquiler.getId());
            alquilerLibroUsuario.setFechaAlquiler(alquiler.getFechaAlquiler());
            alquilerLibroUsuario.setFechaDevolucion(alquiler.getFechaDevolucion());
            for (Libro libro : libros) {
                if (alquiler.getIdLibro() == libro.getId()) {
                    alquilerLibroUsuario.setLibro(libro);
                    break;
                }
            }
            for (Usuario usuario : usuarios) {
                if (alquiler.getIdUsuario() == usuario.getId()) {
                    alquilerLibroUsuario.setUsuario(usuario);
                    break;
                }
            }
            alquileresLibroUsuarios.add(alquilerLibroUsuario);
        }
        EscribirFicherosXML.generarAlquileresLibrosUsuarios(alquileresLibroUsuarios);
        logger.info("XML de Alquileres, Libros, Categorias y Usuarios generado");
    }

}