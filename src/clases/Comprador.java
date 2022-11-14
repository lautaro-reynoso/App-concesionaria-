package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateo
 */
public class Comprador {
    
    long dni, telefono,cuil;
    
    String nombre,apellido,correo_e;


    public Comprador(long dni, long telefono, long cuil, String nombre, String apellido, String correo_e) {
        this.dni = dni;
        this.telefono = telefono;
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_e = correo_e;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Comprador{");
        sb.append("dni=").append(dni);
        sb.append(", telefono=").append(telefono);
        sb.append(", cuil=").append(cuil);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", correo_e='").append(correo_e).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
