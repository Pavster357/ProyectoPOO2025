/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Medico;
import Model.Secundarios.AgendaMedica;
import Model.Secundarios.Cita;
import Model.Secundarios.Consulta;
import Model.Secundarios.Paciente;
import java.util.HashMap;

public class GestionAgendaMedica {

    private HashMap<String, AgendaMedica> agendas;

    public GestionAgendaMedica() {
        agendas = new HashMap<>();
    }

    private AgendaMedica getAgendaDe(Medico medico) {
        if (medico == null){
            return null;
        }
        String dni = medico.getDNI();
        if (!agendas.containsKey(dni)) {
            agendas.put(dni, new AgendaMedica(medico));
        }
        return agendas.get(dni);
    }

    public boolean agregarCita(Cita nueva) {
        if (nueva == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(nueva.getMedico());
        return agenda.agregarCitaAgenda(nueva);
    }
    
    public boolean agregarConsulta(Consulta nueva) {
        if (nueva == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(nueva.getCita().getMedico());
        return agenda.agregarConsultaAgenda(nueva);
    }

    public boolean actualizarCita(Cita nueva) {
        if (nueva == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(nueva.getMedico());
        return agenda.actualizarCitaAgenda(nueva);
    }
    
    public boolean actualizarConsulta(Consulta nueva) {
        if (nueva == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(nueva.getCita().getMedico());
        return agenda.actualizarConsultaAgenda(nueva);
    }

    public boolean eliminarCita(Cita cita) {
        if (cita == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(cita.getMedico());
        return agenda.eliminarCitaAgenda(cita);
    }
    
    public boolean eliminarConsulta(Consulta consulta) {
        if (consulta == null){
            return false;
        }
        AgendaMedica agenda = getAgendaDe(consulta.getCita().getMedico());
        return agenda.eliminarConsultaAgenda(consulta);
    }

    public AgendaMedica getAgendaMedicaDe(Medico medico) {
        return getAgendaDe(medico);
    }
}

