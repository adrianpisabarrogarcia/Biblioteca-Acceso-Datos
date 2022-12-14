package Main.Controlers.XStream.SpecificModels;

import Main.Models.Libro;
import Main.Models.Usuario;
import java.util.Date;

public class AlquilerLibroUsuario {

    private int id;
    private Usuario usuario;
    private Libro libro;
    private Date fechaAlquiler;
    private Date fechaDevolucion;

    public AlquilerLibroUsuario(int id, Usuario usuario, Libro libro, Date fechaAlquiler, Date fechaDevolucion) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    public AlquilerLibroUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "AlquilerLibroUsuario{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", libro=" + libro +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
