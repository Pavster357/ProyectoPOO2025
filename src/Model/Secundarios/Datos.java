/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

/**
 *
 * @author leonardorodriguez
 */

public class Datos {
    public static Consulta[] listaConsultas = new Consulta[200];
    public static int countConsultas = 0;

    public static Factura[] listaFacturas = new Factura[200];
    public static int countFacturas = 0;

    public static void agregarConsulta(Consulta c) {
        listaConsultas[countConsultas++] = c;
    }

    public static void agregarFactura(Factura f) {
        listaFacturas[countFacturas++] = f;
    }
}


