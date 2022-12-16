/*
 * Created by JFormDesigner on Fri Dec 16 14:42:49 CET 2022
 */

package Main.Views.Usuarios;

import Main.Controlers.UsuariosController;
import Main.Models.Usuario;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 * @author unknown
 */
public class GestionarUsuariosView extends JFrame {
    public GestionarUsuariosView() {
        initComponents();
        setTitle("Gestionar Usuarios");
        vaciarCombos();
    }

    private void vaciarCombos() {
        tfId.setText("");
        tfNombre.setText("");
        tfApellidos.setText("");
        tfEmail.setText("");
        tfDireccion.setText("");
        tfDia.setText("dd");
        tfMes.setText("mm");
        tfAnio.setText("aaaa");
        cargarTabla();
    }

    private void cargarTabla() {
        String datos = "";
        ArrayList<Usuario> usuarios = UsuariosController.listar();
        for (Usuario usuario : usuarios) {
            datos += usuario.toString() + "\n";
        }
        taUsuarios.setText(datos);
    }

    private void bInsertar(ActionEvent e) {
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        String email = tfEmail.getText();
        String direccion = tfDireccion.getText();
        String dia = tfDia.getText();
        String mes = tfMes.getText();
        String anio = tfAnio.getText();
        String errores = "";
        int idMax = 1;
        ArrayList<Usuario> usuarios = UsuariosController.listar();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() >= idMax) {
                idMax = usuario.getId() + 1;
            }
        }
        Usuario usuario = new Usuario();
        usuario.setId(idMax);
        if(nombre.equals("")){
            errores += "El nombre no puede estar vacío\n";
        }else{
            usuario.setNombre(nombre);
        }
        if(apellidos.equals("")){
            errores += "Los apellidos no pueden estar vacíos\n";
        }else {
            usuario.setApellidos(apellidos);
        }
        if(email.equals("")){
            errores += "El email no puede estar vacío\n";
        }else{
            usuario.setEmail(email);
        }
        if(direccion.equals("")){
            errores += "La dirección no puede estar vacía\n";
        }else {
            usuario.setDireccion(direccion);
        }
        if(dia.equals("dd") || mes.equals("mm") || anio.equals("aaaa")){
            errores += "La fecha de nacimiento no puede estar vacía\n";
        }
        try {
            Date fechaNacimiento = new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
        }catch (Exception ex){
            errores += "La fecha de nacimiento no es válida\n";
        }
        if(errores.equals("")){
            usuario.setFechaNacimiento(new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia)));
            UsuariosController.insertar(usuario);
            JOptionPane.showMessageDialog(this, "Usuario insertado correctamente");
            vaciarCombos();
        }else{
            JOptionPane.showMessageDialog(this, errores);
        }

    }

    private void bModificar(ActionEvent e) {
        String id = tfId.getText();
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        String email = tfEmail.getText();
        String direccion = tfDireccion.getText();
        String dia = tfDia.getText();
        String mes = tfMes.getText();
        String anio = tfAnio.getText();
        String errores = "";
        Usuario usuario = new Usuario();
        if(id.equals("")){
            errores += "El id no puede estar vacío\n";
        }
        try {
            usuario.setId(Integer.parseInt(id));
        }catch (Exception ex){
            errores += "El id no es válido\n";
        }
        if(nombre.equals("")){
            errores += "El nombre no puede estar vacío\n";
        }else{
            usuario.setNombre(nombre);
        }
        if(apellidos.equals("")){
            errores += "Los apellidos no pueden estar vacíos\n";
        }else {
            usuario.setApellidos(apellidos);
        }
        if(email.equals("")){
            errores += "El email no puede estar vacío\n";
        }else{
            usuario.setEmail(email);
        }
        if(direccion.equals("")){
            errores += "La dirección no puede estar vacía\n";
        }else {
            usuario.setDireccion(direccion);
        }
        if(dia.equals("dd") || mes.equals("mm") || anio.equals("aaaa")){
            errores += "La fecha de nacimiento no puede estar vacía\n";
        }
        try {
            Date fechaNacimiento = new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
        }catch (Exception ex){
            errores += "La fecha de nacimiento no es válida\n";
        }
        if(errores.equals("")){
            usuario.setFechaNacimiento(new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia)));
            UsuariosController.modificar(usuario);
            JOptionPane.showMessageDialog(this, "Usuario insertado correctamente");
            vaciarCombos();
        }else{
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bEliminar(ActionEvent e) {
        String id = tfId.getText();
        String errores = "";
        if(id.equals("")){
            errores += "El id no puede estar vacío\n";
        }
        try {
            int idInt = Integer.parseInt(id);
        }catch (Exception ex){
            errores += "El id no es válido\n";
        }
        if(errores.equals("")){
            int idInt = Integer.parseInt(id);
            Usuario usuario = new Usuario();
            usuario.setId(idInt);
            UsuariosController.eliminar(usuario);
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
            vaciarCombos();
        }else{
            JOptionPane.showMessageDialog(this, errores);
        }
    }

    private void bBuscar(ActionEvent e) {
        String id = tfId.getText();
        String errores = "";
        if (id.equals("")) {
            errores += "El campo ID no puede estar vacío.\n";
        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            errores += "El campo ID debe ser un número.\n";
        }
        if (errores.equals("")) {
            Usuario usuarioAux = new Usuario();
            usuarioAux.setId(Integer.parseInt(id));
            Usuario usuario = UsuariosController.buscarPorId(usuarioAux);
            if (usuario != null) {
                tfNombre.setText(usuario.getNombre());
                tfApellidos.setText(usuario.getApellidos());
                tfEmail.setText(usuario.getEmail());
                tfDireccion.setText(usuario.getDireccion());
                tfDia.setText(""+usuario.getFechaNacimiento().getDate());
                tfMes.setText(""+(usuario.getFechaNacimiento().getMonth()+1));
                tfAnio.setText(""+usuario.getFechaNacimiento().getYear());
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado ningún usuario con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, errores, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bVaciar(ActionEvent e) {
        vaciarCombos();
    }

    private void bBuscarTabla(ActionEvent e) {
        String id = tfId.getText();
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        String email = tfEmail.getText();
        String direccion = tfDireccion.getText();
        String dia = tfDia.getText();
        String mes = tfMes.getText();
        String anio = tfAnio.getText();
        String errores = "";
        Usuario usuario = new Usuario();
        if(id.equals("")){
            usuario.setId(-1);
        }else {
            try {
                usuario.setId(Integer.parseInt(id));
            }catch (Exception ex){
                errores += "El id no es válido\n";
            }
        }
        if(nombre.equals("")){
        }else{
            usuario.setNombre(nombre);
        }
        if(apellidos.equals("")){
        }else {
            usuario.setApellidos(apellidos);
        }
        if(email.equals("")){
        }else{
            usuario.setEmail(email);
        }
        if(direccion.equals("")){
        }else {
            usuario.setDireccion(direccion);
        }
        if(dia.equals("dd") || mes.equals("mm") || anio.equals("aaaa")){
            usuario.setFechaNacimiento(null);
        }else {
            try {
                Date fechaNacimiento = new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
                usuario.setFechaNacimiento(fechaNacimiento);
            }catch (Exception ex){
                errores += "La fecha de nacimiento no es válida\n";
            }
        }
        if(errores.equals("")) {
            String datos = "";
            ArrayList<Usuario> usuarios = UsuariosController.buscar(usuario);
            if (usuarios.size() > 0) {
                for (Usuario usuarioAux : usuarios) {
                    datos += usuarioAux.toString() + "\n";
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se han encontrado usuarios con esos datos");
            }
            taUsuarios.setText(datos);
        }else {
            JOptionPane.showMessageDialog(this, errores);
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
        tfApellidos = new JTextField();
        bBuscar = new JButton();
        scrollPane1 = new JScrollPane();
        taUsuarios = new JTextArea();
        bVaciar = new JButton();
        bBuscarTabla = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        tfEmail = new JTextField();
        tfDireccion = new JTextField();
        label6 = new JLabel();
        tfDia = new JTextField();
        tfMes = new JTextField();
        tfAnio = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Id");
        contentPane.add(label1);
        label1.setBounds(55, 20, 115, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Nombre");
        contentPane.add(label2);
        label2.setBounds(55, 50, 115, 15);

        //---- label3 ----
        label3.setText("Apellidos");
        contentPane.add(label3);
        label3.setBounds(55, 85, 115, 16);

        //---- bInsertar ----
        bInsertar.setText("Insertar");
        bInsertar.addActionListener(e -> bInsertar(e));
        contentPane.add(bInsertar);
        bInsertar.setBounds(85, 230, 100, bInsertar.getPreferredSize().height);

        //---- bModificar ----
        bModificar.setText("Modificar");
        bModificar.addActionListener(e -> bModificar(e));
        contentPane.add(bModificar);
        bModificar.setBounds(200, 230, 100, 27);

        //---- bEliminar ----
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(e -> bEliminar(e));
        contentPane.add(bEliminar);
        bEliminar.setBounds(315, 230, 100, 27);
        contentPane.add(tfId);
        tfId.setBounds(170, 10, 200, tfId.getPreferredSize().height);
        contentPane.add(tfNombre);
        tfNombre.setBounds(170, 45, 415, 27);
        contentPane.add(tfApellidos);
        tfApellidos.setBounds(170, 80, 415, 27);

        //---- bBuscar ----
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(e -> bBuscar(e));
        contentPane.add(bBuscar);
        bBuscar.setBounds(380, 10, 145, bBuscar.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- taUsuarios ----
            taUsuarios.setEditable(false);
            scrollPane1.setViewportView(taUsuarios);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 270, 730, 280);

        //---- bVaciar ----
        bVaciar.setText("Vaciar campos/filtros");
        bVaciar.addActionListener(e -> bVaciar(e));
        contentPane.add(bVaciar);
        bVaciar.setBounds(430, 230, 165, 27);

        //---- bBuscarTabla ----
        bBuscarTabla.setText("Buscar en la tabla");
        bBuscarTabla.addActionListener(e -> bBuscarTabla(e));
        contentPane.add(bBuscarTabla);
        bBuscarTabla.setBounds(610, 230, 155, 27);

        //---- label4 ----
        label4.setText("Fecha Nacimiento");
        contentPane.add(label4);
        label4.setBounds(55, 120, 115, 16);

        //---- label5 ----
        label5.setText("Email");
        contentPane.add(label5);
        label5.setBounds(55, 155, 115, 16);
        contentPane.add(tfEmail);
        tfEmail.setBounds(170, 150, 415, 27);
        contentPane.add(tfDireccion);
        tfDireccion.setBounds(170, 185, 415, 27);

        //---- label6 ----
        label6.setText("Direcci\u00f3n");
        contentPane.add(label6);
        label6.setBounds(55, 190, 115, 16);

        //---- tfDia ----
        tfDia.setText("dd");
        contentPane.add(tfDia);
        tfDia.setBounds(new Rectangle(new Point(275, 115), tfDia.getPreferredSize()));

        //---- tfMes ----
        tfMes.setText("mm");
        contentPane.add(tfMes);
        tfMes.setBounds(390, 115, 49, 27);

        //---- tfAnio ----
        tfAnio.setText("yyyy");
        contentPane.add(tfAnio);
        tfAnio.setBounds(520, 115, 80, 27);

        //---- label7 ----
        label7.setText("D\u00eda");
        contentPane.add(label7);
        label7.setBounds(215, 120, 55, 16);

        //---- label8 ----
        label8.setText("Mes");
        contentPane.add(label8);
        label8.setBounds(340, 120, 55, 16);

        //---- label9 ----
        label9.setText("A\u00f1o");
        contentPane.add(label9);
        label9.setBounds(470, 120, 55, 16);

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
    private JTextField tfApellidos;
    private JButton bBuscar;
    private JScrollPane scrollPane1;
    private JTextArea taUsuarios;
    private JButton bVaciar;
    private JButton bBuscarTabla;
    private JLabel label4;
    private JLabel label5;
    private JTextField tfEmail;
    private JTextField tfDireccion;
    private JLabel label6;
    private JTextField tfDia;
    private JTextField tfMes;
    private JTextField tfAnio;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
