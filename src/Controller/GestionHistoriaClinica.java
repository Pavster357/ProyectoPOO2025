/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.HistoriaClinica;
import Model.Secundarios.Consulta;
import Model.Usuario;
import Model.Medico;
import java.util.ArrayList;
import java.util.List;


public class GestionHistoriaClinica {

    private HistoriaClinica[] historias;
    private int count;

    public GestionHistoriaClinica() {
        this.historias = new HistoriaClinica[500]; // espacio suficiente para el proyecto
        this.count = 0;
    }

    /* Autorización simple: solo Medico o Administrador */
    private boolean autorizadoParaVer(Usuario user) {
        if (user == null) return false;
        // si el empleado es instancia de Medico -> permitido
        if (user.getEmpleado() instanceof Medico) return true;
        // si rol es Administrador -> permitido
        if ("Administrador".equalsIgnoreCase(user.getRol())) return true;
        return false;
    }

    /* Guarda un episodio (no sobrescribe) */
    public boolean agregarHistoria(HistoriaClinica h) {
        if (h == null) return false;
        if (count < historias.length) {
            historias[count++] = h;
            return true;
        }
        return false;
    }

    public HistoriaClinica[] listarHistorias(Usuario user) {
        if (!autorizadoParaVer(user)) throw new SecurityException("Acceso denegado: no autorizado a ver historias");
        HistoriaClinica[] res = new HistoriaClinica[count];
        for (int i = 0; i < count; i++) res[i] = historias[i];
        return res;
    }

    public List<HistoriaClinica> buscarPorPaciente(Usuario user, String dniPaciente) {
        if (!autorizadoParaVer(user)) throw new SecurityException("Acceso denegado");
        List<HistoriaClinica> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HistoriaClinica h = historias[i];
            if (h != null && h.getPacienteDni() != null && h.getPacienteDni().equals(dniPaciente)) {
                out.add(h);
            }
        }
        return out;
    }

    public List<HistoriaClinica> buscarPorFecha(Usuario user, String fechaIso) {
        if (!autorizadoParaVer(user)) throw new SecurityException("Acceso denegado");
        List<HistoriaClinica> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HistoriaClinica h = historias[i];
            if (h != null && h.getFechaStr().equals(fechaIso)) {
                out.add(h);
            }
        }
        return out;
    }

    public List<HistoriaClinica> buscarPorMedico(Usuario user, Medico medico) {
        if (!autorizadoParaVer(user)) throw new SecurityException("Acceso denegado");
        if (medico == null) return new ArrayList<>();
        String dni = medico.getDNI();
        List<HistoriaClinica> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HistoriaClinica h = historias[i];
            if (h != null && h.getMedicoDni() != null && h.getMedicoDni().equals(dni)) {
                out.add(h);
            }
        }
        return out;
    }

    public List<HistoriaClinica> buscarPorEspecialidad(Usuario user, String especialidad) {
        if (!autorizadoParaVer(user)) throw new SecurityException("Acceso denegado");
        if (especialidad == null) return new ArrayList<>();
        List<HistoriaClinica> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HistoriaClinica h = historias[i];
            if (h != null && h.getEspecialidad() != null && h.getEspecialidad().equalsIgnoreCase(especialidad)) {
                out.add(h);
            }
        }
        return out;
    }


    public String exportHistoriaToText(HistoriaClinica h) {
        if (h == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(h.getId()).append("\n");
        sb.append("Fecha: ").append(h.getFechaStr()).append("\n");
        sb.append("Paciente DNI: ").append(h.getPacienteDni()).append("\n");
        sb.append("Médico: ").append(h.getMedicoNombre()).append("\n");
        sb.append("Especialidad: ").append(h.getEspecialidad()).append("\n\n");
        if (h.getConsulta() != null) {
            sb.append("---- Consulta ----\n");
            sb.append("Codigo consulta: ").append(h.getConsulta().getCodigo()).append("\n");
            sb.append("Motivo: ").append(h.getConsulta().getMotivo()).append("\n");
            sb.append("Diagnóstico: ").append(h.getConsulta().getDiagnostico()).append("\n");
            sb.append("Plan: ").append(h.getConsulta().getPlan()).append("\n");
            sb.append("Estado: ").append(h.getConsulta().getEstado()).append("\n");
            
        }
        return sb.toString();
    }
    
}
