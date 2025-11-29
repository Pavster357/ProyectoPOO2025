/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Secundarios.Factura;

/**
 *
 * @author Alvaro
 */
public class GestionFactura {
    private Factura[] facturas;
    private int count;

    public GestionFactura() {
        facturas = new Factura[200];
        count = 0;
    }

    public boolean agregarFactura(Factura f) {
        if (count < facturas.length) {
            facturas[count++] = f;
            return true;
        }
        return false;
    }

    public Factura buscarFactura(String numeroFactura) {
        for (int i = 0; i < count; i++) {
            if (facturas[i] != null && facturas[i].getNumeroFactura().equals(numeroFactura)) {
                return facturas[i];
            }
        }
        return null;
    }

    public Factura[] buscarPorDniPaciente(String dniPaciente) {

        Factura[] resultado = new Factura[count];
        int idx = 0;

        for (int i = 0; i < count; i++) {
            Factura f = facturas[i];

            if (f != null && f.getPaciente().getDni().equals(dniPaciente)) {
                resultado[idx++] = f;
            }
        }

        return resultado;
    }

    public Factura[] buscarPorEstado(String estado) {

        Factura[] resultado = new Factura[count];
        int idx = 0;

        for (int i = 0; i < count; i++) {
            Factura f = facturas[i];

            if (f != null && f.getEstado().equalsIgnoreCase(estado)) {
                resultado[idx++] = f;
            }
        }

        return resultado;
    }

    public Factura[] buscarPorFecha(String fecha) {

        Factura[] resultado = new Factura[count];
        int idx = 0;

        for (int i = 0; i < count; i++) {

            if (facturas[i] == null) continue;

            String fechaFactura = facturas[i].getFecha().toString();

            if (fechaFactura.contains(fecha)) {
                resultado[idx++] = facturas[i];
            }
        }

        return resultado;
    }

    public boolean pagarFactura(String numeroFactura) {

        Factura f = buscarFactura(numeroFactura);

        if (f != null && !f.getEstado().equals("Pagada")) {
            f.pagar();
            return true;
        }
        return false;
    }

    public boolean anularFactura(String numeroFactura) {

        Factura f = buscarFactura(numeroFactura);

        if (f != null && !f.getEstado().equals("Anulada")) {
            f.anular();
            return true;
        }
        return false;
    }

    public double calcularIngresos(String fechaInicio, String fechaFin) {
        double total = 0;

        for (int i = 0; i < count; i++) {
            Factura f = facturas[i];

            if (f == null) continue;

            String fecha = f.getFecha().toString();

            if (fecha.compareTo(fechaInicio) >= 0 && 
                fecha.compareTo(fechaFin) <= 0) 
            {
                total += f.getMontoTotal();
            }
        }

        return total;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public int getCount() {
        return count;
    }
    
}