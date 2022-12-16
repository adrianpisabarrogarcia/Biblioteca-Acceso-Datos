/*
 * Created by JFormDesigner on Wed Dec 14 22:58:48 CET 2022
 */

package Main.Views.Libros;

import java.awt.event.*;
import Main.Controlers.CategoriasController;
import Main.Controlers.LibrosController;
import Main.Controlers.dat.EscribirFicheros;
import Main.Controlers.dat.LeerFicheros;
import Main.Models.Categoria;
import Main.Models.Libro;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author unknown
 */
public class GestionarLibrosView extends JFrame {
    public GestionarLibrosView() {
        initComponents();
        setTitle("Gestionar Libros");
        vaciarCampos();
    }

    private void cargarTabla() {
        String tableLibros = "";
        ArrayList<Libro> libros = LibrosController.listar();
        for (Libro libro : libros) {
            tableLibros += libro.toString() + "\n";
        }
        taResultados.setText(tableLibros);
    }

    private void vaciarCampos() {
        tfId.setText("");
        tfTitulo.setText("");
        tfAutor.setText("");
        tfEditorial.setText("");
        tfAnio.setText("");
        tfISBN.setText("");
        cargarCombo();
        cargarTabla();
    }

    private void cargarCombo() {
        //vaciar combo
        cbCategorias.removeAllItems();
        //cargar combo
        ArrayList<Categoria> categorias = CategoriasController.listar();
        for (Categoria categoria : categorias) {
            cbCategorias.addItem(categoria.getId() + " - " +categoria.getNombre());
        }
    }

