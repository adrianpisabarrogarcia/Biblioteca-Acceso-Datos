package Main.Models;

import Main.Controlers.Conveters.CategoriaConverter;
import Main.Controlers.Conveters.LibrosConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.Serializable;

public class Libro implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;
    private String isbn;

    private Categoria categoria;

    public Libro() {
    }

    public Libro(int id, String titulo, String autor, String editorial, int anio, String isbn, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anio=" + anio +
                ", isbn='" + isbn + '\'' +
                ", categoria=" + categoria +
                '}';
    }

    public static XStream prepararXStream(){
        XStream xstream = new XStream(new DomDriver());
        //Convertidor para parsear a un objeto
        xstream.registerConverter(new LibrosConverter());
        //Sin referencias circulares
        xstream.setMode(XStream.NO_REFERENCES);
        //Añadir alias
        xstream.alias("libro", Libro.class);
        xstream.alias("categoria", Categoria.class);
        //Añadir atributos
        xstream.useAttributeFor(Libro.class, "id");
        xstream.useAttributeFor(Categoria.class, "id");
        //Allow types
        xstream.allowTypes(new Class[]{Categoria.class});
        xstream.allowTypes(new Class[]{Libro.class});

        return xstream;
    }


}
