package pooprojecto;

import Model.Medico;
import Model.Usuario;
import Model.Empleado;
import Model.Secundarios.Cita;
import Model.Secundarios.Consulta;
import Model.Secundarios.Consultorio;
import Model.Secundarios.Factura;
import Model.Secundarios.Orden;
import Model.Secundarios.Paciente;
import Model.Secundarios.Receta;

/**
 * Clase de Prueba para ReportesGUI usando la arquitectura Sistema.
 */
public class TestReportesGUI {

    public static void main(String[] args) {
        System.out.println("Iniciando carga de datos en Sistema...");

        // 1. Inicializar las variables estáticas del Sistema
        Sistema.InicializarVariables();

        // 2. Cargar Datos de Prueba en el Sistema (Simulando lo que haría el programa real)
        cargarDatosPrueba();

        // 3. Preparar la lista de médicos para el ComboBox
        // (Extraemos los médicos del GestionUsuarios del Sistema)
        Medico[] listaMedicos = obtenerMedicosDelSistema();

        // 4. Lanzar la ventana de Reportes usando los Gestores del Sistema
        java.awt.EventQueue.invokeLater(() -> {
            ReportesGUI frame = new ReportesGUI(
                Sistema.getGestionConsulta(),
                Sistema.getGestionConsultorio(),
                Sistema.getGestionFacturas(),
                listaMedicos
            );
            frame.setVisible(true);
            System.out.println("Ventana de Reportes visible.");
        });
    }

    private static void cargarDatosPrueba() {
        // --- A. Crear Médico y Usuario ---
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
}