/*
 * Created by JFormDesigner on Wed Dec 14 20:45:40 CET 2022
 */

package Main.Views;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantallaPrincipal extends JFrame {
    public PantallaPrincipal() {
        initComponents();
        setTitle("Biblioteca Pantalla Principal");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Libros");

                //---- menuItem1 ----
                menuItem1.setText("Insertar, Modificar, Eliminar");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Listar");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Usuarios");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Categor\u00edas de Libros");
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("Alquileres");
            }
            menuBar1.add(menu4);
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
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
