/*
 * Created by JFormDesigner on Wed Dec 14 22:58:48 CET 2022
 */

package Main.Views.Categorias;

import java.awt.event.*;
import Main.Controlers.CategoriasController;
import Main.Models.Categoria;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author unknown
 */
public class GestionarCategoriasView extends JFrame {
    public GestionarCategoriasView() {
        initComponents();
        setTitle("Gestionar Categorias");
        cargarTablaCategorias();
    }

    private void cargarTablaCategorias() {
        String categoriasString = "";
        ArrayList<Categoria> categorias = CategoriasController.listar();
        for (Categoria categoria : categorias) {
            categoriasString += categoria.toString();
            categoriasString += "\n";
        }
        taCategorias.setText(categoriasString);
    }


    private void vaciarCampos(){
        tfId.setText("");
        tfNombre.setText("");
        tfDescripcion.setText("");
    }

    private void bInsertar(ActionEvent e) {
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        String errores = "";
        ArrayList<Categoria> categorias = CategoriasController.listar();
        int idMax = 1;
        for (Categoria categoria : categorias) {
            if (categoria.getId() >= idMax) {
                idMax = categoria.getId() + 1;
            }
        }
        if (nombre.isEmpty()) {
            errores += "El campo nombre no puede estar vacio\n";
        }
        if (descripcion.isEmpty()) {
            errores += "El campo descripcion no puede estar vacio\n";
        }
        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
        }else{
            CategoriasController.insertar(new Categoria(idMax, nombre, descripcion));
            JOptionPane.showMessageDialog(null, "Categoria insertada correctamente");
            vaciarCampos();
            cargarTablaCategorias();
        }
    }

    private void bVaciar(ActionEvent e) {
        vaciarCampos();
        cargarTablaCategorias();
    }

    private void bEliminar(ActionEvent e) {
        String id = tfId.getText();
        Categoria categoria = new Categoria();
        try {
            Integer.parseInt(id);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "El campo id debe ser un numero");
            return;
        }
        categoria.setId(Integer.parseInt(id));
        if (CategoriasController.existe(categoria)) {
            CategoriasController.eliminar(categoria);
            JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente");
            vaciarCampos();
            cargarTablaCategorias();
        }else{
            JOptionPane.showMessageDialog(null, "No existe ningun elemento con ese id");
        }
    }

    private void bModificar(ActionEvent e) {
        String id = tfId.getText();
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        String errores = "";
        Categoria categoria = new Categoria();
        try {
            Integer.parseInt(id);
        }catch (NumberFormatException ex){
            errores += "El campo id debe ser un numero\n";
        }
        if (nombre.isEmpty()) {
            errores += "El campo nombre no puede estar vacio\n";
        }
        if (descripcion.isEmpty()) {
            errores += "El campo descripcion no puede estar vacio\n";
        }
        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
        }else{
            categoria.setId(Integer.parseInt(id));
            categoria.setNombre(nombre);
            categoria.setDescripcion(descripcion);
            if (CategoriasController.existe(categoria)) {
                CategoriasController.modificar(categoria);
                JOptionPane.showMessageDialog(null, "Categoria modificada correctamente");
                vaciarCampos();
                cargarTablaCategorias();
            }else{
                JOptionPane.showMessageDialog(null, "No existe ningun elemento con ese id");
            }
        }
    }

    private void bBuscar(ActionEvent e) {
        String id = tfId.getText();
        String errores = "";
        try {
            Integer.parseInt(id);
        }catch (NumberFormatException ex){
            errores += "El campo id debe ser un numero\n";
        }
        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
        }else{
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(id));
            categoria = CategoriasController.buscarPorId(categoria);
            if (categoria != null) {
                tfNombre.setText(categoria.getNombre());
                tfDescripcion.setText(categoria.getDescripcion());
            }else{
                JOptionPane.showMessageDialog(null, "No existe ningun elemento con ese id");
            }
        }
    }

    private void bBuscarTabla(ActionEvent e) {
        String id = tfId.getText();
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        //Comprobar el id
        String errores = "";
        Categoria categoria = new Categoria();
        if(!id.isEmpty()) {
            try {
                Integer.parseInt(id);
                categoria.setId(Integer.parseInt(id));

            }catch (NumberFormatException ex){
                errores += "El campo id debe ser un numero\n";
            }
        }else{
            categoria.setId(-1);
        }
        if(nombre.isEmpty()){
            categoria.setNombre(null);
        }else{
            categoria.setNombre(nombre);
        }
        if (descripcion.isEmpty()) {
            categoria.setDescripcion(null);
        }else{
            categoria.setDescripcion(descripcion);
        }
        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
        }else{
            ArrayList<Categoria> categorias = CategoriasController.buscar(categoria);
            if (categorias.size() > 0) {
                String categoriasString = "";
                for (Categoria categoria1 : categorias) {
                    categoriasString += categoria1.toString() + "\n";
                }
                taCategorias.setText(categoriasString);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ningun elemento con esos datos");
                taCategorias.setText("");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        bInsertar = new JButton();
        bModificar = new JButton();
        bEliminar = new JButton();
        tfId = new JTextField();
        tfNombre = new JTextField();
        tfDescripcion = new JTextField();
        bBuscar = new JButton();
        scrollPane1 = new JScrollPane();
        taCategorias = new JTextArea();
        bVaciar = new JButton();
        bBuscarTabla = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Id");
        contentPane.add(label1);
        label1.setBounds(60, 80, 115, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Nombre");
        contentPane.add(label2);
        label2.setBounds(55, 120, 115, 15);

        //---- label3 ----
        label3.setText("Descripci\u00f3n");
        contentPane.add(label3);
        label3.setBounds(55, 160, 115, 16);

        //---- bInsertar ----
        bInsertar.setText("Insertar");
        bInsertar.addActionListener(e -> bInsertar(e));
        contentPane.add(bInsertar);
        bInsertar.setBounds(85, 205, 100, bInsertar.getPreferredSize().height);

        //---- bModificar ----
        bModificar.setText("Modificar");
        bModificar.addActionListener(e -> bModificar(e));
        contentPane.add(bModificar);
        bModificar.setBounds(200, 205, 100, 27);

        //---- bEliminar ----
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(e -> bEliminar(e));
        contentPane.add(bEliminar);
        bEliminar.setBounds(315, 205, 100, 27);
        contentPane.add(tfId);
        tfId.setBounds(170, 75, 200, tfId.getPreferredSize().height);
        contentPane.add(tfNombre);
        tfNombre.setBounds(170, 115, 415, 27);
        contentPane.add(tfDescripcion);
        tfDescripcion.setBounds(170, 155, 415, 27);

        //---- bBuscar ----
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(e -> bBuscar(e));
        contentPane.add(bBuscar);
        bBuscar.setBounds(390, 75, 145, bBuscar.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- taCategorias ----
            taCategorias.setEditable(false);
            scrollPane1.setViewportView(taCategorias);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 270, 730, 280);

        //---- bVaciar ----
        bVaciar.setText("Vaciar campos/filtros");
        bVaciar.addActionListener(e -> bVaciar(e));
        contentPane.add(bVaciar);
        bVaciar.setBounds(430, 205, 165, 27);

        //---- bBuscarTabla ----
        bBuscarTabla.setText("Buscar en la tabla");
        bBuscarTabla.addActionListener(e -> bBuscarTabla(e));
        contentPane.add(bBuscarTabla);
        bBuscarTabla.setBounds(610, 205, 155, 27);

        contentPane.setPreferredSize(new Dimension(875, 630));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton bInsertar;
    private JButton bModificar;
    private JButton bEliminar;
    private JTextField tfId;
    private JTextField tfNombre;
    private JTextField tfDescripcion;
    private JButton bBuscar;
    private JScrollPane scrollPane1;
    private JTextArea taCategorias;
    private JButton bVaciar;
    private JButton bBuscarTabla;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
