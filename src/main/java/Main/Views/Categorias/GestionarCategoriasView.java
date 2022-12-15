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
        String id = tfId.getText();
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        String errores = "";
        if (id.isEmpty()) {
            errores += "El campo id no puede estar vacio\n";
        }
        if (nombre.isEmpty()) {
            errores += "El campo nombre no puede estar vacio\n";
        }
        if (descripcion.isEmpty()) {
            errores += "El campo descripcion no puede estar vacio\n";
        }
        try{
            Integer.parseInt(id);
        }catch (NumberFormatException ex){
            errores += "El campo id debe ser un numero\n";
        }
        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
        }else{
            CategoriasController.insertar(new Categoria(Integer.parseInt(id), nombre, descripcion));
            JOptionPane.showMessageDialog(null, "Categoria insertada correctamente");
            vaciarCampos();
            cargarTablaCategorias();
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
        contentPane.add(bModificar);
        bModificar.setBounds(200, 205, 100, 27);

        //---- bEliminar ----
        bEliminar.setText("Eliminar");
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
        contentPane.add(bBuscar);
        bBuscar.setBounds(390, 75, 145, bBuscar.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- taCategorias ----
            taCategorias.setEditable(false);
            scrollPane1.setViewportView(taCategorias);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 270, 575, 280);

        contentPane.setPreferredSize(new Dimension(705, 615));
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
