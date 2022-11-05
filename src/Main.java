import Controlers.AnadirObjetos;
import Controlers.XStream.EscribirFicherosXML;
import Controlers.XStream.LeerFicherosXML;
import Controlers.XStream.SpecificModels.AlquilerLibroUsuario;
import Controlers.dat.EscribirFicheros;
import Controlers.dat.LeerFicheros;
import Models.Alquiler;
import Models.Libro;
import Models.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    devolverLibro(usuario);
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

    //✅ Exportar alquileres con la información de los alquileres, libros y usuarios a un fichero XML
    private static void exportarAlquileres() {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        alquileres = LeerFicheros.leerFicheroAlquileres();
        ArrayList<Libro> libros = new ArrayList<>();
        libros = LeerFicheros.leerFicheroLibros();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = LeerFicheros.leerFicheroUsuarios();

        ArrayList<AlquilerLibroUsuario> alquilerLibroUsuariosArrayList = new ArrayList<>();

        //Recorrer alquileres para obtener los libros y usuarios que se han alquilado
        for (Alquiler a: alquileres) {
            AlquilerLibroUsuario alquilerLibroUsuario = new AlquilerLibroUsuario();

            for (Libro l: libros) {
                if (a.getIdLibro() == l.getId()){
                    alquilerLibroUsuario.setLibro(l);
                }
            }
            for (Usuario u: usuarios) {
                if (a.getIdUsuario() == u.getId()){
                    alquilerLibroUsuario.setUsuario(u);
                }
            }
            alquilerLibroUsuario.setFechaAlquiler(a.getFechaAlquiler());
            alquilerLibroUsuario.setFechaDevolucion(a.getFechaDevolucion());
            alquilerLibroUsuariosArrayList.add(alquilerLibroUsuario);
        }

        System.out.println("Se van a exportar este número de alquileres: "+ alquilerLibroUsuariosArrayList.size());
        System.out.println("Generando XML...");
        //Generar XML
        EscribirFicherosXML.generarAlquileresLibrosUsuarios(alquilerLibroUsuariosArrayList);
        //Imprimir los alquileres
        System.out.println("Estos son los alquileres exportados: ");
        alquilerLibroUsuariosArrayList.forEach(System.out::println);
    }

    //✅ Dar de alta usuarios
    private static void darAltaUsuario() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = LeerFicheros.leerFicheroUsuarios();
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        //Pedir datos
        //Nombre
        System.out.println("Introduce el nombre del usuario:");
        String nombre = sc.nextLine();
        usuario.setNombre(nombre);
        //Apellidos
        System.out.println("Introduce los apellidos del usuario:");
        String apellidos = sc.nextLine();
        usuario.setApellidos(apellidos);
        //Dirección
        System.out.println("Introduce la dirección del usuario:");
        String direccion = sc.nextLine();
        usuario.setDireccion(direccion);
        //Fecha de nacimiento
        System.out.println("Introduce la fecha de nacimiento del usuario: (dd/mm/aaaa)");
        String fechaNacimiento = sc.nextLine();
        try {
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
            usuario.setFechaNacimiento(fecha);
        } catch (ParseException e) {
            System.out.println("⚠️ La fecha introducida no es válida.");
            darAltaUsuario();
        }
        //Email
        System.out.println("Introduce el email del usuario:");
        String email = sc.nextLine();
        //Revisar que el email no esté ya en uso
        boolean emailEnUso = false;
        for (Usuario u: usuarios) {
            if (u.getEmail().equals(email)){
                emailEnUso = true;
                break;
            }
        }
        if (emailEnUso){
            System.out.println("⚠️ El email introducido ya está en uso.");
            darAltaUsuario();
        }
        //Ver si el email es válido con una expresión regular
        if (!email.matches("^(.+)@(.+)$")){
            System.out.println("⚠️ El email introducido no es válido.");
             darAltaUsuario();
        }
        usuario.setEmail(email);

        //Generar id
        int id = usuarios.size() + 1;
        usuario.setId(id);

        //Añadir usuario a la lista
        usuarios.add(usuario);

        //Escribir en el fichero
        EscribirFicheros.escribirFicheroUsuarios(usuarios);

        System.out.println("✅ Usuario dado de alta correctamente.");
        System.out.println(usuario.toString());

    }

    //✅ Generar estadísticas por mes y año de los libros que se han alquilado, mostrarlos en pantalla y después guardarlos en estadisticas.xml.
    private static void generarEstadisticas() {
        System.out.println("Vamos a generar estadísticas 📊 de los alquileres hechos en un mes y año específico, exportaremos un fichero xml con los datos y te los mostraremos en pantalla.");
        //Intruducir mes y año para generar las estadísticas
        System.out.println("Introduce el mes que quieres consultar:");
        Scanner sc = new Scanner(System.in);
        int mes = sc.nextInt();
        try {
            if (mes < 1 || mes > 12){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("⚠️ El mes introducido no es válido.");
            generarEstadisticas();
        }
        System.out.println("Introduce el año que quieres consultar:");
        int year = sc.nextInt();
        try {
            if (year < 0){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("⚠️ El año introducido no es válido.");
            generarEstadisticas();
        }
        System.out.println("✅ Mes y año introducidos correctamente.");
        //Comprobar si hay alquileres en ese mes y año
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        alquileres = LeerFicheros.leerFicheroAlquileres();
        ArrayList<Alquiler> alquilersAExportar = new ArrayList<>();
        for (Alquiler a: alquileres) {
            int monthFechaAlquiler = a.getFechaAlquiler().getMonth() + 1;
            int yearFechaAlquiler = a.getFechaAlquiler().getYear() + 1900;
            System.out.println("Mes: " + monthFechaAlquiler + " Año: " + yearFechaAlquiler);

            if (monthFechaAlquiler == mes && yearFechaAlquiler == year){
                alquilersAExportar.add(a);
            }
        }
        //Si no hay alquileres en ese mes y año, mostrar mensaje y volver al menú
        if (alquilersAExportar.size() == 0){
            System.out.println("⚠️ No se han encontrado alquileres en el mes y año introducidos.");
            return;
        }
        //Si hay alquileres en ese mes y año, mostrarlos en pantalla y exportarlos a un fichero xml
        System.out.println("✅ Se han encontrado " + alquilersAExportar.size() + " alquileres en el mes y año introducidos.");
        System.out.println("✅ Exportando alquileres a fichero xml...");
        //Generar fichero xml
        EscribirFicherosXML.generarEstadisticasAlquileres(alquilersAExportar, mes, year);
        System.out.println("✅ Fichero xml generado correctamente.");
        System.out.println("✅ Mostrando alquileres en pantalla...");
        //Leer fichero xml
        ArrayList<Alquiler> alquileresLeidos = LeerFicherosXML.leerEstadisticasAlquileres(mes, year);
        //Mostrar alquileres en pantalla
        System.out.println("Alquileres del mes " + mes + " del año " + year + ":");
        for (Alquiler a: alquileresLeidos) {
            System.out.println(a.toString());
        }
    }

    //✅ Devolver libro de la lista de alquileres
    private static void devolverLibro(Usuario usuario) {
        //Leer fichero de alquileres
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        alquileres = LeerFicheros.leerFicheroAlquileres();

        //Mostar alquileres del usuario
        ArrayList<Alquiler> alquileresUsuario = new ArrayList<>();
        for (Alquiler a: alquileres) {
            if (a.getIdUsuario() == usuario.getId() && a.getFechaDevolucion() == null){
                alquileresUsuario.add(a);
            }
        }
        if (alquileresUsuario.size() == 0){
            System.out.println("⚠️ No tienes ningún libro alquilado.");
            return;
        }else {
            System.out.println("Tus libros alquilados son:");
            for (Alquiler a: alquileresUsuario) {
                System.out.println(a.toString());
            }
        }

        //Pedir id del libro a devolver
        System.out.println("Introduce el id del libro que quieres devolver:");
        Scanner sc = new Scanner(System.in);
        int idLibro = 0;
        try {
            idLibro = sc.nextInt();
        } catch (Exception e) {
            System.out.println("⚠️ El id introducido no es válido.");
            devolverLibro(usuario);
        }
        boolean encontrado = false;
        for (Alquiler a : alquileres) {
           if (a.getId() == idLibro){
                encontrado = true;
               a.setFechaDevolucion(new Date());
               System.out.println("✅ Libro devuelto correctamente.");
               break;
           }
        }
        if (!encontrado){
            System.out.println("⚠️ No tienes ese libro alquilado.");
            devolverLibro(usuario);
        }
        //Guardar alquileres
        EscribirFicheros.escribirFicheroAlquileres(alquileres);
        alquileres.forEach(System.out::println);
    }

    //✅ Alquilar un libro
    private static void alquilarLibro(Usuario usuario) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        alquileres = LeerFicheros.leerFicheroAlquileres();

        //Si existe un alquiler asociado al usuario, no se puede alquilar
        for (Alquiler a: alquileres) {
            if (a.getIdUsuario() == usuario.getId() && a.getFechaDevolucion() == null){
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
        alquiler.setId(alquileres.size() + 1);
        alquiler.setIdLibro(id);
        alquiler.setIdUsuario(usuario.getId());
        alquiler.setFechaAlquiler(new Date());
        alquiler.setFechaDevolucion(null);
        alquileres.add(alquiler);
        EscribirFicheros.escribirFicheroAlquileres(alquileres);
        System.out.println("✅ Libro alquilado correctamente.");
        System.out.println(alquiler.toString());
    }

    //✅ Añadir un libro a la biblioteca
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
        //ISBN
        System.out.println("Introduce el ISBN del libro: ");
        String isbn = sc.nextLine();
        //Año
        System.out.println("Introduce el año del libro: ");
        int anyo = 0;
        try {
            anyo = sc.nextInt();
        } catch (Exception e) {
            System.out.println("⚠️ El año introducido no es válido. Vuelve a intentarlo.");
            anadirLibro();
        }


        Libro libro = new Libro(id, titulo, autor, editorial, anyo, isbn);

        libros.add(libro);
        EscribirFicheros.escribirFicheroLibros(libros);
        System.out.println("✅ Libro añadido correctamente.");
        libros.forEach(System.out::println);
    }

}