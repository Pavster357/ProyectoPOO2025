/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;
import Model.Secundarios.Paciente;

/**
 *
 * @author Alvaro
 */
public class GestionCita {
    private Cita[] citas;
    private Cita[] citasSalida;
    private int countSalida;
    private int count;
    

    public GestionCita() {
        this.citas = new Cita[100];
        this.count = 0;
        this.citasSalida = new Cita[100];
        this.countSalida = 0;
    }

    public boolean AgregarCitaSalida(Cita c){
        if(countSalida < citasSalida.length){
            citasSalida[countSalida] = c;
            countSalida++;
            return true;
        }
        return false;
    }
    
    public boolean AgregarCita(Cita c){
        if (count < citas.length){
            citas[count] = c;
            count++;
            return true;
        }
        return false;
    }

    public boolean ActualizarCita(Cita original, Cita actualizada){
        for (int i = 0; i < count; i++){
            if (citas[i] == original){
                citas[i] = actualizada;
                return true;
            }
        }
        return false;
    }

    public boolean EliminarCita(Cita cita) {
        for (int i = 0; i < count; i++) {
            if (citas[i] == cita) {
                for (int j = i; j < count - 1; j++) {
                    citas[j] = citas[j + 1];
                }
                citas[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }   
    
    public boolean AgregarCitaConsultorio(Consultorio consultorio, Cita nuevaCita){
        if (consultorio == null || nuevaCita == null){
            return false;
        }
        Cita[] citas = consultorio.getCitas();
        int n = consultorio.getCantidadCitas();
        if (n >= citas.length){
            return false;
        }
        citas[n] = nuevaCita;
        consultorio.setCantidadCitas(n + 1);

        return true;
    }


    public boolean EliminarCitaConsultorio(Consultorio consultorio, Cita citaEliminar){
        if (consultorio == null || citaEliminar == null){
            return false;
        }
        Cita[] citas = consultorio.getCitas();
        int n = consultorio.getCantidadCitas();
        for (int i = 0; i < n; i++) {
            if (citas[i] == citaEliminar) {
                citas[i] = citas[n - 1];
                citas[n - 1] = null;

                consultorio.setCantidadCitas(n - 1);
                return true;
            }
        }
        return false;
    }


    public boolean ActualizarCitaConsultorio(Consultorio consultorio, Cita nueva){
        if (consultorio == null || nueva == null){
            return false;
        }
        Cita[] citas = consultorio.getCitas();
        int n = consultorio.getCantidadCitas();
        for (int i = 0; i < n; i++) {
            if (citas[i] != null && citas[i].getPaciente().equals(nueva.getPaciente())){
                citas[i] = nueva;
                return true;
            }
        }
        return false;
    }
    
    public Cita buscarCitaPorDniYHora(Cita cita){
        for (int i = 0; i < count; i++){
            if (citas[i] != null && citas[i] == cita){
                return citas[i];
            }
        }
        return null;
    }
    
    public Cita[] getCitas(){
        return citas;
    }

    public int getCount(){
        return count;
    }
    
}    

