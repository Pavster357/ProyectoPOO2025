/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.Orden;
import Model.Secundarios.Orden;

/**
 *
 * @author Alvaro
 */
public class GestionOrdenes {
    private Orden[] ordenes;
    private int count;

    public GestionOrdenes() {
        this.ordenes = new Orden[100];
        this.count = 0;
    }
    
    public boolean AgregarOrden(Orden ref){
        if(count < ordenes.length){
            ordenes[count] = ref;
            count++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean EliminarEliminar(String codigo){
        for(int i = 0; i < count; i++){
            if(ordenes[i].getCodigo().equals(codigo)){
                for(int j = i; j < count - 1; j++){
                    ordenes[j] = ordenes[j+1];
                }
                ordenes[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public boolean EditarOrden(String codigo, Orden nuevo){
        for(int i = 0; i < count; i++){
            if(ordenes[i].getCodigo().equals(codigo)){
                ordenes[i] = nuevo;
                return true;
            }
        }
        return false;
    }
    
    
}
