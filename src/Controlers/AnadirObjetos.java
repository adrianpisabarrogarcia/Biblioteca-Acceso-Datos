package Controlers;

import Models.Alquiler;
import Models.Libro;
import Models.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class AnadirObjetos {

    public static ArrayList<Alquiler> anadirAlquileres() {

        ArrayList<Alquiler> alquileres = new ArrayList<>();

        Alquiler alquiler1 = new Alquiler();
        alquiler1.setId(1);
        alquiler1.setFechaAlquiler(new Date());
        alquiler1.setFechaDevolucion(null);
        alquiler1.setIdLibro(1);
        alquiler1.setIdUsuario(1);
        alquileres.add(alquiler1);
        Alquiler alquiler2 = new Alquiler();
        alquiler2.setId(2);
        alquiler2.setFechaAlquiler(new Date());
        alquiler2.setFechaDevolucion(null);
        alquiler2.setIdLibro(2);
        alquiler2.setIdUsuario(2);
        alquileres.add(alquiler2);
        Alquiler alquiler3 = new Alquiler();
        alquiler3.setId(3);
        alquiler3.setFechaAlquiler(new Date());
        alquiler3.setFechaDevolucion(null);
        alquiler3.setIdLibro(3);
        alquiler3.setIdUsuario(3);
        alquileres.add(alquiler3);
        Alquiler alquiler4 = new Alquiler();
        alquiler4.setId(4);
        alquiler4.setFechaAlquiler(new Date());
        alquiler4.setFechaDevolucion(null);
        alquiler4.setIdLibro(4);
        alquiler4.setIdUsuario(4);
        alquileres.add(alquiler4);
        Alquiler alquiler5 = new Alquiler();
        alquiler5.setId(5);
        alquiler5.setFechaAlquiler(new Date());
        alquiler5.setFechaDevolucion(null);
        alquiler5.setIdLibro(5);
        alquiler5.setIdUsuario(5);
        alquileres.add(alquiler5);
        Alquiler alquiler6 = new Alquiler();
        alquiler6.setId(6);
        alquiler6.setFechaAlquiler(new Date());
        alquiler6.setFechaDevolucion(null);
        alquiler6.setIdLibro(6);
        alquiler6.setIdUsuario(6);
        alquileres.add(alquiler6);
        Alquiler alquiler7 = new Alquiler();
        alquiler7.setId(7);
        alquiler7.setFechaAlquiler(new Date());
        alquiler7.setFechaDevolucion(null);
        alquiler7.setIdLibro(7);
        alquiler7.setIdUsuario(7);
        alquileres.add(alquiler7);

        return alquileres;
    }

    public static ArrayList<Usuario> anadirUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setNombre("Juan");
        usuario1.setApellidos("Perez");
        usuario1.setDireccion("Calle 1");
        usuario1.setEmail("juanperez@gmail.com");
        usuarios.add(usuario1);
        Date fecha = new Date(1990, 12, 12);
        usuario1.setFechaNacimiento(fecha);
        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Maria");
        usuario2.setApellidos("Gomez");
        usuario2.setDireccion("Calle 2");
        usuario2.setEmail("mariagomez@gmail.com");
        Date fecha2 = new Date(1990, 12, 12);
        usuario2.setFechaNacimiento(fecha2);
        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setNombre("Pedro");
        usuario3.setApellidos("Garcia");
        usuario3.setDireccion("Calle 3");
        usuario3.setEmail("pedrogarcia@gmail.com");
        Date fecha3 = new Date(1990, 12, 12);
        usuario3.setFechaNacimiento(fecha3);


        return usuarios;
    }

    public static ArrayList<Libro> anadirLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        Libro l1 = new Libro();
        l1.setTitulo("El señor de los anillos");
        l1.setAutor("J.R.R. Tolkien");
        l1.setEditorial("Minotauro");
        l1.setAnio(1954);
        l1.setIsbn("978-84-450-0494-7");
        libros.add(l1);
        Libro l2 = new Libro();
        l2.setTitulo("El principito");
        l2.setAutor("Antoine de Saint-Exupéry");
        l2.setEditorial("Minotauro");
        l2.setAnio(1943);
        l2.setIsbn("978-84-450-0494-7");
        libros.add(l2);
        Libro l3 = new Libro();
        l3.setTitulo("El hobbit");
        l3.setAutor("J.R.R. Tolkien");
        l3.setEditorial("Minotauro");
        l3.setAnio(1937);
        l3.setIsbn("978-84-450-0494-7");
        libros.add(l3);
        Libro l4 = new Libro();
        l4.setTitulo("El nombre del viento");
        l4.setAutor("Patrick Rothfuss");
        l4.setEditorial("Minotauro");
        l4.setAnio(2007);
        l4.setIsbn("978-84-450-0494-7");
        libros.add(l4);
        Libro l5 = new Libro();
        l5.setTitulo("El código Da Vinci");
        l5.setAutor("Dan Brown");
        l5.setEditorial("Minotauro");
        l5.setAnio(2003);
        l5.setIsbn("978-84-450-0494-7");
        libros.add(l5);

        return libros;
    }

}
