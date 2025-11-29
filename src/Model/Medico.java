/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.GestionUsuarios;

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
    
    public static Medico[] getMedicos() {

    Controller.GestionUsuarios gestion = pooprojecto.Sistema.getGestionUsuarios();
        Usuario[] usuarios = gestion.getUsuarios();
        int totalUsuarios = gestion.getNroUsuarios();
        
        int contadorMedicos = 0;
        for (int i = 0; i < totalUsuarios; i++) {
            Usuario u = usuarios[i];
            if (u != null && u.getEmpleado() instanceof Medico) {
                contadorMedicos++;
            }
     }
        Medico[] medicos = new Medico[contadorMedicos];
        int index = 0;
        
        for (int i = 0; i < totalUsuarios; i++) {
            Usuario u = usuarios[i];
            if (u != null && u.getEmpleado() instanceof Medico) {
                medicos[index++] = (Medico) u.getEmpleado();
            }
        }
        return medicos;
    }
}
