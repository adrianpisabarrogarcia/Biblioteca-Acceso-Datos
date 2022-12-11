package Main.Controlers.dat;

import Main.Models.Alquiler;
import Main.Models.Libro;
import Main.Models.Usuario;

import java.io.*;
import java.util.ArrayList;

public class LeerFicheros {

    /**
     * Lee un fichero de texto y lo devuelve en un ArrayList de Libros
     * @return ArrayList<Libro>
     */
    public static ArrayList<Libro> leerFicheroLibros() {
        //Leer fichero
        ArrayList<Libro> libros = new ArrayList<>();
        String rutaFichero = "libros.dat";
        try {
            //Comprobar si el fichero existe
            File fichero = new File(rutaFichero);
            if (!fichero.exists()) {
                throw new IOException("El fichero no existe");
            }


            //Crear flujo de entrada
            FileInputStream filein = new FileInputStream(rutaFichero);
            //Crear flujo de datos
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            //Leer datos del fichero
            while (filein.available() != 0) {
                libros.add((Libro) dataIS.readObject());
            }
            //Cerrar flujos
            dataIS.close();
            filein.close();

        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return libros;
    }

    /**
     * Lee un fichero de texto y lo devuelve en un ArrayList de Usuarios
     * @return ArrayList<Usuario>
     */
    public static ArrayList<Usuario> leerFicheroUsuarios() {
        //Leer fichero
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String rutaFichero = "usuarios.dat";
        try {
            //Comprobar si el fichero existe
            File fichero = new File(rutaFichero);
            if (!fichero.exists()) {
                throw new IOException("El fichero no existe");
            }


            //Crear flujo de entrada
            FileInputStream filein = new FileInputStream(rutaFichero);
            //Crear flujo de datos
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            //Leer datos del fichero
            while (filein.available() != 0) {
                usuarios.add((Usuario) dataIS.readObject());
            }
            //Cerrar flujos
            dataIS.close();
            filein.close();

        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return usuarios;
    }

    /**
     * Lee un fichero de texto y lo devuelve en un ArrayList de Alquileres
     * @return ArrayList<Alquiler>
     */
    public static ArrayList<Alquiler> leerFicheroAlquileres() {
        //Leer fichero
        ArrayList<Alquiler> alquilers = new ArrayList<>();
        String rutaFichero = "alquileres.dat";
        try {
            //Comprobar si el fichero existe
            File fichero = new File(rutaFichero);
            if (!fichero.exists()) {
                throw new IOException("El fichero no existe");
            }


            //Crear flujo de entrada
            FileInputStream filein = new FileInputStream(rutaFichero);
            //Crear flujo de datos
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            //Leer datos del fichero
            while (filein.available() != 0) {
                alquilers.add((Alquiler) dataIS.readObject());
            }
            //Cerrar flujos
            dataIS.close();
            filein.close();

        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return alquilers;
    }

}
