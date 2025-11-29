/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

/**
 *
 * @author Alvaro
 */
public class Orden {
    private String codigo, descripcion, tipo;
    private double precio;
    private Orden[] ordenes = new Orden[100];
    private int count = 0;

    public Orden(String codigo, String tipo, String descripcion) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = 50;
        this.tipo= tipo;
    }
    
    public boolean AgregarOrden(Orden nuevaOrden) {
    if (count < ordenes.length) {
        ordenes[count] = nuevaOrden;
        count++;
        return true;
    }
    return false;
}


    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCodigo() {
        return codigo;
    }
  
}
