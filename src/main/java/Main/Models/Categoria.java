package Main.Models;

import Main.Controlers.Conveters.CategoriaConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.Serializable;

public class Categoria implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria() {
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

    public static XStream prepararXStream(){
        XStream xstream = new XStream(new DomDriver());
        //Convertidor para parsear a un objeto
        xstream.registerConverter(new CategoriaConverter());
        //Sin referencias circulares
        xstream.setMode(XStream.NO_REFERENCES);
        //Añadir alias
        xstream.alias("categoria", Categoria.class);
        //Añadir atributos
        xstream.useAttributeFor(Categoria.class, "id");
        //Allow types
        xstream.allowTypes(new Class[]{Categoria.class});

        return xstream;
    }
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
