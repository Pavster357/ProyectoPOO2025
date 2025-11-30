/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Controller.GestionOrdenes;
import Model.Administrador;
import Model.Cajero;
import Model.Empleado;
import Model.Enfermero;
import Model.Medico;
import Model.Recepcionista;
import Model.Secundarios.Cita;
import Model.Secundarios.Consulta;
import Model.Secundarios.Consultorio;
import Model.Secundarios.Factura;
import Model.Secundarios.Orden;
import Model.Secundarios.Paciente;
import Model.Secundarios.Receta;
import Model.Usuario;

/**
 *
 * @author Alvaro
 */
public class Start extends javax.swing.JFrame {

    public static void main(String[] args) {
        

        // Inicializar todo el sistema ANTES del login
        Sistema.InicializarVariables();
        CargarUsuariosPorDefecto(); // ← Aquí cargas lo que antes estaba en Start()

        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
    }

    private static void CargarUsuariosPorDefecto() {
        Empleado a1 = new Administrador("Alvaro Leonardo", "Paiva Yaya", "apaivay@gmail.com", "72508549", "950209689");
        Usuario u1 = new Usuario("ADM-001", "1809", "Administrador", a1);
        Sistema.gestionUsuarios.AgregarUsuario(u1);

        Empleado e1 = new Enfermero("Alonso Lorenzo", "Garcia Mantiya", "agracial@gmail.com", "15609035", "976543357");
        Usuario u2 = new Usuario("ENF-001", "1809", "Enfermero(a)", e1);
        Sistema.gestionUsuarios.AgregarUsuario(u2);

        Empleado r1 = new Recepcionista("Kiara Lorena", "Calderon Bayona", "kcalderonl@gmail.com", "72657896", "998632014");
        Usuario u3 = new Usuario("REC-001", "1809", "Recepcionista", r1);
        Sistema.gestionUsuarios.AgregarUsuario(u3);

        Empleado c1 = new Cajero("Alan Jonathan", "Ollanta Diaz", "aollantaj@gmail.com", "73695175", "969571021");
        Usuario u4 = new Usuario("CAJ-001", "1809", "Cajero", c1);
        Sistema.gestionUsuarios.AgregarUsuario(u4);

        Empleado m1 = new Medico("Angel Rodrigo", "Menendez Arriola", "amenendezm@gmail.com", "15376066", "975284369", "Pediatra");
        Usuario u5 = new Usuario("MED-001", "1809", "Medico", m1);
        Sistema.gestionUsuarios.AgregarUsuario(u5);
        
        GestionOrdenes go = Sistema.getGestionOrdenes();

        Orden nueva = new Orden("A001", "Laboratorio", "Hemograma");
        go.agregarOrden(nueva);
        Medico medicoTest = new Medico("Juan", "Perez", "juan@doc.com", "11111111", "999999", "Cardiologia");
        Usuario userMedico = new Usuario("DOC01", "123", "Medico", medicoTest);
        Sistema.getGestionUsuarios().AgregarUsuario(userMedico);

        // --- B. Crear Paciente ---
        Paciente pacienteTest = new Paciente("22222222", "Maria", "Lopez", "01/01/1990", "F", "555-1234", "Nadie");
        Sistema.getGestionPacientes().AgregarPaciente(pacienteTest);

        // --- C. Crear Consultorio (Para Reporte de Ocupación) ---
        // Fecha de prueba: 29/11/2025
        Consultorio cons = new Consultorio("C-101", "Cardiologia", "Ocupado", medicoTest, "29/11/2025");
        
        // Crear Cita y vincularla
        Cita cita = new Cita("29/11/2025", "10:00", "Presencial", pacienteTest, medicoTest, cons);
        cita.setEstado("Atendida");
        
        // Asignar cita al consultorio manualmente (simulando lógica interna)
        cons.setCantidadCitas(1);
        cons.getCitas()[0] = cita;
        
        // Guardar en el sistema
        Sistema.getGestionConsultorio().AgregarConsultorio(cons);
        Sistema.getGestionCita().AgregarCita(cita);

        // --- D. Crear Consulta (Para Reporte de Producción) ---
        Consulta consulta = new Consulta("CON-001", cita, "Dolor", "Estable", "Normal", "Gripe", "Reposo", new Receta(), new Orden[5]);
        // Añadir una orden a la consulta para que tenga precio extra
        Orden ordenSangre = new Orden("ORD-1", "Lab", "Sangre");
        ordenSangre.setPrecio(100.0);
        ordenSangre.setEstado("Finalizado");
        consulta.getOrdenes()[0] = ordenSangre;
        
        Sistema.getGestionConsulta().agregarConsulta(consulta); // Método puede ser con mayúscula o minúscula según tu controller

        // --- E. Crear Factura (Para Reporte de Ingresos) ---
        Factura factura = new Factura("FAC-001", pacienteTest, consulta, "Efectivo");
        factura.pagar(); // Importante: Debe estar pagada para sumar ingresos
        
        Sistema.getGestionFacturas().agregarFactura(factura);
    }

    // Método auxiliar para filtrar solo los médicos de todos los usuarios
    private static Medico[] obtenerMedicosDelSistema() {
        int totalUsuarios = Sistema.getGestionUsuarios().getNroUsuarios();
        Usuario[] todosLosUsuarios = Sistema.getGestionUsuarios().getUsuarios();
        
        // Contar cuántos médicos hay
        int countMedicos = 0;
        for (int i = 0; i < totalUsuarios; i++) {
            if (todosLosUsuarios[i] != null && todosLosUsuarios[i].getEmpleado() instanceof Medico) {
                countMedicos++;
            }
        }

        // Crear array exacto
        Medico[] medicos = new Medico[countMedicos];
        int index = 0;
        for (int i = 0; i < totalUsuarios; i++) {
            if (todosLosUsuarios[i] != null && todosLosUsuarios[i].getEmpleado() instanceof Medico) {
                medicos[index++] = (Medico) todosLosUsuarios[i].getEmpleado();
            }
        }
        return medicos;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
