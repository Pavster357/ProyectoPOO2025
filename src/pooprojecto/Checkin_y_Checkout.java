/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Checkin_y_Checkout extends javax.swing.JFrame {

    /**
     * Creates new form Checkin_y_Checkout
     */
    public Checkin_y_Checkout() {
        initComponents();
        cargarElementos1();
        cargarElementos2();
    }

    private void cargarElementos1(){
        DefaultTableModel modelo = (DefaultTableModel) TCitaA.getModel();
        modelo.setRowCount(0);

        Cita[] citas = Sistema.gestionCita.getCitas();
        int count = Sistema.gestionCita.getCount();

        for (int i = 0; i < count; i++) {
            Cita c = citas[i];
            if (c != null && c.getEstado().equals("Confirmada")) {
                modelo.addRow(new Object[]{
                    c.getPaciente().getNombres(),
                    c.getPaciente().getDni(),
                    c.getHora(),
                    c
                });
            }
            if (TCitaA.getColumnModel().getColumnCount() > 3) {
                TableColumn col = TCitaA.getColumnModel().getColumn(3);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setPreferredWidth(0);
                col.setWidth(0);
                col.setResizable(false);
            }
        }
    }
    
    private void cargarElementos2(){
        DefaultTableModel modelo = (DefaultTableModel) TCitaAt.getModel();
        modelo.setRowCount(0);

        Cita[] citas = Sistema.gestionCita.getCitas();
        int count = Sistema.gestionCita.getCount();

        for (int i = 0; i < count; i++) {
            Cita c = citas[i];
            if (c != null && c.getEstado().equals("Atendida")) {
                modelo.addRow(new Object[]{
                    c.getPaciente().getNombres(),
                    c.getPaciente().getDni(),
                    c.getHora(),
                    c
                });
            }
            if (TCitaAt.getColumnModel().getColumnCount() > 3) {
                TableColumn col = TCitaAt.getColumnModel().getColumn(3);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setPreferredWidth(0);
                col.setWidth(0);
                col.setResizable(false);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btCheck_in = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TCitaA = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btCheck_out = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TCitaAt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(815, 440));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Admision");

        btCheck_in.setForeground(new java.awt.Color(0, 102, 153));
        btCheck_in.setText("Check - in");
        btCheck_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheck_inActionPerformed(evt);
            }
        });

        TCitaA.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TCitaA);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btCheck_in, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(btCheck_in, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 400));

        btCheck_out.setForeground(new java.awt.Color(0, 102, 153));
        btCheck_out.setText("Check-out");
        btCheck_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheck_outActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alta");

        btVolver.setForeground(new java.awt.Color(0, 102, 153));
        btVolver.setText("Volver");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        TCitaAt.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TCitaAt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btCheck_out, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(158, 158, 158))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCheck_out, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 400);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCheck_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheck_inActionPerformed
        int fila = TCitaAt.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione una cita");
            return;
        }
        Cita cita = (Cita) TCitaAt.getValueAt(fila, 3);
        cita.setEstado("En sala");
        Sistema.gestionAgendaMedica.actualizarCita(cita);
        Sistema.gestionCita.ActualizarCita(cita, cita);
        Consultorio cons = cita.getConsultorio();
        if (cons != null) {
            Sistema.gestionCita.ActualizarCitaConsultorio(cons, cita);
        }
        JOptionPane.showMessageDialog(this, "Cita enviada a sala correctamente");
        cargarElementos1();
    }//GEN-LAST:event_btCheck_inActionPerformed

    private void btCheck_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheck_outActionPerformed
        int fila = TCitaAt.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione una cita");
            return;
        }
        Cita cita = (Cita) TCitaAt.getValueAt(fila, 3);
        Sistema.gestionCita.AgregarCitaSalida(cita);
        Sistema.gestionCita.EliminarCita(cita);
        Sistema.gestionAgendaMedica.eliminarCita(cita);
        Consultorio cons = cita.getConsultorio();
        if (cons != null) {
            Sistema.gestionCita.ActualizarCitaConsultorio(cons, cita);
        }
        int total = Sistema.gestionCita.getCount();
        JOptionPane.showMessageDialog(this,"Paciente deado de alta correctamente." +"\nCitas restantes en el sistema: " + total);
        String resumen = Sistema.gestionResumenClinico.buscarResumen(cita.toString());
        System.out.println(resumen);
    }//GEN-LAST:event_btCheck_outActionPerformed

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVolverActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TCitaA;
    private javax.swing.JTable TCitaAt;
    private javax.swing.JButton btCheck_in;
    private javax.swing.JButton btCheck_out;
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
