/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import Model.Medico;
import Model.Secundarios.Cita;
import Model.Secundarios.Paciente;

public class AgendaMedica {

    private Medico medicoLogueado;
    private Cita[] citas;
    private int count;
    private Consulta[] consultas;
    private int countcons;
    private Receta [] receta;
    private int countreceta;
    private Orden[] ordenes;
    private int countoredenes;

    public AgendaMedica(Medico medicoLogueado) {
        this.medicoLogueado = medicoLogueado;
        this.citas = new Cita[18];
        this.count = 0;
        this.consultas = new Consulta[100];
        this.countcons = 0;
        this.receta = new Receta[100];
        this.countreceta = 0;
        this.ordenes = new Orden[100];
        this.countoredenes = 0;
    }

    public boolean agregarCitaAgenda(Cita nuevaCita) {
        if (nuevaCita == null){
            return false;
        }
        if (!nuevaCita.getMedico().getDNI().equals(medicoLogueado.getDNI())) {
            return false;
        }
        if (count < citas.length) {
            citas[count] = nuevaCita;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean agregarConsultaAgenda(Consulta nuevaConsulta) {
        if (nuevaConsulta == null){
            return false;
        }
        if (!nuevaConsulta.getCita().getMedico().getDNI().equals(medicoLogueado.getDNI())) {
            return false;
        }
        if (countcons < consultas.length) {
            consultas[countcons] = nuevaConsulta;
            countcons++;
            return true;
        }
        return false;
    }
    
    public boolean eliminarCitaAgenda(Cita cita) {
        if (cita == null){
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (citas[i] != null && citas[i] == cita) {
                citas[i] = citas[count - 1];
                citas[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarConsultaAgenda(Consulta consulta) {
        if (consulta == null){
            return false;
        }
        for (int i = 0; i < countcons; i++) {
            if (consultas[i] != null && consultas[i] == consulta) {
                consultas[i] = consultas[countcons - 1];
                consultas[countcons - 1] = null;
                countcons--;
                return true;
            }
        }
        return false;
    }

    public boolean actualizarCitaAgenda(Cita citaNueva) {
        if (citaNueva == null){
            return false;
        }
        for (int i = 0; i < count; i++) {
            Cita c = citas[i];
            if (c != null && c.getPaciente().getDni().equals(citaNueva.getPaciente().getDni())) {
                citas[i] = citaNueva;
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarConsultaAgenda(Consulta consultaNueva) {
        if (consultaNueva == null){
            return false;
        }
        for (int i = 0; i < countcons; i++) {
            Consulta c = consultas[i];
            if (c != null && c.getCita().getPaciente().getDni().equals(consultaNueva.getCita().getPaciente().getDni())) {
                consultas[i] = consultaNueva;
                return true;
            }
        }
        return false;
    } 
    
    public Medico getMedicoLogueado() {
        return medicoLogueado;
    }

    public Cita[] getCitas() {
        return citas;
    }

    public int getCount() {
        return count;
    }
}
