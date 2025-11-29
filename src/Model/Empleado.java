/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alvaro
 */
public class Empleado {
    private String Nombres, Apellidos, Correo, DNI, Telefono;;

    public Empleado(String Nombres, String Apellidos, String Correo, String DNI, String Telefono) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.DNI = DNI;
        this.Telefono = Telefono;
    }
    

    public String getTelefono() {
        return Telefono;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getDNI() {
        return DNI;
    }

    
}
