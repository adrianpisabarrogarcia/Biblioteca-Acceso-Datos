/*
 * Created by JFormDesigner on Wed Dec 14 22:58:48 CET 2022
 */

package Main.Views.Libros;

import Main.Controlers.CategoriasController;
import Main.Models.Categoria;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author unknown
 */
public class GestionarLibros extends JFrame {
    public GestionarLibros() {
        initComponents();
        setTitle("Gestionar Libros");
        cargarCombo();
    }

    private void cargarCombo() {
        ArrayList<Categoria> categorias = CategoriasController.listar();
        for (Categoria categoria : categorias) {
            cbCategorias.addItem(categoria.getId() + " - " +categoria.getNombre());
        }
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        bBuscar = new JButton();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        cbCategorias = new JComboBox();

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
        contentPane.add(bInsertar);
        bInsertar.setBounds(65, 400, 100, bInsertar.getPreferredSize().height);

        //---- bModificar ----
        bModificar.setText("Modificar");
        contentPane.add(bModificar);
        bModificar.setBounds(180, 400, 100, 27);

        //---- bEliminar ----
        bEliminar.setText("Eliminar");
        contentPane.add(bEliminar);
        bEliminar.setBounds(295, 400, 100, 27);
        contentPane.add(textField1);
        textField1.setBounds(170, 75, 200, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(170, 115, 415, 27);
        contentPane.add(textField3);
        textField3.setBounds(170, 155, 415, 27);

        //---- bBuscar ----
        bBuscar.setText("Buscar");
        contentPane.add(bBuscar);
        bBuscar.setBounds(390, 75, 145, bBuscar.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(170, 200, 415, 27);
        contentPane.add(textField5);
        textField5.setBounds(170, 240, 415, 27);
        contentPane.add(textField6);
        textField6.setBounds(170, 280, 415, 27);
        contentPane.add(cbCategorias);
        cbCategorias.setBounds(170, 325, 415, cbCategorias.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(705, 510));
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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton bBuscar;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox cbCategorias;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
