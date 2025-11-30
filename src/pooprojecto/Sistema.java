/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooprojecto;

import Controller.GestionAgendaMedica;
import Controller.GestionCita;
import Controller.GestionFactura;
import Controller.GestionUsuarios;
import Controller.GestionConsulta;
import Controller.GestionConsultorio;
import Controller.GestionOrdenes;
import Controller.GestionPacientes;
import Controller.GestionResumenClinicos;
import Model.Usuario;

/**
 *
 * @author Alvaro
 */
public class Sistema {
    static GestionUsuarios gestionUsuarios;
    static GestionFactura gestionFacturas;
    static GestionCita gestionCita;
    static GestionConsulta gestionConsulta;
    static GestionConsultorio gestionConsultorio;
    static GestionPacientes gestionPacientes;
    static GestionAgendaMedica gestionAgendaMedica;
    static GestionResumenClinicos gestionResumenClinico;
    static GestionOrdenes gestionOrdenes;

    
    static void InicializarVariables(){
        gestionUsuarios = new GestionUsuarios();
        gestionFacturas = new GestionFactura();
        gestionCita = new GestionCita();
        gestionConsulta = new GestionConsulta();
        gestionConsultorio = new GestionConsultorio();
        gestionPacientes = new GestionPacientes();
        gestionAgendaMedica = new GestionAgendaMedica();
        gestionResumenClinico = new GestionResumenClinicos();
    }
    private Usuario[] Usuarios;
    private int nroUsuarios;

    
    public Sistema() {
        this.Usuarios = new Usuario[100];
        this.nroUsuarios = 0;
    }

    public GestionUsuarios getGestionEmpleados() {
        return gestionUsuarios;
    }

    public static GestionFactura getGestionFacturas() {
        return gestionFacturas;
    }

    public static GestionCita getGestionCita() {
        return gestionCita;
    }

    public static GestionConsulta getGestionConsulta() {
        return gestionConsulta;
    }

    public static GestionConsultorio getGestionConsultorio() {
        return gestionConsultorio;
    }

    public static GestionPacientes getGestionPacientes() {
        return gestionPacientes;
    }  
    
    public static GestionUsuarios getGestionUsuarios() {
        return gestionUsuarios;
    }
    
   
}
