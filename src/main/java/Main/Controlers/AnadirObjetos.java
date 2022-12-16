package Main.Controlers;

import Main.Models.Alquiler;
import Main.Models.Categoria;
import Main.Models.Libro;
import Main.Models.Usuario;
import java.util.ArrayList;
import java.util.Date;

public class AnadirObjetos {

    /***
     * Añade alquileres al arraylist alquileres
     * @return ArrayList<Alquiler>
     */
    public static ArrayList<Alquiler> anadirAlquileres() {

        ArrayList<Alquiler> alquileres = new ArrayList<>();
        Alquiler alquiler1 = new Alquiler();
        alquiler1.setId(1);
        alquiler1.setIdUsuario(1);
        alquiler1.setIdLibro(1);
        alquiler1.setFechaAlquiler(new Date(2021, 11, 10));
        alquiler1.setFechaDevolucion(new Date(2021, 01, 05));
        alquileres.add(alquiler1);
        Alquiler alquiler2 = new Alquiler();
        alquiler2.setId(2);
        alquiler2.setIdUsuario(2);
        alquiler2.setIdLibro(2);
        alquiler2.setFechaAlquiler(new Date(2019, 10, 10));
        alquiler2.setFechaDevolucion(new Date(2019, 12, 12));
        alquileres.add(alquiler2);
        Alquiler alquiler3 = new Alquiler();
        alquiler3.setId(3);
        alquiler3.setIdUsuario(3);
        alquiler3.setIdLibro(3);
        alquiler3.setFechaAlquiler(new Date(2022, 1, 12));
        alquiler3.setFechaDevolucion(new Date(2022, 1, 19));
        alquileres.add(alquiler3);
        Alquiler alquiler4 = new Alquiler();
        alquiler4.setId(4);
        alquiler4.setIdUsuario(4);
        alquiler4.setIdLibro(4);
        alquiler4.setFechaAlquiler(new Date(2020, 4, 01));
        alquiler4.setFechaDevolucion(new Date(2020, 4, 20));
        alquileres.add(alquiler4);
        Alquiler alquiler5 = new Alquiler();
        alquiler5.setId(5);
        alquiler5.setIdUsuario(5);
        alquiler5.setIdLibro(5);
        alquiler5.setFechaAlquiler(new Date(2022, 11, 11));
        alquiler5.setFechaDevolucion(new Date(2022, 12, 22));
        alquileres.add(alquiler5);
        Alquiler alquiler6 = new Alquiler();
        alquiler6.setId(6);
        alquiler6.setIdUsuario(6);
        alquiler6.setIdLibro(6);
        alquiler6.setFechaAlquiler(new Date(2021, 12, 12));
        alquiler6.setFechaDevolucion(new Date(2021, 12, 19));
        alquileres.add(alquiler6);
        Alquiler alquiler7 = new Alquiler();
        alquiler7.setId(7);
        alquiler7.setIdUsuario(7);
        alquiler7.setIdLibro(7);
        alquiler7.setFechaAlquiler(new Date(2021, 12, 01));
        alquiler7.setFechaDevolucion(new Date(2021, 12, 19));
        alquileres.add(alquiler7);
        Alquiler alquiler8 = new Alquiler();
        alquiler8.setId(8);
        alquiler8.setIdUsuario(8);
        alquiler8.setIdLibro(8);
        alquiler8.setFechaAlquiler(new Date(2021, 11, 12));
        alquiler8.setFechaDevolucion(new Date(2021, 11, 19));
        alquileres.add(alquiler8);
        Alquiler alquiler9 = new Alquiler();
        alquiler9.setId(9);
        alquiler9.setIdUsuario(9);
        alquiler9.setIdLibro(9);
        alquiler9.setFechaAlquiler(new Date(2020, 12, 12));
        alquiler9.setFechaDevolucion(new Date(2020, 12, 19));
        alquileres.add(alquiler9);
        Alquiler alquiler10 = new Alquiler();
        alquiler10.setId(10);
        alquiler10.setIdUsuario(10);
        alquiler10.setIdLibro(10);
        alquiler10.setFechaAlquiler(new Date(2022, 12, 12));
        alquiler10.setFechaDevolucion(new Date(2022, 12, 19));
        alquileres.add(alquiler10);

        return alquileres;
    }

