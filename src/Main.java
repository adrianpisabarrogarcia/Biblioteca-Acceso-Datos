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

        //Menú
        int seleccion = 0;
        while (seleccion != 7){
            System.out.println("Menú de la biblioteca:");
            seleccion = menu();
            switch (seleccion){
                case 1:
                    System.out.println("⭐️ Alquilar libro -");
                    alquilarLibro();
                    break;
                case 2:
                    System.out.println("️⭐️ Devolver libro ⭐️");
                    devolverLibro();
                    break;
                case 3:
                    System.out.println("⭐️ Generar estadísticas ⭐️");
                    generarEstadisticas();
                    break;
                case 4:
                    System.out.println("⭐️ Añadir Libro ⭐️");
                    anadirLibro();
                    break;
                case 5:
                    System.out.println("⭐️ Dar de alta usuarios ⭐️");
                    darAltaUsuario();
                    break;
                case 6:
                    System.out.println("⭐️ Exportar alquileres ⭐️");
                    exportarAlquileres();
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

    private static void alquilarLibro() {

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