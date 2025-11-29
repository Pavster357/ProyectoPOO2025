/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

/**
 *
 * @author Alvaro
 */
public class Medicamento {
    private String nombre, marca, frecuencia, duracion, dosis;

    public Medicamento(String nombre, String marca, String frecuencia, String duracion, String dosis) {
        this.nombre = nombre;
        this.marca = marca;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getDosis() {
        return dosis;
    }
    
}
