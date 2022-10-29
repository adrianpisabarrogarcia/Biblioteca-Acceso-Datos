package Controlers.dat;

import Models.Alquiler;
import Models.Libro;
import Models.Usuario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirFicheros {

    /**
     * Escribe un fichero binario con el contenido de un ArrayList de String
     * @param arrayList - ArrayList de objetos de libros a escribir en el fichero
     */
    public static void escribirFicheroLibros(ArrayList<Libro> arrayList) {
        String nombreFichero = "libros.dat";
        try {
            //Crear flujo de salida
            FileOutputStream fileout = new FileOutputStream(nombreFichero);
            //Crear flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            //Escribir datos en el fichero
            for (Libro libro : arrayList) {
                dataOS.writeObject(libro);
            }

            //Cerrar flujos
            dataOS.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Escribe un fichero binario con el contenido de un ArrayList de String
     * @param arrayList - ArrayList de objetos de alquileres a escribir en el fichero
     */
    public static void escribirFicheroAlquileres(ArrayList<Alquiler> arrayList) {
        String nombreFichero = "alquileres.dat";
        try {
            //Crear flujo de salida
            FileOutputStream fileout = new FileOutputStream(nombreFichero);
            //Crear flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            //Escribir datos en el fichero
            for (Alquiler alquiler : arrayList) {
                dataOS.writeObject(alquiler);
            }

            //Cerrar flujos
            dataOS.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Escribe un fichero binario con el contenido de un ArrayList de String
     * @param arrayList - ArrayList de objetos de alquileres a escribir en el fichero
     */
    public static void escribirFicheroUsuarios(ArrayList<Usuario> arrayList) {
        String nombreFichero = "usuarios.dat";
        try {
            //Crear flujo de salida
            FileOutputStream fileout = new FileOutputStream(nombreFichero);
            //Crear flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            //Escribir datos en el fichero
            for (Usuario usuario : arrayList) {
                dataOS.writeObject(usuario);
            }

            //Cerrar flujos
            dataOS.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
