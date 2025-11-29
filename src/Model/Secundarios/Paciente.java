/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Secundarios;

/**
 *
 * @author Alvaro
 */
public class Paciente {
    private String dni, Nombres, Apellidos, fechaNacimiento, Sexo, telefono, contactoEmergancia;
    private Consulta[] consultas;
    private int count;
    private boolean antecedentes;

    public Paciente(String dni, String Nombres, String Apellidos, String fechaNacimiento, String Sexo, String telefono, String contactoEmergancia) {
        this.dni = dni;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.Sexo = Sexo;
        this.telefono = telefono;
        this.contactoEmergancia = contactoEmergancia;
        this.consultas = new Consulta[100];
        this.count = 0;
    }
    
    public boolean Antecedentes(){
        if(count > 0){
            this.antecedentes = true;
        }else{
            this.antecedentes = false;
        }
        return this.antecedentes;
    }
    
    @Override
    public String toString() {
    return getNombres() + " - " + getDni();
    }

    public Consulta[] getConsultas() {
        return consultas;
    }

    public int getCount() {
        return count;
    }

    public boolean isAntecedentes() {
        return antecedentes;
    }
     
    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContactoEmergancia() {
        return contactoEmergancia;
    }

}
