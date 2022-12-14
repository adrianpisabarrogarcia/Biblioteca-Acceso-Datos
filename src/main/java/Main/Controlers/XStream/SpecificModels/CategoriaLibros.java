package Main.Controlers.XStream.SpecificModels;

import Main.Models.Libro;
import Main.Models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CategoriaLibros {

    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public CategoriaLibros(int id, String nombre, String descripcion, ArrayList<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.libros = libros;
    }

    public CategoriaLibros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "CategoriaLibros{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", libros=" + libros +
                '}';
    }
}
