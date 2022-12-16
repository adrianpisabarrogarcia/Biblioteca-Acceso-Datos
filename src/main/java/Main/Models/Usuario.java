package Main.Models;

import Main.Controlers.Conveters.CategoriaConverter;
import Main.Controlers.Conveters.UsuarioConverter;
import Main.Controlers.XStream.ListaCategoriasLibros;
import Main.Controlers.XStream.SpecificModels.CategoriaLibros;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String email;
    private String direccion;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, Date fechaNacimiento, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //format date
    public String getFechaNacimientoString() {
        return fechaNacimiento.getDate() + "/" + (fechaNacimiento.getMonth() + 1) + "/" + (fechaNacimiento.getYear());
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + getFechaNacimientoString() +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public static XStream prepararXStream(){
        XStream xstream = new XStream(new DomDriver());
        //Convertidor para parsear a un objeto
        xstream.registerConverter(new UsuarioConverter());
        //Sin referencias circulares
        xstream.setMode(XStream.NO_REFERENCES);
        //Añadir alias
        xstream.alias("usuario", Usuario.class);
        //Añadir atributos
        xstream.useAttributeFor(Usuario.class, "id");
        //Allow types
        xstream.allowTypes(new Class[]{Usuario.class});

        return xstream;
    }
}
