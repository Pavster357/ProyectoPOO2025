/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooprojecto;

import Controller.GestionConsulta;
import Controller.GestionConsultorio;
import Controller.GestionFactura;
import Model.Medico;
import Model.Secundarios.Reportes;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Módulo de Reportes - Versión Manual (Sin bloqueo de NetBeans)
 * @author leonardorodriguez
 */
public class ReportesGUI extends JFrame {

    // Lógica
    private GestionConsulta gestionConsulta;
    private GestionConsultorio gestionConsultorio;
    private GestionFactura gestionFactura;
    private Reportes reportes;

    // Componentes Visuales
    private JPanel jPanel1;
    private JButton btnOcupacion;
    private JButton btnProduccion;
    private JButton btnIngresos;
    private JComboBox<Medico> cbMedicos;
    private JLabel fechaLabel;
    private JLabel lblMedico;
    private JLabel lblInicio;
    private JLabel lblFin;
    private JTextField txtFechaOcupacion;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JTextArea txtResultado;
    private JScrollPane jScrollPane1;

    // Constructor
    public ReportesGUI(GestionConsulta gc, 
                       GestionConsultorio gco, 
                       GestionFactura gf, 
                       Medico[] medicos) {
        
       
        super("Reportes del Sistema");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null); // Centrar
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
        this.gestionConsulta = gc;
        this.gestionConsultorio = gco;
        this.gestionFactura = gf;
        this.reportes = new Reportes(gc, gco, gf);

      
        iniciarComponentes();
        
     
        actualizarListaMedicos(medicos);
    }

    private void iniciarComponentes() {
   
        jPanel1 = new JPanel();
        jPanel1.setBackground(new java.awt.Color(0, 102, 204)); 
        jPanel1.setLayout(null); 
        fechaLabel = new JLabel("Fecha Ocupación (dd/mm/aaaa):");
        fechaLabel.setForeground(java.awt.Color.WHITE);
        fechaLabel.setBounds(30, 30, 220, 25);
        jPanel1.add(fechaLabel);

        txtFechaOcupacion = new JTextField();
        txtFechaOcupacion.setBounds(250, 30, 120, 25);
        jPanel1.add(txtFechaOcupacion);

        btnOcupacion = new JButton("Ver Ocupación");
        btnOcupacion.setBounds(390, 30, 160, 25);
        btnOcupacion.addActionListener(evt -> generarOcupacion());
        jPanel1.add(btnOcupacion);

    
        lblMedico = new JLabel("Seleccionar Médico:");
        lblMedico.setForeground(java.awt.Color.WHITE);
        lblMedico.setBounds(30, 80, 220, 25);
        jPanel1.add(lblMedico);

        cbMedicos = new JComboBox<>();
        cbMedicos.setBounds(250, 80, 200, 25); // Combo más ancho para nombres largos
        jPanel1.add(cbMedicos);

        btnProduccion = new JButton("Reporte Médico");
        btnProduccion.setBounds(470, 80, 160, 25);
        btnProduccion.addActionListener(evt -> generarProduccion());
        jPanel1.add(btnProduccion);

    
        lblInicio = new JLabel("Inicio:");
        lblInicio.setForeground(java.awt.Color.WHITE);
        lblInicio.setBounds(30, 130, 50, 25);
        jPanel1.add(lblInicio);

        txtFechaInicio = new JTextField();
        txtFechaInicio.setBounds(80, 130, 100, 25);
        jPanel1.add(txtFechaInicio);

        lblFin = new JLabel("Fin:");
        lblFin.setForeground(java.awt.Color.WHITE);
        lblFin.setBounds(200, 130, 30, 25);
        jPanel1.add(lblFin);

        txtFechaFin = new JTextField();
        txtFechaFin.setBounds(230, 130, 100, 25);
        jPanel1.add(txtFechaFin);

        btnIngresos = new JButton("Calcular Ingresos");
        btnIngresos.setBounds(350, 130, 160, 25);
        btnIngresos.addActionListener(evt -> generarIngresos());
        jPanel1.add(btnIngresos);

       
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        // Usamos una fuente monoespaciada para que los reportes se vean alineados
        txtResultado.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12)); 
        jScrollPane1 = new JScrollPane(txtResultado);
        // Área más grande y centrada
        jScrollPane1.setBounds(30, 180, 600, 300);
        jPanel1.add(jScrollPane1);

      
        this.add(jPanel1);
        this.setSize(680, 550); 
    }

   

    private void generarOcupacion() {
        String fecha = txtFechaOcupacion.getText().trim();
        if (fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha.");
            return;
        }
        String r = reportes.ocupacionConsultorios(fecha);
        txtResultado.setText(r);
    }

    private void generarProduccion() {
        Medico medico = (Medico) cbMedicos.getSelectedItem();
        if (medico == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un médico.");
            return;
        }
        String r = reportes.produccionPorMedico(medico);
        txtResultado.setText(r);
    }

    private void generarIngresos() {
        String inicio = txtFechaInicio.getText().trim();
        String fin = txtFechaFin.getText().trim();
        if (inicio.isEmpty() || fin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese ambas fechas.");
            return;
        }
        String r = reportes.ingresosPorRango(inicio, fin);
        txtResultado.setText(r);
    }

    public void actualizarListaMedicos(Medico[] medicos) {
        cbMedicos.removeAllItems();
        if (medicos != null) {
            for (Medico m : medicos) {
                if (m != null) {
                    cbMedicos.addItem(m);
                }
            }
        }
    }
}
