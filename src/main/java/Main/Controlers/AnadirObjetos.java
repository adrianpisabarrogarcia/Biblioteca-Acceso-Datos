package Main.Controlers;

import Main.Controlers.dat.EscribirFicheros;
import Main.Models.Alquiler;
import Main.Models.Libro;
import Main.Models.Usuario;
import java.util.ArrayList;
import java.util.Date;

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
        Usuario usuario4 = new Usuario();
        usuario4.setId(4);
        usuario4.setNombre("Luis");
        usuario4.setApellidos("Lopez");
        usuario4.setDireccion("Calle 4");
        usuario4.setEmail("luislopez@gmail.com");
        Date fecha4 = new Date(1990, 12, 12);
        usuario4.setFechaNacimiento(fecha4);
        usuarios.add(usuario4);
        Usuario usuario5 = new Usuario();
        usuario5.setId(5);
        usuario5.setNombre("Ana");
        usuario5.setApellidos("Martinez");
        usuario5.setDireccion("Calle 5");
        usuario5.setEmail("anamartinez@gmail.com");
        Date fecha5 = new Date(1990, 12, 12);
        usuario5.setFechaNacimiento(fecha5);
        usuarios.add(usuario5);

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
        Libro l6 = new Libro();
        l6.setId(6);
        l6.setTitulo("El alquimista");
        l6.setAutor("Paulo Coelho");
        l6.setEditorial("Minotauro");
        l6.setAnio(1988);
        l6.setIsbn("978-84-450-0494-7");
        libros.add(l6);
        Libro l7 = new Libro();
        l7.setId(7);
        l7.setTitulo("El diario de Ana Frank");
        l7.setAutor("Ana Frank");
        l7.setEditorial("Minotauro");
        l7.setAnio(1947);
        l7.setIsbn("978-84-450-0494-7");
        libros.add(l7);
        Libro l8 = new Libro();
        l8.setId(8);
        l8.setTitulo("El perfume");
        l8.setAutor("Patrick Süskind");
        l8.setEditorial("Minotauro");
        l8.setAnio(1985);
        l8.setIsbn("978-84-450-0494-7");
        libros.add(l8);
        Libro l9 = new Libro();
        l9.setId(9);
        l9.setTitulo("El juego del ángel");
        l9.setAutor("Carlos Ruiz Zafón");
        l9.setEditorial("Minotauro");
        l9.setAnio(2001);
        l9.setIsbn("978-84-450-0494-7");
        libros.add(l9);
        Libro l10 = new Libro();
        l10.setId(10);
        l10.setTitulo("El código Da Vinci");
        l10.setAutor("Dan Brown");
        l10.setEditorial("Minotauro");
        l10.setAnio(2003);
        l10.setIsbn("978-84-450-0494-7");
        libros.add(l10);
        Libro l11 = new Libro();
        l11.setId(11);
        l11.setTitulo("El código Da Vinci");
        l11.setAutor("Dan Brown");
        l11.setEditorial("Minotauro");
        l11.setAnio(2003);
        l11.setIsbn("978-84-450-0494-7");
        libros.add(l11);
        Libro l12 = new Libro();
        l12.setId(12);
        l12.setTitulo("El código Da Vinci");
        l12.setAutor("Dan Brown");
        l12.setEditorial("Minotauro");
        l12.setAnio(2003);
        l12.setIsbn("978-84-450-0494-7");
        libros.add(l12);
        Libro l13 = new Libro();
        l13.setId(13);
        l13.setTitulo("El código Da Vinci");
        l13.setAutor("Dan Brown");
        l13.setEditorial("Minotauro");
        l13.setAnio(2003);
        l13.setIsbn("978-84-450-0494-7");
        libros.add(l13);



        EscribirFicheros.escribirFicheroLibros(libros);

        return libros;
    }

}
