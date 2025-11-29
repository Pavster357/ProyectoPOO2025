/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alvaro
 */
public class Usuario{
    private String Usuario, Constraseña, Rol;
    private Empleado Empleado;

    public Usuario(String Usuario, String Constraseña, String Rol, Empleado Empleado) {
        this.Usuario = Usuario;
        this.Constraseña = Constraseña;
        this.Rol = Rol;
        this.Empleado = Empleado;
    }
    
    public String toString() {
        return Empleado.getNombres() + " " + Empleado.getApellidos();
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getConstraseña() {
        return Constraseña;
    }

    public String getRol() {
        return Rol;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }
    
}
