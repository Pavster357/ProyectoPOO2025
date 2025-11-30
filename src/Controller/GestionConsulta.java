/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Secundarios.Consulta;
/**
 *
 * @author Alvaro
 */
public class GestionConsulta {
    private Consulta[] consultas;
    private int count;

    public GestionConsulta() {
        consultas = new Consulta[200]; 
        count = 0;
    }
    
    public boolean agregarConsulta(Consulta c) {
        if (count < consultas.length) {
            consultas[count] = c;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean ActualizarConsulta(Consulta original, Consulta actualizada){
        for (int i = 0; i < count; i++){
            if (consultas[i] == original){
                consultas[i] = actualizada;
                return true;
            }
        }
        return false;
    }
    
    public boolean EliminarConsulta(Consulta consulta) {
        for (int i = 0; i < count; i++) {
            if (consultas[i] == consulta) {
                for (int j = i; j < count - 1; j++) {
                    consultas[j] = consultas[j + 1];
                }
                consultas[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public Consulta buscarCodigo(String cod){
        for (int i = 0; i < count; i++){
            if (consultas[i] != null && consultas[i].getCodigo().equals(cod)){
                return consultas[i];
            }
        }
        return null;
    }

    public Consulta[] getConsultas() {
        return consultas;
    }

    public int getCount() {
        return count;
    }
    
}
