/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import Model.Secundarios.Medicamento;

/**
 *
 * @author Alvaro
 */
public class Receta {
    private Medicamento[] medicamentos;
    private int count;

    public Receta() {
        this.medicamentos = new Medicamento[100];
        this.count = 0;
    }
    
    public boolean AgregarMedicamento(Medicamento ref){
        if(count < medicamentos.length){
            medicamentos[count] = ref;
            count++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean EliminarMedicamento(String Nombre){
        for(int i = 0; i < count; i++){
            if(medicamentos[i].getNombre().equals(Nombre)){
                for(int j = i; j < count - 1; j++){
                    medicamentos[j] = medicamentos[j+1];
                }
                medicamentos[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public boolean EditarMedicamento(String Nombre, Medicamento nuevo){
        for(int i = 0; i < count; i++){
            if(medicamentos[i].getNombre().equals(Nombre)){
                medicamentos[i] = nuevo;
                return true;
            }
        }
        return false;
    }

    public Medicamento[] getMedicamentos() {
        return medicamentos;
    }

    public int getCount() {
        return count;
    }
    
    
}
