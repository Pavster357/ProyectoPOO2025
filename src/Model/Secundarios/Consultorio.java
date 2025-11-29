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
public class Consultorio {
    private String codigo, especialidad, estado, dia;
    private Medico medico;
    private Cita[] citas;
    private int cantidadCitas;

    public Consultorio(String codigo, String especialidad, String estado, Medico medico, String dia) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.estado = estado;
        this.dia = dia;
        this.medico = medico;
        this.citas = new Cita[16];
        this.cantidadCitas = 0;
    }
    
    @Override
    public String toString() {
    return getCodigo() + " - " + getEstado() + " por: "+ getMedico() + " - " + getDia();
    }

    public String getDia() {
        return dia;
    }

    public Medico getMedico() {
        return medico;
    }

    public int getCantidadCitas() {
        return cantidadCitas;
    }

    public void setCantidadCitas(int cantidadCitas) {
        this.cantidadCitas = cantidadCitas;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public Cita[] getCitas() {
        return citas;
    }
    

}
