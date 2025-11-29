/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

import Controller.GestionConsulta;
import Controller.GestionConsultorio;
import Controller.GestionFactura;
import Model.Empleado;
import Model.Medico;

/**
 *
 * @author leonardorodriguez
 */
public class Reportes {
    private GestionConsulta gestionConsulta;
    private GestionConsultorio gestionConsultorio;
    private GestionFactura gestionFactura;

    public Reportes(GestionConsulta gc, GestionConsultorio gco, GestionFactura gf) {
        this.gestionConsulta = gc;
        this.gestionConsultorio = gco;
        this.gestionFactura = gf;
    }

    public String ocupacionConsultorios(String fecha) {

        StringBuilder sb = new StringBuilder();
        sb.append("REPORTE DE OCUPACIÓN - Fecha: ").append(fecha).append("\n\n");

        Consultorio[] consultorios = gestionConsultorio.getConsultorios();
        int total = gestionConsultorio.getCount();

        for (int i = 0; i < total; i++) {

            Consultorio cons = consultorios[i];
            sb.append("Consultorio ").append(cons.getCodigo()).append(": ");

            boolean ocupado = false;

            for (Cita c : cons.getCitas()) {
                if (c != null && c.getDia().equals(fecha)) {
                    ocupado = true;
                    sb.append("OCUPADO (").append(c.getHora()).append(")\n");
                    break;
                }
            }

            if (!ocupado) {
                sb.append("LIBRE\n");
            }
        }

        return sb.toString();
    }


    public String produccionPorMedico(Medico medico) {

        StringBuilder sb = new StringBuilder();

        sb.append("REPORTE DE PRODUCCIÓN POR MÉDICO\n");
        sb.append("Médico: ").append(medico.toString()).append("\n\n");


        Consulta[] consultas = gestionConsulta.getConsultas();

        int totalConsultas = 0;
        double totalFacturado = 0;

        for (Consulta c : consultas) {
            if (c != null && c.getCita().getMedico().equals(medico)) {
                totalConsultas++;
            }
        }

        Factura[] facturas = gestionFactura.getFacturas();
        int nf = gestionFactura.getCount();

        for (int i = 0; i < nf; i++) {
            Factura f = facturas[i];
            if (f != null && f.getConsulta().getCita().getMedico().equals(medico)) {
                totalFacturado += f.getMontoTotal();
            }
        }

        sb.append("Consultas realizadas: ").append(totalConsultas).append("\n");
        sb.append("Total facturado: S/ ").append(totalFacturado).append("\n");

        return sb.toString();
    }

    public String ingresosPorRango(String fechaInicio, String fechaFin) {

        double total = gestionFactura.calcularIngresos(fechaInicio, fechaFin);

        return "REPORTE DE INGRESOS\n" +
               "Desde: " + fechaInicio + "\n" +
               "Hasta: " + fechaFin + "\n" +
               "TOTAL: S/ " + total;
    }
}