    /***
     * Añade usuarios al arraylist usuarios
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
        Date fecha = new Date(1993, 07, 12);
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
        Date fecha3 = new Date(2002, 3, 23);
        usuario3.setFechaNacimiento(fecha3);
        usuarios.add(usuario3);
        Usuario usuario4 = new Usuario();
        usuario4.setId(4);
        usuario4.setNombre("Luis");
        usuario4.setApellidos("Lopez");
        usuario4.setDireccion("Calle 4");
        usuario4.setEmail("luislopez@gmail.com");
        Date fecha4 = new Date(2022, 2, 2);
        usuario4.setFechaNacimiento(fecha4);
        usuarios.add(usuario4);
        Usuario usuario5 = new Usuario();
        usuario5.setId(5);
        usuario5.setNombre("Ana");
        usuario5.setApellidos("Martinez");
        usuario5.setDireccion("Calle 5");
        usuario5.setEmail("anamartinez@gmail.com");
        Date fecha5 = new Date(1994, 5, 4);
        usuario5.setFechaNacimiento(fecha5);
        usuarios.add(usuario5);
        Usuario usuario6 = new Usuario();
        usuario6.setId(6);
        usuario6.setNombre("Jose");
        usuario6.setApellidos("Rodriguez");
        usuario6.setDireccion("Calle 6");
        usuario6.setEmail("joserodriguez@gmail.com");
        Date fecha6 = new Date(1990, 12, 12);
        usuario6.setFechaNacimiento(fecha6);
        usuarios.add(usuario6);
        Usuario usuario7 = new Usuario();
        usuario7.setId(7);
        usuario7.setNombre("Antonio");
        usuario7.setApellidos("Sanchez");
        usuario7.setDireccion("Calle 7");
        usuario7.setEmail("antoniosanchez@gmail.com");
        Date fecha7 = new Date(2022, 06, 06);
        usuario7.setFechaNacimiento(fecha7);
        usuarios.add(usuario7);
        Usuario usuario8 = new Usuario();
        usuario8.setId(8);
        usuario8.setNombre("Maria");
        usuario8.setApellidos("Gonzalez");
        usuario8.setDireccion("Calle 8");
        usuario8.setEmail("mariagonzalez@gmail.com");
        Date fecha8 = new Date(1995, 04, 06);
        usuario8.setFechaNacimiento(fecha8);
        usuarios.add(usuario8);
        Usuario usuario9 = new Usuario();
        usuario9.setId(9);
        usuario9.setNombre("Francisco");
        usuario9.setApellidos("Fernandez");
        usuario9.setDireccion("Calle 9");
        usuario9.setEmail("franciscofernandez@gmail.com");
        Date fecha9 = new Date(1990, 01, 30);
        usuario9.setFechaNacimiento(fecha9);
        usuarios.add(usuario9);
        Usuario usuario10 = new Usuario();
        usuario10.setId(10);
        usuario10.setNombre("Luis");
        usuario10.setApellidos("Hernandez");
        usuario10.setDireccion("Calle 10");
        usuario10.setEmail("luishernandez@gmail.com");
        Date fecha10 = new Date(2000, 12, 01);
        usuario10.setFechaNacimiento(fecha10);
        usuarios.add(usuario10);

        return usuarios;
    }

    /***
     * Añade libros al arraylist libros
     * @return ArrayList<Libro>
     */
    public static ArrayList<Categoria> anadirCategoriasLibros() {
        ArrayList<Categoria> categorias = new ArrayList<>();

        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNombre("Aventuras");
        categoria1.setDescripcion("Libros de aventuras");
        categorias.add(categoria1);
        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNombre("Ciencia Ficción");
        categoria2.setDescripcion("Libros de ciencia ficción");
        categorias.add(categoria2);
        Categoria categoria3 = new Categoria();
        categoria3.setId(3);
        categoria3.setNombre("Fantasía");
        categoria3.setDescripcion("Libros de fantasía");
        categorias.add(categoria3);
        Categoria categoria4 = new Categoria();
        categoria4.setId(4);
        categoria4.setNombre("Romántica");
        categoria4.setDescripcion("Libros de romántica");
        categorias.add(categoria4);
        Categoria categoria5 = new Categoria();
        categoria5.setId(5);
        categoria5.setNombre("Terror");
        categoria5.setDescripcion("Libros de terror");
        categorias.add(categoria5);

        return categorias;
    }


