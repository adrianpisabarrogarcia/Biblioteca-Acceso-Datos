package Main.Controlers.XStream;

import Main.Controlers.XStream.SpecificModels.AlquilerLibroUsuario;

import java.util.ArrayList;
import java.util.List;

public class ListaAlquileresLibrosUsuarios {

    private List<AlquilerLibroUsuario> alquileres = new ArrayList<AlquilerLibroUsuario>();

    public ListaAlquileresLibrosUsuarios() {
    }

    public ListaAlquileresLibrosUsuarios(List<AlquilerLibroUsuario> alquileres) {
        this.alquileres = alquileres;
    }

    public List<AlquilerLibroUsuario> getAlquileres() {
        return alquileres;
    }
}
