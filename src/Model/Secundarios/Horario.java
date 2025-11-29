/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

/**
 *
 * @author Alvaro
 */
public class Horario {
    private String medicoID;
    private String consultorio;
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Horario(String medicoID, String consultorio, String fecha, String horaInicio, String horaFin) {
        this.medicoID = medicoID;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    
}