    /***
     * Añade libros al arraylist libros
     * @return ArrayList<Libro>
     */
    public static ArrayList<Libro> anadirLibros(ArrayList<Categoria> categorias) {
        ArrayList<Libro> libros = new ArrayList<>();

        Libro l1 = new Libro();
        l1.setId(1);
        l1.setTitulo("El señor de los anillos");
        l1.setAutor("J.R.R. Tolkien");
        l1.setEditorial("Minotauro");
        l1.setAnio(1954);
        l1.setIsbn("978-84-450-0494-7");
        l1.setCategoria(categorias.get(0));
        libros.add(l1);
        Libro l2 = new Libro();
        l2.setId(2);
        l2.setTitulo("El principito");
        l2.setAutor("Antoine de Saint-Exupéry");
        l2.setEditorial("Minotauro");
        l2.setAnio(1943);
        l2.setIsbn("978-84-450-0494-7");
        l2.setCategoria(categorias.get(1));
        libros.add(l2);
        Libro l3 = new Libro();
        l3.setId(3);
        l3.setTitulo("El hobbit");
        l3.setAutor("J.R.R. Tolkien");
        l3.setEditorial("Minotauro");
        l3.setAnio(1937);
        l3.setIsbn("978-84-450-0494-7");
        l3.setCategoria(categorias.get(2));
        libros.add(l3);
        Libro l4 = new Libro();
        l4.setId(4);
        l4.setTitulo("El nombre del viento");
        l4.setAutor("Patrick Rothfuss");
        l4.setEditorial("Minotauro");
        l4.setAnio(2007);
        l4.setIsbn("978-84-450-0494-7");
        l4.setCategoria(categorias.get(3));
        libros.add(l4);
        Libro l5 = new Libro();
        l5.setId(5);
        l5.setTitulo("El código Da Vinci");
        l5.setAutor("Dan Brown");
        l5.setEditorial("Minotauro");
        l5.setAnio(2003);
        l5.setIsbn("978-84-450-0494-7");
        l5.setCategoria(categorias.get(4));
        libros.add(l5);
        Libro l6 = new Libro();
        l6.setId(6);
        l6.setTitulo("El alquimista");
        l6.setAutor("Paulo Coelho");
        l6.setEditorial("Minotauro");
        l6.setAnio(1988);
        l6.setIsbn("978-84-450-0494-7");
        l6.setCategoria(categorias.get(0));
        libros.add(l6);
        Libro l7 = new Libro();
        l7.setId(7);
        l7.setTitulo("El diario de Ana Frank");
        l7.setAutor("Ana Frank");
        l7.setEditorial("Minotauro");
        l7.setAnio(1947);
        l7.setIsbn("978-84-450-0494-7");
        l7.setCategoria(categorias.get(1));
        libros.add(l7);
        Libro l8 = new Libro();
        l8.setId(8);
        l8.setTitulo("El perfume");
        l8.setAutor("Patrick Süskind");
        l8.setEditorial("Minotauro");
        l8.setAnio(1985);
        l8.setIsbn("978-84-450-0494-7");
        l8.setCategoria(categorias.get(2));
        libros.add(l8);
        Libro l9 = new Libro();
        l9.setId(9);
        l9.setTitulo("El juego del ángel");
        l9.setAutor("Carlos Ruiz Zafón");
        l9.setEditorial("Minotauro");
        l9.setAnio(2001);
        l9.setIsbn("978-84-450-0494-7");
        l9.setCategoria(categorias.get(3));
        libros.add(l9);
        Libro l10 = new Libro();
        l10.setId(10);
        l10.setTitulo("El código Da Vinci");
        l10.setAutor("Dan Brown");
        l10.setEditorial("Minotauro");
        l10.setAnio(2003);
        l10.setIsbn("978-84-450-0494-7");
        l10.setCategoria(categorias.get(4));
        libros.add(l10);

        return libros;
    }

}
