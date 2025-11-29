/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import Model.Medico;

/**
 *
 * @author Alvaro
 */
public class Cita {
    private String diaSemana, hora;
    private Medico medico;
    private Consultorio consultorio;
    private Paciente paciente;
    private String modalidad;         
    private String estado; 

    public Cita(String Dia, String hora, String modalidad, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.diaSemana = Dia;
        this.hora = hora;
        this.modalidad = modalidad;
        this.estado = "Programada";
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }
       
    @Override
    public String toString() {
    return getPaciente().getNombres() + " - " + getPaciente().getDni() + " - "+ getMedico() + " - " + getEstado();
    }

    public String getDia() {
        return diaSemana;
    }

    public String getHora() {
        return hora;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    
}
