/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;

/**
 *
 * @author Alvaro
 */
public class GestionConsultorio {
    private Consultorio[] consultorios;
    private int count;

    public GestionConsultorio() {
        consultorios = new Consultorio[100];
        count = 0;
    }
    
    public boolean AgregarConsultorio(Consultorio c) {
        if (count < consultorios.length) {
            consultorios[count] = c;
            count++;
            return true;
        }
        return false;
    }


    public boolean ActualizarConsultorio(Consultorio original, Consultorio actualizado) {
        for (int i = 0; i < count; i++) {
            if (consultorios[i] == original) {
                consultorios[i] = actualizado;
                return true;
            }
        }
        return false;
    }

    public boolean EliminarConsultorio(Consultorio c) {
        for (int i = 0; i < count; i++) {
            if (consultorios[i] == c) {
                for (int j = i; j < count - 1; j++) {
                    consultorios[j] = consultorios[j + 1];
                }
                consultorios[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    
    public Consultorio[] getConsultorios() {
        return consultorios;
    }

    public int getCount() {
        return count;
    }


}

