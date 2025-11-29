/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;
import Model.Secundarios.Paciente;
import Model.Medico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alvaro
 */
public class GCitas extends javax.swing.JFrame {

    public GCitas() {
        initComponents();
        actualizarTabla();
    }

    public void actualizarTabla() {

        DefaultTableModel model = (DefaultTableModel) TablaC.getModel();
        model.setRowCount(0);

        Cita[] lista = Sistema.gestionCita.getCitas();
        int total = Sistema.gestionCita.getCount();

        for (int i = 0; i < total; i++) {
            Cita c = lista[i];
            if (c != null) {
                model.addRow(new Object[]{
                    c.getDia(),
                    c.getHora(),
                    c.getMedico(),
                    c.getConsultorio(),
                    c.getModalidad(),
                    c.getPaciente(),
                    c.getEstado(),
                    c
                });
            }
        }
        if (TablaC.getColumnModel().getColumnCount() > 7) {
            TableColumn col = TablaC.getColumnModel().getColumn(7);
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
        TablaC = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 515));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CITAS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 20, 110, 48);

        TablaC.setForeground(new java.awt.Color(0, 102, 153));
        TablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Dia", "Hora", "Medico", "Consultorio", "Modalidad", "Paciente", "Estado", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(TablaC);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 79, 673, 350);

        Agregar.setForeground(new java.awt.Color(0, 102, 153));
        Agregar.setText("Agregar");
        Agregar.setMinimumSize(new java.awt.Dimension(100, 30));
        Agregar.setPreferredSize(new java.awt.Dimension(80, 30));
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(Agregar);
        Agregar.setBounds(88, 445, 100, 30);

        Eliminar.setForeground(new java.awt.Color(0, 102, 153));
        Eliminar.setText("Eliminar");
        Eliminar.setMinimumSize(new java.awt.Dimension(100, 30));
        Eliminar.setPreferredSize(new java.awt.Dimension(100, 30));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar);
        Eliminar.setBounds(246, 445, 100, 30);

        Modificar.setForeground(new java.awt.Color(0, 102, 153));
        Modificar.setText("Modificar");
        Modificar.setPreferredSize(new java.awt.Dimension(100, 30));
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(Modificar);
        Modificar.setBounds(397, 445, 100, 30);

        Volver.setForeground(new java.awt.Color(0, 102, 153));
        Volver.setText("Volver");
        Volver.setPreferredSize(new java.awt.Dimension(100, 30));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver);
        Volver.setBounds(548, 445, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        RegistrarCi r = new RegistrarCi(this, null);
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = TablaC.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }
        Cita cita = (Cita) TablaC.getValueAt(fila, 7);
        Consultorio consultorio = cita.getConsultorio();

        Cita[] lista = Sistema.gestionCita.getCitas();
        int n = Sistema.gestionCita.getCount();
        for (int i = 0; i < n; i++) {
            Cita c = lista[i];
            if (c == cita) {
                Sistema.gestionCita.EliminarCita(c);
                if(consultorio != null){
                    Sistema.gestionCita.EliminarCitaConsultorio(consultorio, c);
                }
                Sistema.gestionAgendaMedica.eliminarCita(cita);
                int total = Sistema.gestionCita.getCount();
                JOptionPane.showMessageDialog(this,"Cita eliminada correctamente." +"\nCitas restantes en el sistema: " + total);
                actualizarTabla();
                return;
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int fila = TablaC.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }

        Cita cita = (Cita) TablaC.getValueAt(fila, 7);

        RegistrarCi r = new RegistrarCi(this, cita);
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
        return;
    }//GEN-LAST:event_ModificarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JTable TablaC;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
