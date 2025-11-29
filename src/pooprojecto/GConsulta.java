/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Medico;
import Model.Secundarios.Consulta;
import Model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alvaro
 */
public class GConsulta extends javax.swing.JFrame {
    
    private Usuario usuarioLogueado;
    private Medico medicoLogueado; 
    
    public GConsulta(Usuario usuarioLogueado) {
        initComponents();
        this.usuarioLogueado = usuarioLogueado;
        this.medicoLogueado = (Medico) usuarioLogueado.getEmpleado();
        actualizarTabla();
    }

    public void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) TablaCons.getModel();
        model.setRowCount(0);

        Consulta[] lista = Sistema.gestionConsulta.getConsultas();
        int total = Sistema.gestionConsulta.getCount();

        for (int i = 0; i < total; i++) {
            Consulta c = lista[i];
            if (c != null && c.getCita().getMedico().getDNI().equals(medicoLogueado.getDNI()) && c.getEstado().equals("Abierta")) {
                model.addRow(new Object[]{
                    c.getCodigo(),
                    c.getCita(),
                    c.getOrdenes(),
                    c.getReceta().getCount(),
                    c.getEstado(),
                    c
                });
            }
        }
        if (TablaCons.getColumnModel().getColumnCount() > 5) {
            TableColumn col = TablaCons.getColumnModel().getColumn(5);
            col.setMinWidth(0);
            col.setMaxWidth(0);
            col.setPreferredWidth(0);
            col.setWidth(0);
            col.setResizable(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCons = new javax.swing.JTable();
        btAbrir = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();
        btVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 550));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 515));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta");
        jLabel1.setAlignmentX(100.0F);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(330, 20, 150, 48);

        TablaCons.setForeground(new java.awt.Color(0, 102, 153));
        TablaCons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cita", "Ordenes", "Medicamentos", "Estado", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(TablaCons);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 740, 360);

        btAbrir.setForeground(new java.awt.Color(0, 102, 153));
        btAbrir.setText("Abrir");
        btAbrir.setMinimumSize(new java.awt.Dimension(100, 30));
        btAbrir.setPreferredSize(new java.awt.Dimension(80, 30));
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btAbrir);
        btAbrir.setBounds(160, 450, 100, 30);

        btCerrar.setForeground(new java.awt.Color(0, 102, 153));
        btCerrar.setText("Cerrar");
        btCerrar.setMinimumSize(new java.awt.Dimension(100, 30));
        btCerrar.setPreferredSize(new java.awt.Dimension(100, 30));
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btCerrar);
        btCerrar.setBounds(340, 450, 100, 30);

        btVolver.setForeground(new java.awt.Color(0, 102, 153));
        btVolver.setText("Volver");
        btVolver.setPreferredSize(new java.awt.Dimension(100, 30));
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btVolver);
        btVolver.setBounds(530, 450, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        RegistrarCons r = new RegistrarCons(this, null, usuarioLogueado);
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAbrirActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        int fila = TablaCons.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una consulta");
            return;
        }
        Consulta consulta = (Consulta) TablaCons.getValueAt(fila, 5);
        Consulta seleccionada = Sistema.gestionConsulta.buscarCodigo(consulta.getCodigo());
        if (seleccionada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la consulta seleccionada");
            return;
        }
        seleccionada.setEstado("Cerrada");
        seleccionada.getCita().setEstado("Atendida");
        Sistema.gestionAgendaMedica.actualizarConsulta(seleccionada);
        Sistema.gestionConsulta.ActualizarConsulta(consulta, seleccionada);
        String resumen = "Resumen Clínico de la Consulta" +
                "\n-------------------------------------" +
                "\nCódigo de consulta: " + seleccionada.getCodigo() +
                "\nPaciente: " + seleccionada.getCita().getPaciente().getNombres() +
                "\nMotivo: " + seleccionada.getMotivo() +
                "\nSignos Vitales: " + seleccionada.getSignosVitales() +
                "\nExamen Físico: " + seleccionada.getExamenFisico() +
                "\nDiagnóstico: " + seleccionada.getDiagnostico() +
                "\nPlan: " + seleccionada.getPlan() +
                "\nDia: " + seleccionada.getCita().getDia() +
                "\nHora: " + seleccionada.getCita().getHora() +
                "\nEstado Cita: " + seleccionada.getCita().getEstado();
        
        Sistema.gestionResumenClinico.guardarResumen(consulta.getCodigo(), resumen);
        JOptionPane.showMessageDialog(this, "Consulta cerrada correctamente");
        actualizarTabla();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCons;
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
