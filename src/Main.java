import Controlers.AnadirObjetos;
import Controlers.dat.EscribirFicheros;
import Controlers.dat.LeerFicheros;
import Models.Alquiler;
import Models.Libro;
import Models.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Controlers.AnadirObjetos.anadirLibros;

public class Main {
    public static void main(String[] args) {
        //Añadir objetos
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        libros = AnadirObjetos.anadirLibros();
        usuarios = AnadirObjetos.anadirUsuarios();
        alquileres = AnadirObjetos.anadirAlquileres();
        System.out.println("✅ Ficheros cargados correctamente.");
        System.out.println("Vamos a iniciar sesión.");

        //Iniciar sesión
        Usuario usuario = new Usuario();
        usuario = iniciarSesion(usuarios);

        //Menú de selección
        int seleccion = 0;
        while (seleccion != 7){
            System.out.println("Menú de la biblioteca:");
            seleccion = menu();
            switch (seleccion){
                case 1:
                    System.out.println("⭐️ Alquilar libro ⭐️");
                    alquilarLibro(usuario);
                    System.out.println("Has terminado de alquilar libros.");
                    break;
                case 2:
                    System.out.println("️⭐️ Devolver libro ⭐️");
                    devolverLibro();
                    System.out.println("Has terminado de devolver un libro.");
                    break;
                case 3:
                    System.out.println("⭐️ Generar estadísticas ⭐️");
                    generarEstadisticas();
                    System.out.println("Has terminado de generar estadísticas.");
                    break;
                case 4:
                    System.out.println("⭐️ Añadir Libro ⭐️");
                    anadirLibro();
                    System.out.println("Has terminado de añadir un libro.");
                    break;
                case 5:
                    System.out.println("⭐️ Dar de alta usuarios ⭐️");
                    darAltaUsuario();
                    System.out.println("Has terminado de dar de alta un usuario.");
                    break;
                case 6:
                    System.out.println("⭐️ Exportar alquileres ⭐️");
                    exportarAlquileres();
                    System.out.println("Has terminado de exportar alquileres.");
                    break;
                case 7:
                    System.out.println("💨 Saliendo...");
                    break;
                default:
                    System.out.println("⚠️ Opción no valida");
                    break;
            }
            System.out.println("******************");
        }
    }

    //Iniciar sesión con un usuario
    private static Usuario iniciarSesion(ArrayList<Usuario> usuarios) {
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id de usuario con el que quieres acceder:");
        for (Usuario u: usuarios) {
            System.out.println(u.toString());
        }
        int id = 0;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("⚠️ El id introducido no es válido.");
            iniciarSesion(usuarios);
        }
        boolean encontrado = false;
        for (Usuario u: usuarios) {
            if (u.getId() == id){
                usuario = u;
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("⚠️ Usuario no encontrado.");
            iniciarSesion(usuarios);
        }
        System.out.println("✅ Usuario encontrado y haciendo login, bienvenid@ " + usuario.getNombre());
        return usuario;
    }

    //Menú de selección
    public static int menu(){
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Alquilar libro");
        System.out.println("2. Devolver libro");
        System.out.println("3. Generar estadísticas");
        System.out.println("4. Añadir Libro");
        System.out.println("5. Dar de alta usuarios");
        System.out.println("6. Exportar alquileres");
        System.out.println("7. Salir");
        System.out.println("Escribe la opción deseada: ");
        opcion = sc.nextInt();
        return opcion;
    }


    private static void exportarAlquileres() {
    }

    private static void darAltaUsuario() {
    }

    private static void generarEstadisticas() {
    }

    private static void devolverLibro() {
    }

    //Alquilar un libro
    private static void alquilarLibro(Usuario usuario) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        alquileres = LeerFicheros.leerFicheroAlquileres();

        //Si existe un alquiler asociado al usuario, no se puede alquilar
        for (Alquiler a: alquileres) {
            if (a.getIdUsuario() == usuario.getId()){
                System.out.println("⚠️ No puedes alquilar más libros, tienes uno pendiente de devolver.");
                System.out.println("El libro pendiente de devolver es: " + a.toString());
                return;
            }
        }

        //Leer ficheros
        ArrayList<Libro> libros = new ArrayList<>();
        libros = LeerFicheros.leerFicheroLibros();

        //Preguntar al usuario que libro quiere
        System.out.println("Escoge un id de la lista de libros para alquilarlo:");
        for (Libro l: libros) {
            System.out.println(l.toString());
        }
        Scanner sc = new Scanner(System.in);
        int id = 0;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("⚠️ El id introducido no es válido.");
            alquilarLibro(usuario);
        }
        boolean encontrado = false;
        for (Libro l: libros) {
            if (l.getId() == id){
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("⚠️ Libro no encontrado.");
            alquilarLibro(usuario);
        }
        Alquiler alquiler = new Alquiler();
        alquiler.setId(alquileres.size());
        alquiler.setIdLibro(id);
        alquiler.setIdUsuario(usuario.getId());
        alquiler.setFechaAlquiler(new Date());
        alquiler.setFechaDevolucion(null);
        alquileres.add(alquiler);
        EscribirFicheros.escribirFicheroAlquileres(alquileres);
        System.out.println("✅ Libro alquilado correctamente.");
        System.out.println(alquiler.toString());
    }

    private static void anadirLibro() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        //id
        libros = LeerFicheros.leerFicheroLibros();
        int id = libros.size() + 1;
        //titulo
        System.out.println("Introduce el título del libro: ");
        String titulo = sc.nextLine();
        //autor
        System.out.println("Introduce el autor del libro: ");
        String autor = sc.nextLine();
        //editorial
        System.out.println("Introduce la editorial del libro: ");
        String editorial = sc.nextLine();
        //Año
        System.out.println("Introduce el año del libro: ");
        int anyo = sc.nextInt();
        //ISBN
        System.out.println("Introduce el ISBN del libro: ");
        String isbn = sc.nextLine();

        Libro libro = new Libro(id, titulo, autor, editorial, anyo, isbn);

        libros.add(libro);
        EscribirFicheros.escribirFicheroLibros(libros);
        ArrayList<Libro> librosleer = LeerFicheros.leerFicheroLibros();
        librosleer.forEach(System.out::println);
        System.out.println("✅ Libro añadido correctamente.");
    }


}