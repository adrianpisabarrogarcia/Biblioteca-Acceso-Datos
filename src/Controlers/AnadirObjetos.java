package Controlers;

import Controlers.dat.EscribirFicheros;
import Models.Alquiler;
import Models.Libro;
import Models.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AnadirObjetos {

    /***
     * Añade alquileres al arraylist alquileres y los guarda en el fichero alquileres.dat
     * @return ArrayList<Alquiler>
     */
    public static ArrayList<Alquiler> anadirAlquileres() {

        ArrayList<Alquiler> alquileres = new ArrayList<>();
        Alquiler alquiler2 = new Alquiler();
        alquiler2.setId(1);
        alquiler2.setFechaAlquiler(new Date());
        alquiler2.setFechaDevolucion(null);
        alquiler2.setIdLibro(2);
        alquiler2.setIdUsuario(2);
        alquileres.add(alquiler2);

        EscribirFicheros.escribirFicheroAlquileres(alquileres);

        return alquileres;
    }

    /***
     * Añade usuarios al arraylist usuarios y los guarda en el fichero usuarios.dat
     * @return ArrayList<Usuario>
     */
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
        usuarios.add(usuario2);
        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setNombre("Pedro");
        usuario3.setApellidos("Garcia");
        usuario3.setDireccion("Calle 3");
        usuario3.setEmail("pedrogarcia@gmail.com");
        Date fecha3 = new Date(1990, 12, 12);
        usuario3.setFechaNacimiento(fecha3);
        usuarios.add(usuario3);

        EscribirFicheros.escribirFicheroUsuarios(usuarios);

        return usuarios;
    }

    /***
     * Añade libros al arraylist lirbos y los guarda en el fichero libros.dat
     * @return ArrayList<Libro>
     */
    public static ArrayList<Libro> anadirLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        Libro l1 = new Libro();
        l1.setId(1);
        l1.setTitulo("El señor de los anillos");
        l1.setAutor("J.R.R. Tolkien");
        l1.setEditorial("Minotauro");
        l1.setAnio(1954);
        l1.setIsbn("978-84-450-0494-7");
        libros.add(l1);
        Libro l2 = new Libro();
        l2.setId(2);
        l2.setTitulo("El principito");
        l2.setAutor("Antoine de Saint-Exupéry");
        l2.setEditorial("Minotauro");
        l2.setAnio(1943);
        l2.setIsbn("978-84-450-0494-7");
        libros.add(l2);
        Libro l3 = new Libro();
        l3.setId(3);
        l3.setTitulo("El hobbit");
        l3.setAutor("J.R.R. Tolkien");
        l3.setEditorial("Minotauro");
        l3.setAnio(1937);
        l3.setIsbn("978-84-450-0494-7");
        libros.add(l3);
        Libro l4 = new Libro();
        l4.setId(4);
        l4.setTitulo("El nombre del viento");
        l4.setAutor("Patrick Rothfuss");
        l4.setEditorial("Minotauro");
        l4.setAnio(2007);
        l4.setIsbn("978-84-450-0494-7");
        libros.add(l4);
        Libro l5 = new Libro();
        l5.setId(5);
        l5.setTitulo("El código Da Vinci");
        l5.setAutor("Dan Brown");
        l5.setEditorial("Minotauro");
        l5.setAnio(2003);
        l5.setIsbn("978-84-450-0494-7");
        libros.add(l5);

        EscribirFicheros.escribirFicheroLibros(libros);

        return libros;
    }

}
