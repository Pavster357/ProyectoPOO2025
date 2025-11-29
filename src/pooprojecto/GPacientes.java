/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Secundarios.Paciente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alvaro
 */
public class GPacientes extends javax.swing.JFrame {

    public GPacientes() {
        initComponents();
        actualizarTabla();
    }
    
    public void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
        modelo.setRowCount(0);

        Paciente[] lista = Sistema.gestionPacientes.getPacientes();
        int n = Sistema.gestionPacientes.getCount();

        for(int i = 0; i < n; i++){
            Paciente p = lista[i];
            modelo.addRow(new Object[]{
                p.getDni(),
                p.getNombres(),
                p.getApellidos(),
                p.getSexo(),
                p.getTelefono(),
                p.getContactoEmergancia(),
                p
            });
        }
        if (TablaP.getColumnModel().getColumnCount() > 6) {
            TableColumn col = TablaP.getColumnModel().getColumn(6);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 515));
        jPanel1.setLayout(null);

        TablaP.setForeground(new java.awt.Color(0, 102, 153));
        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Sexo", "Telefono", "Contacto Emerg.", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(TablaP);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 86, 695, 350);

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
        Agregar.setBounds(80, 450, 100, 30);

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
        Eliminar.setBounds(240, 450, 100, 30);

        Modificar.setForeground(new java.awt.Color(0, 102, 153));
        Modificar.setText("Modificar");
        Modificar.setPreferredSize(new java.awt.Dimension(100, 30));
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(Modificar);
        Modificar.setBounds(400, 450, 100, 30);

        Volver.setForeground(new java.awt.Color(0, 102, 153));
        Volver.setText("Volver");
        Volver.setPreferredSize(new java.awt.Dimension(100, 30));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver);
        Volver.setBounds(550, 450, 100, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pacientes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 20, 170, 48);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        RegistrarP r = new RegistrarP(this, null);
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = TablaP.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Seleccione un paciente");
            return;
        }
        Paciente paciente = (Paciente)TablaP.getValueAt(fila, 6);
        boolean eliminado = Sistema.gestionPacientes.EliminarPaciente(paciente);
        if(eliminado){
            actualizarTabla();
            int total = Sistema.gestionPacientes.getCount();
                JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.\nPacientes restantes en el sistema: " + total);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el paciente. Verifique los datos.");
        }
    }//GEN-LAST:event_EliminarActionPerformed
    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int fila = TablaP.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Seleccione un paciente");
            return;
        }       
        Paciente paciente = (Paciente) TablaP.getValueAt(fila, 6);
        
        RegistrarP r = new RegistrarP(this,paciente);
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
        return;
    }//GEN-LAST:event_ModificarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JTable TablaP;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
