/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class HistoriaClinica {
     private String id;             
    private Consulta consulta;      
    private String pacienteDni;       
    private String medicoDni;         
    private String medicoNombre;     
    private String especialidad;      
    private String fechaStr;          
    private Date fecha;              

    public HistoriaClinica(String id, Consulta consulta) {
        this.id = id;
        this.consulta = consulta;
        if (consulta != null && consulta.getCita() != null && consulta.getCita().getPaciente() != null) {
            this.pacienteDni = consulta.getCita().getPaciente().getDni();
        } else {
            this.pacienteDni = "";
        }
        if (consulta != null && consulta.getCita() != null && consulta.getCita().getMedico() != null) {
            this.medicoDni = consulta.getCita().getMedico().getDNI();
            this.medicoNombre = consulta.getCita().getMedico().toString();
            this.especialidad = consulta.getCita().getMedico().getEspecialidad();
        } else {
            this.medicoDni = "";
            this.medicoNombre = "";
            this.especialidad = "";
        }
        this.fecha = new Date();
        this.fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(this.fecha);
    }


    public String getId() { return id; }
    public Consulta getConsulta() { return consulta; }
    public String getPacienteDni() { return pacienteDni; }
    public String getMedicoDni() { return medicoDni; }
    public String getMedicoNombre() { return medicoNombre; }
    public String getEspecialidad() { return especialidad; }
    public String getFechaStr() { return fechaStr; }
    public Date getFecha() { return fecha; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HistoriaClinica{id=").append(id)
          .append(", pacienteDni=").append(pacienteDni)
          .append(", medico=").append(medicoNombre)
          .append(", especialidad=").append(especialidad)
          .append(", fecha=").append(fechaStr).append("}");
        return sb.toString();
    }

    public Object getMedico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
