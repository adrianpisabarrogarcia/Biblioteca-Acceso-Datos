/*
 * Created by JFormDesigner on Wed Dec 14 20:45:40 CET 2022
 */

package Main.Views;

import Main.Views.Alquileres.GestionarAlquileresView;
import Main.Views.Categorias.GestionarCategoriasView;
import Main.Views.Libros.GestionarLibrosView;
import Main.Views.Usuarios.GestionarUsuariosView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantallaPrincipal extends JFrame {
    public PantallaPrincipal() {
        initComponents();
        setTitle("Biblioteca Pantalla Principal");
    }

    private void mCategorias(ActionEvent e) {
        GestionarCategoriasView gestionarCategoriasView = new GestionarCategoriasView();
        gestionarCategoriasView.setVisible(true);
    }

    private void mLibros(ActionEvent e) {
        GestionarLibrosView gestionarLibrosView = new GestionarLibrosView();
        gestionarLibrosView.setVisible(true);
    }

    private void mUsuarios(ActionEvent e) {
        GestionarUsuariosView gestionarUsuariosView = new GestionarUsuariosView();
        gestionarUsuariosView.setVisible(true);
    }

    private void mAlquileres(ActionEvent e) {
        GestionarAlquileresView gestionarAlquileresView = new GestionarAlquileresView();
        gestionarAlquileresView.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        mCategorias = new JMenuItem();
        mLibros = new JMenuItem();
        mUsuarios = new JMenuItem();
        mAlquileres = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //---- mCategorias ----
            mCategorias.setText("Categor\u00edas de Libros");
            mCategorias.addActionListener(e -> mCategorias(e));
            menuBar1.add(mCategorias);

            //---- mLibros ----
            mLibros.setText("Libros");
            mLibros.addActionListener(e -> mLibros(e));
            menuBar1.add(mLibros);

            //---- mUsuarios ----
            mUsuarios.setText("Usuarios");
            mUsuarios.addActionListener(e -> mUsuarios(e));
            menuBar1.add(mUsuarios);

            //---- mAlquileres ----
            mAlquileres.setText("Alquileres");
            mAlquileres.addActionListener(e -> mAlquileres(e));
            menuBar1.add(mAlquileres);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("Sistema de Gesti\u00f3n");
        label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 24));
        contentPane.add(label1);
        label1.setBounds(110, 105, 360, 65);

        //---- label2 ----
        label2.setText("Biblioteca");
        label2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 36));
        contentPane.add(label2);
        label2.setBounds(110, 145, 360, 65);

        contentPane.setPreferredSize(new Dimension(510, 390));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuItem mCategorias;
    private JMenuItem mLibros;
    private JMenuItem mUsuarios;
    private JMenuItem mAlquileres;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
