/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.Paciente;

/**
 *
 * @author Alvaro
 */
public class GestionPacientes {
    private  Paciente[] pacientes;
    private int count;
            
     public GestionPacientes () {
        pacientes = new Paciente[200];
        count = 0;
    }


    public boolean AgregarPaciente(Paciente p) {
        if (count < pacientes.length) {
            pacientes[count] = p;
            count++;
            return true;
        }
        return false;
    }

    public boolean ActualizarPaciente(Paciente original, Paciente actualizado) {
        for (int i = 0; i < count; i++) {
            if (pacientes[i] == original) {
                pacientes[i] = actualizado; 
                return true;
            }
        }
        return false;
    }

    public boolean EliminarPaciente(Paciente paciente) {
        for (int i = 0; i < count; i++) {
            if (pacientes[i] != null && pacientes[i] == paciente) {
                for (int j = i; j < count - 1; j++) {
                    pacientes[j] = pacientes[j + 1];
                }
                pacientes[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public Paciente buscarPaciente(String dni) {
    for (int i = 0; i < count; i++) {
        if (pacientes[i] != null && pacientes[i].getDni().equals(dni)) {
            return pacientes[i];
        }
    }
    return null;
    }
    
    public Paciente[] getPacientes() {
        return pacientes;
    }

    public int getCount() {
        return count;
    }

    
}
