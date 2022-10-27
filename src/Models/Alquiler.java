package Models;

import java.util.Date;

public class Alquiler {

    private int id;
    private int idUsuario;
    private int idPelicula;
    private Date fechaAlquiler;
    private Date fechaDevolucion;

    public Alquiler() {
    }

    public Alquiler(int id, int idUsuario, int idPelicula, Date fechaAlquiler, Date fechaDevolucion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
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
        return "Alquiler{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idPelicula=" + idPelicula +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
