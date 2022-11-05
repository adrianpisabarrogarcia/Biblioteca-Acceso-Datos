package Controlers.XStream;

import Models.Alquiler;

import java.util.ArrayList;
import java.util.List;

public class ListaAlquileresEstadisticas {

    private List<Alquiler> alquileres = new ArrayList<Alquiler>();

    public ListaAlquileresEstadisticas() {
    }

    public ListaAlquileresEstadisticas(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

}
