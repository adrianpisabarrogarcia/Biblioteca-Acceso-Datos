package Main.Controlers.XStream;

import Main.Controlers.XStream.SpecificModels.AlquilerLibroUsuario;
import Main.Controlers.XStream.SpecificModels.CategoriaLibros;
import Main.Models.Alquiler;

import java.util.ArrayList;
import java.util.List;

public class ListaCategoriasLibros {

    private List<CategoriaLibros> categoriaLibros = new ArrayList<CategoriaLibros>();

    public ListaCategoriasLibros() {
    }

    public ListaCategoriasLibros(List<CategoriaLibros> categoriaLibros) {
        this.categoriaLibros = categoriaLibros;
    }

    public List<CategoriaLibros> getCategoriaLibros() {
        return categoriaLibros;
    }
}