    private void bInsertar(ActionEvent e) {
        String titulo = tfTitulo.getText();
        String autor = tfAutor.getText();
        String editorial = tfEditorial.getText();
        String anio = tfAnio.getText();
        String isbn = tfISBN.getText();
        String categoria = cbCategorias.getSelectedItem().toString().split(" - ")[0];
        ArrayList<Categoria> categorias = CategoriasController.listar();
        Categoria categoriaSeleccionada = null;
        for (Categoria categoria1 : categorias) {
            if (categoria1.getId() == Integer.parseInt(categoria)) {
                categoriaSeleccionada = categoria1;
            }
        }
        String errores = "";
        if (titulo.isEmpty()) {
            errores += "El titulo no puede estar vacio\n";
        }
        if (autor.isEmpty()) {
            errores += "El autor no puede estar vacio\n";
        }
        if (editorial.isEmpty()) {
            errores += "El editorial no puede estar vacio\n";
        }
        if (anio.isEmpty()) {
            errores += "El anio no puede estar vacio\n";
        }
        try {
            Integer.parseInt(anio);
        } catch (NumberFormatException ex) {
            errores += "El año debe ser un numero entero\n";
        }
        if (isbn.isEmpty()) {
            errores += "El isbn no puede estar vacio\n";
        }
        if (categoriaSeleccionada == null) {
            errores += "La categoria no puede estar vacia\n";
        }
        int idMax = 1;
        ArrayList<Libro> libros = LibrosController.listar();
        for (Libro libro : libros) {
            if (libro.getId() >= idMax) {
                idMax = libro.getId() + 1;
            }
        }
        if (errores.isEmpty()) {
            Libro libro = new Libro(idMax, titulo, autor, editorial, Integer.parseInt(anio), isbn, categoriaSeleccionada);
            LibrosController.insertar(libro);
            JOptionPane.showMessageDialog(this, "Libro insertado correctamente");
            vaciarCampos();
        } else {
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bEliminar(ActionEvent e) {
        String id = tfId.getText();
        String errores = "";
        if (id.isEmpty()) {
            errores += "El id no puede estar vacio\n";
        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            errores += "El id debe ser un numero entero\n";
        }

        if (errores.isEmpty()) {
            Libro libro = new Libro();
            libro.setId(Integer.parseInt(id));
            //Mirar si existe el libro
            if (LibrosController.existe(libro)) {
                LibrosController.eliminar(libro);
                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente");
                vaciarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "El libro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bBuscar(ActionEvent e) {
        String id = tfId.getText();
        String errores = "";
        if (id.isEmpty()) {
            errores += "El id no puede estar vacio\n";
        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            errores += "El id debe ser un numero entero\n";
        }
        if (errores.isEmpty()) {
            Libro libro = new Libro();
            libro.setId(Integer.parseInt(id));
            //Mirar si existe el libro
            if (LibrosController.existe(libro)) {
                Libro libroEncontrado = LibrosController.buscarPorId(libro);
                tfTitulo.setText(libroEncontrado.getTitulo());
                tfAutor.setText(libroEncontrado.getAutor());
                tfEditorial.setText(libroEncontrado.getEditorial());
                tfAnio.setText(libroEncontrado.getAnio() + "");
                tfISBN.setText(libroEncontrado.getIsbn());
                cbCategorias.setSelectedItem(libroEncontrado.getCategoria().getId() + " - " + libroEncontrado.getCategoria().getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "El libro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bModificar(ActionEvent e) {
        String id = tfId.getText();
        String titulo = tfTitulo.getText();
        String autor = tfAutor.getText();
        String editorial = tfEditorial.getText();
        String anio = tfAnio.getText();
        String isbn = tfISBN.getText();
        String categoria = cbCategorias.getSelectedItem().toString().split(" - ")[0];
        ArrayList<Categoria> categorias = CategoriasController.listar();
        Categoria categoriaSeleccionada = null;
        for (Categoria categoria1 : categorias) {
            if (categoria1.getId() == Integer.parseInt(categoria)) {
                categoriaSeleccionada = categoria1;
            }
        }
        String errores = "";
        if (id.isEmpty()) {
            errores += "El id no puede estar vacio\n";
        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            errores += "El id debe ser un numero entero\n";
        }
        if (titulo.isEmpty()) {
            errores += "El titulo no puede estar vacio\n";
        }
        if (autor.isEmpty()) {
            errores += "El autor no puede estar vacio\n";
        }
        if (editorial.isEmpty()) {
            errores += "El editorial no puede estar vacio\n";
        }
        if (anio.isEmpty()) {
            errores += "El anio no puede estar vacio\n";
        }
        try {
            Integer.parseInt(anio);
        } catch (NumberFormatException ex) {
            errores += "El año debe ser un numero entero\n";
        }
        if (isbn.isEmpty()) {
            errores += "El isbn no puede estar vacio\n";
        }
        if (categoriaSeleccionada == null) {
            errores += "La categoria no puede estar vacia\n";
        }
        if (errores.isEmpty()) {
            Libro libro = new Libro(Integer.parseInt(id), titulo, autor, editorial, Integer.parseInt(anio), isbn, categoriaSeleccionada);
            //Mirar si existe el libro
            if (LibrosController.existe(libro)) {
                LibrosController.modificar(libro);
                JOptionPane.showMessageDialog(this, "Libro modificado correctamente");
                vaciarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "El libro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bVaciar(ActionEvent e) {
        vaciarCampos();
    }

    private void bFiltrar(ActionEvent e) {
        String id = tfId.getText();
        String titulo = tfTitulo.getText();
        String autor = tfAutor.getText();
        String editorial = tfEditorial.getText();
        String anio = tfAnio.getText();
        String isbn = tfISBN.getText();
        Libro libro = new Libro();
        String errores = "";
        if(id.isEmpty()){
            libro.setId(-1);
        }else{
            try {
                libro.setId(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
                errores += "El id debe ser un numero entero\n";
            }
        }
        if (anio.isEmpty()) {
            libro.setAnio(-1);
        }else {
            try {
                libro.setAnio(Integer.parseInt(anio));
            } catch (NumberFormatException ex) {
                errores += "El año debe ser un numero entero\n";
            }
        }
        if(titulo.isEmpty()){
            libro.setTitulo(null);
        }else{
            libro.setTitulo(titulo);
        }
        if(autor.isEmpty()){
            libro.setAutor(null);
        }else{
            libro.setAutor(autor);
        }
        if(editorial.isEmpty()){
            libro.setEditorial(null);
        }else{
            libro.setEditorial(editorial);
        }
        if(isbn.isEmpty()){
            libro.setIsbn(null);
        }else{
            libro.setIsbn(isbn);
        }

        if (errores.isEmpty()) {
            ArrayList<Libro> libros = LibrosController.buscar(libro);
            String datos = "";
            if (libros.size() > 0){
                for (Libro libro1 : libros) {
                    datos += libro1.toString() + "\n";
                }
                generarDat(libros);
            }else{
                JOptionPane.showMessageDialog(this, "No se han encontrado libros");
            }
            taResultados.setText(datos);
        } else {
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void generarDat(ArrayList<Libro> libros) {
        EscribirFicheros.escribirFicheroLibros(libros);
        libros = LeerFicheros.leerFicheroLibros();
        String datos = "Se han encontrado " + libros.size() + " libros, se ha generado .dat y se ha leido el archivo, con la siguiente información:\n";
        for (Libro libro : libros) {
            datos += libro.toString() + "\n";
        }
        JOptionPane.showMessageDialog(this, datos);

    }

    private void bFiltrarPorCategoria(ActionEvent e) {
        String categoria = cbCategorias.getSelectedItem().toString().split(" - ")[0];
        Categoria categoriaSeleccionada = new Categoria();
        categoriaSeleccionada.setId(Integer.parseInt(categoria));
        Libro libro = new Libro();
        libro.setCategoria(categoriaSeleccionada);
        ArrayList<Libro> libros = LibrosController.buscarPorCategoria(libro);
        String datos = "";
        if (libros.size() > 0){
            for (Libro libro1 : libros) {
                datos += libro1.toString() + "\n";
            }
        }else{
            JOptionPane.showMessageDialog(this, "No se han encontrado libros");
        }
        taResultados.setText(datos);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        bInsertar = new JButton();
        bModificar = new JButton();
        bEliminar = new JButton();
        tfId = new JTextField();
        tfTitulo = new JTextField();
        tfAutor = new JTextField();
        bBuscar = new JButton();
        tfEditorial = new JTextField();
        tfAnio = new JTextField();
        tfISBN = new JTextField();
        cbCategorias = new JComboBox();
        scrollPane1 = new JScrollPane();
        taResultados = new JTextArea();
        bVaciar = new JButton();
        bFiltrar = new JButton();
        bFiltrarPorCategoria = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Id");
        contentPane.add(label1);
        label1.setBounds(60, 80, 115, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Titulo");
        contentPane.add(label2);
        label2.setBounds(55, 120, 115, 15);

        //---- label3 ----
        label3.setText("Autor");
        contentPane.add(label3);
        label3.setBounds(55, 160, 115, 16);

        //---- label4 ----
        label4.setText("Editorial");
        contentPane.add(label4);
        label4.setBounds(50, 205, 115, 16);

        //---- label5 ----
        label5.setText("A\u00f1o");
        contentPane.add(label5);
        label5.setBounds(50, 250, 115, 16);

        //---- label6 ----
        label6.setText("ISBN");
        contentPane.add(label6);
        label6.setBounds(50, 290, 115, 16);

        //---- label7 ----
        label7.setText("Categor\u00eda");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(50, 330), label7.getPreferredSize()));

        //---- bInsertar ----
        bInsertar.setText("Insertar");
        bInsertar.addActionListener(e -> bInsertar(e));
        contentPane.add(bInsertar);
        bInsertar.setBounds(65, 400, 100, bInsertar.getPreferredSize().height);

        //---- bModificar ----
        bModificar.setText("Modificar");
        bModificar.addActionListener(e -> bModificar(e));
        contentPane.add(bModificar);
        bModificar.setBounds(180, 400, 100, 27);

        //---- bEliminar ----
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(e -> bEliminar(e));
        contentPane.add(bEliminar);
        bEliminar.setBounds(295, 400, 100, 27);
        contentPane.add(tfId);
        tfId.setBounds(170, 75, 200, tfId.getPreferredSize().height);
        contentPane.add(tfTitulo);
        tfTitulo.setBounds(170, 115, 415, 27);
        contentPane.add(tfAutor);
        tfAutor.setBounds(170, 155, 415, 27);

        //---- bBuscar ----
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(e -> bBuscar(e));
        contentPane.add(bBuscar);
        bBuscar.setBounds(390, 75, 145, bBuscar.getPreferredSize().height);
        contentPane.add(tfEditorial);
        tfEditorial.setBounds(170, 200, 415, 27);
        contentPane.add(tfAnio);
        tfAnio.setBounds(170, 240, 415, 27);
        contentPane.add(tfISBN);
        tfISBN.setBounds(170, 280, 415, 27);
        contentPane.add(cbCategorias);
        cbCategorias.setBounds(170, 325, 415, cbCategorias.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(taResultados);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(640, 75, 425, 205);

        //---- bVaciar ----
        bVaciar.setText("Vaciar filtro y campos");
        bVaciar.addActionListener(e -> bVaciar(e));
        contentPane.add(bVaciar);
        bVaciar.setBounds(415, 400, 185, bVaciar.getPreferredSize().height);

        //---- bFiltrar ----
        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(e -> bFiltrar(e));
        contentPane.add(bFiltrar);
        bFiltrar.setBounds(630, 400, 115, bFiltrar.getPreferredSize().height);

        //---- bFiltrarPorCategoria ----
        bFiltrarPorCategoria.setText("Filtrar por categor\u00eda");
        bFiltrarPorCategoria.addActionListener(e -> bFiltrarPorCategoria(e));
        contentPane.add(bFiltrarPorCategoria);
        bFiltrarPorCategoria.setBounds(760, 400, 150, bFiltrarPorCategoria.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(1120, 490));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton bInsertar;
    private JButton bModificar;
    private JButton bEliminar;
    private JTextField tfId;
    private JTextField tfTitulo;
    private JTextField tfAutor;
    private JButton bBuscar;
    private JTextField tfEditorial;
    private JTextField tfAnio;
    private JTextField tfISBN;
    private JComboBox cbCategorias;
    private JScrollPane scrollPane1;
    private JTextArea taResultados;
    private JButton bVaciar;
    private JButton bFiltrar;
    private JButton bFiltrarPorCategoria;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
