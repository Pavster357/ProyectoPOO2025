/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import java.util.Date;

/**
 *
 * @author leonardorodriguez
 */
public class Factura {
    private String numeroFactura;
    private Date fecha;

    private Paciente paciente;
    private Consulta consulta;

    private double montoTotal;
    private String estado; 
    private String metodoPago; 

    private String[] detalles;
    private int countDetalles;

    public Factura(String numeroFactura, Paciente paciente, Consulta consulta, String metodoPago) {
        this.numeroFactura = numeroFactura;
        this.paciente = paciente;
        this.consulta = consulta;
        this.metodoPago = metodoPago;

        this.fecha = new Date();   
        this.estado = "Pendiente";  

        this.detalles = new String[20];
        this.countDetalles = 0;

        calcularMontoTotal();
    }

    public boolean agregarDetalle(String detalle) {
        if (countDetalles < detalles.length) {
            detalles[countDetalles++] = detalle;
            return true;
        }
        return false;
    }

    private void calcularMontoTotal() {

        double total = 0;

        if (consulta != null) {
            total += consulta.getPrecio();
        }

        if (consulta != null || consulta.getOrdenes() != null) {
            Orden[] ordenes = consulta.getOrdenes();

            for (Orden o : ordenes) {
                if (o != null) {
                    total += o.getPrecio();  
                }
            }
        }

        this.montoTotal = total;
    }
    
    public void recalcular() {
    calcularMontoTotal();
    }
    
    @Override
    public String toString() {
    return "Factura " + numeroFactura + " - " + paciente.getNombres() + 
           " (" + estado + ")";
    }
    
    public String generarRecibo() {
    StringBuilder sb = new StringBuilder();
    sb.append("------- RECIBO -------\n");
    sb.append("Factura: ").append(numeroFactura).append("\n");
    sb.append("Fecha: ").append(fecha).append("\n");
    sb.append("Paciente: ").append(paciente.getNombres()).append("\n");
    sb.append("Método de pago: ").append(metodoPago).append("\n");
    sb.append("Estado: ").append(estado).append("\n\n");

    sb.append("DETALLES:\n");

    if (consulta != null) {
        sb.append("- Consulta: S/ ").append(consulta.getPrecio()).append("\n");
    }

    if (consulta != null && consulta.getOrdenes() != null) {
        for (Orden o : consulta.getOrdenes()) {
            if (o != null) {
                sb.append("- Orden: ").append(o.getTipo())
                  .append("  S/ ").append(o.getPrecio()).append("\n");
            }
        }
    }

    sb.append("\nTOTAL: S/ ").append(montoTotal);
    sb.append("\n-----------------------\n");

    return sb.toString();
    }


    public void pagar() {
        this.estado = "Pagada";
    }

    public void anular() {
        this.estado = "Anulada";
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String[] getDetalles() {
        return detalles;
    }
    
    
}
