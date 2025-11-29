/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alvaro
 */
public class Medico extends Empleado{
    private String Especialidad;

    public Medico( String Nombres, String Apellidos, String Correo, String DNI, String Telefono, String Especialidad) {
        super(Nombres, Apellidos, Correo, DNI, Telefono);
        this.Especialidad = Especialidad;
    }
    
    @Override
    public String toString() {
    return getNombres() + " " + getApellidos() + " - " + Especialidad;
    }

    
    public String getEspecialidad() {
        return Especialidad;
    }
    
}
