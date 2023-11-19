/*
 * Created by JFormDesigner on Sat Dec 17 12:07:15 CET 2022
 */

package Main.Views.Alquileres;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class GestionarAlquileresView extends JFrame {
    public GestionarAlquileresView() {
        initComponents();
    }

    private void bInsertar(ActionEvent e) {
        // TODO add your code here
    }

    private void bModificar(ActionEvent e) {
        // TODO add your code here
    }

    private void bEliminar(ActionEvent e) {
        // TODO add your code here
    }

    private void bBuscar(ActionEvent e) {
        // TODO add your code here
    }

    private void bVaciar(ActionEvent e) {
        // TODO add your code here
    }

    private void bBuscarTabla(ActionEvent e) {
        // TODO add your code here
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
