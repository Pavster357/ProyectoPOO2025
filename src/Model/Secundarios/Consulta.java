/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import Model.Medico;

public class Consulta {

    private String codigo, motivo, estado, signosVitales, examenFisico, diagnostico, plan;
    private int precio, count;
    private Receta receta;
    private Orden[] ordenes;
    private Cita cita;
    private String paciente;

    public Consulta(String codigo, Cita cita, String motivo, String signosVitales, String examenFisico, String diagnostico, String plan, Receta receta, Orden[] ordenes) {
        this.codigo = codigo;
        this.motivo = motivo;
        this.estado = "Abierta";
        this.signosVitales = signosVitales;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.plan = plan;
        this.receta = receta;
        this.ordenes = ordenes;
        this.cita = cita;
    }
    
    public boolean AbrirOrden(Orden o) {
        if (count < ordenes.length) {
            ordenes[count++] = o;
            return true;
        }
        return false;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getPlan() {
        return plan;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCount() {
        return count;
    }

    public Receta getReceta() {
        return receta;
    }

    public Orden[] getOrdenes() {
        return ordenes;
    }

    public Cita getCita() {
        return cita;
    }

    public String getPaciente() {
        return paciente;
    }
       
}


