/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Medico;
import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;
import Model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alvaro
 */
public class AgendaMedica extends javax.swing.JFrame {

    private Usuario usuarioLogueado;
    private Medico medicoLogueado;  

    public AgendaMedica(Usuario usuarioLogueado) {
        initComponents();
        this.usuarioLogueado = usuarioLogueado;
        this.medicoLogueado = (Medico) usuarioLogueado.getEmpleado();
        actualizarTablaCitas();
        actualizarTablaCitas2();
    }

    public void actualizarTablaCitas() {
        DefaultTableModel modelo = (DefaultTableModel) TCitas.getModel();
        modelo.setRowCount(0);

        Cita[] citas = Sistema.gestionCita.getCitas();
        int count = Sistema.gestionCita.getCount();

        for (int i = 0; i < count; i++) {
            Cita c = citas[i];
            if (c != null && c.getMedico().getDNI().equals(medicoLogueado.getDNI()) && c.getEstado().equals("Programada")) {
                modelo.addRow(new Object[]{
                    c.getPaciente().getNombres(),
                    c.getPaciente().getDni(),
                    c.getHora(),
                    c
                });
            }
            if (TCitas.getColumnModel().getColumnCount() > 3) {
                TableColumn col = TCitas.getColumnModel().getColumn(3);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setPreferredWidth(0);
                col.setWidth(0);
                col.setResizable(false);
            }
        }
    }
    
     public void actualizarTablaCitas2() {
        DefaultTableModel modelo = (DefaultTableModel) TCitas2.getModel();
        modelo.setRowCount(0);

        Cita[] citas = Sistema.getGestionCita().getCitas();
        int count = Sistema.getGestionCita().getCount();

        for (int i = 0; i < count; i++) {
            Cita c = citas[i];

            if (c != null && c.getMedico().getDNI().equals(medicoLogueado.getDNI()) && c.getEstado().equals("En sala")) {

                modelo.addRow(new Object[]{
                    c.getPaciente().getNombres(),
                    c.getPaciente().getDni(),
                    c.getHora(),
                    c
                });
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TCitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TCitas2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btVolver = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 550));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 515));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 515));

        TCitas.setForeground(new java.awt.Color(0, 102, 153));
        TCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Paciente", "DNI", "Hora", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TCitas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Citas Programadas");

        btCancelar.setForeground(new java.awt.Color(0, 102, 153));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btConfirmar.setForeground(new java.awt.Color(0, 102, 153));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btConfirmar)
                        .addGap(54, 54, 54)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 515);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 515));

        TCitas2.setForeground(new java.awt.Color(0, 102, 153));
        TCitas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Paciente", "DNI", "Hora", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TCitas2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Citas Confirmadas");

        btVolver.setForeground(new java.awt.Color(0, 102, 153));
        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        btConsulta.setForeground(new java.awt.Color(0, 102, 153));
        btConsulta.setText("Consulta");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVolver)
                    .addComponent(btConsulta))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 515);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVolverActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        int fila = TCitas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }
        Cita citaC = (Cita) TCitas.getValueAt(fila, 3);
        Cita seleccionada = Sistema.gestionCita.buscarCitaPorDniYHora(citaC);
        if (seleccionada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la cita seleccionada");
            return;
        }
        seleccionada.setEstado("Confirmada");
        Sistema.gestionAgendaMedica.actualizarCita(seleccionada);
        Sistema.gestionCita.ActualizarCita(citaC, seleccionada);
        Consultorio cons = seleccionada.getConsultorio();
        if (cons != null) {
            Sistema.gestionCita.ActualizarCitaConsultorio(cons, seleccionada);
        }
        JOptionPane.showMessageDialog(this, "Cita confirmada correctamente");
        actualizarTablaCitas();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        GConsulta GConsulta = new GConsulta(usuarioLogueado);
        GConsulta.setVisible(true);
        GConsulta.pack();
        GConsulta.setLocationRelativeTo(null);
    }//GEN-LAST:event_btConsultaActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int fila = TCitas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }
        Cita citaC = (Cita) TCitas.getValueAt(fila, 3);
        Cita seleccionada = Sistema.gestionCita.buscarCitaPorDniYHora(citaC);
        if (seleccionada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la cita seleccionada");
            return;
        }
        seleccionada.setEstado("Cancelar");
        Sistema.gestionAgendaMedica.actualizarCita(seleccionada);
        Sistema.gestionCita.ActualizarCita(citaC, seleccionada);
        Consultorio cons = seleccionada.getConsultorio();
        if (cons != null) {
            Sistema.gestionCita.ActualizarCitaConsultorio(cons, seleccionada);
        }
        JOptionPane.showMessageDialog(this, "Cita confirmada correctamente");
        actualizarTablaCitas();
    }//GEN-LAST:event_btCancelarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TCitas;
    private javax.swing.JTable TCitas2;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
