/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Medico;
import Model.Secundarios.Cita;
import Model.Secundarios.Consulta;
import Model.Secundarios.Orden;
import Model.Secundarios.Receta;
import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro
 */
public class RegistrarCons extends javax.swing.JFrame {

    private Consulta consultaEditado;
    private GConsulta padre;
    private Usuario usuarioLogueado;
    private Medico medicoLogueado;  
    private Receta recetaActual;
    private Orden[] ordenesActuales;
    private int countOrdenes;
    
    public RegistrarCons(GConsulta padre, Consulta consultaEditado, Usuario usuarioLogueado) {
        initComponents();
        this.usuarioLogueado = usuarioLogueado;
        this.medicoLogueado = (Medico) usuarioLogueado.getEmpleado();
        this.recetaActual = new Receta();
        this.ordenesActuales = new Orden[20];
        this.countOrdenes = 0;
        cargarelementos();
    }
    
    private void cargarelementos(){
        Cita[] lista = Sistema.gestionCita.getCitas();
        for (int i = 0; i < Sistema.gestionCita.getCount(); i++) {
            Cita c = lista[i];
            if (c != null && c.getMedico().equals(medicoLogueado) && c.getEstado().equals("En sala")) {
                cbCitaEnSala.addItem(c);
            }
        }
    }

    public void setRecetaActual(Receta recetaActual) {
        this.recetaActual = recetaActual;
    }

    public Orden[] getOrdenesActuales() {
        return ordenesActuales;
    }

    public void setOrdenesActuales(Orden[] ordenesActuales) {
        this.ordenesActuales = ordenesActuales;
    }

    public int getCountOrdenes() {
        return countOrdenes;
    }

    public void setCountOrdenes(int countOrdenes) {
        this.countOrdenes = countOrdenes;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reCancelar = new javax.swing.JButton();
        reResgistrar = new javax.swing.JButton();
        cbFisico = new javax.swing.JComboBox<>();
        cbSignos = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        btReceta = new javax.swing.JButton();
        txtDiagnostico = new javax.swing.JTextField();
        txtPlan = new javax.swing.JTextField();
        btOrden = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbCitaEnSala = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("POLICLÍNICO");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 68)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Vida y Salud");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jLabel13)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(242, 242, 242))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(235, 235, 235)
                    .addComponent(jLabel13)
                    .addContainerGap(337, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 600);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Signos Vitales (Presion arterial):");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Examen fisico (Peso):");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Diagnostico:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Plan:");

        reCancelar.setForeground(new java.awt.Color(0, 102, 153));
        reCancelar.setText("Cancelar");
        reCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reCancelarActionPerformed(evt);
            }
        });

        reResgistrar.setForeground(new java.awt.Color(0, 102, 153));
        reResgistrar.setText("Resgistrar");
        reResgistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reResgistrarActionPerformed(evt);
            }
        });

        cbFisico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bajo", "Medio", "Alto", "Obesidad" }));
        cbFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFisicoActionPerformed(evt);
            }
        });

        cbSignos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hipotension < Menor - 80/60 mmHg >", "Normal < 80/60 mmHg - 120/80 mmHg >", "Elevada < 120/60 mmHg -  129/80 mmHg >", "Hipertension Nivel 1 < 130/80 mmHg - 139/89 mmHg>", "Hipertension Nivel 2 < 140/90 mmHg -  Mayor>", " ", " " }));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Motivo:");

        btReceta.setForeground(new java.awt.Color(0, 102, 153));
        btReceta.setText("Receta");
        btReceta.setPreferredSize(new java.awt.Dimension(100, 30));
        btReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecetaActionPerformed(evt);
            }
        });

        btOrden.setForeground(new java.awt.Color(0, 102, 153));
        btOrden.setText("Orden");
        btOrden.setPreferredSize(new java.awt.Dimension(100, 30));
        btOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrdenActionPerformed(evt);
            }
        });

        jLabel9.setText("Cita:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(85, 85, 85))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFisico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSignos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo)
                    .addComponent(txtMotivo)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiagnostico)
                    .addComponent(txtPlan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btReceta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reResgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCitaEnSala, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCitaEnSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSignos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reResgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_reCancelarActionPerformed

    private void reResgistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reResgistrarActionPerformed
        String codigo = txtCodigo.getText();
        Cita cita = (Cita) cbCitaEnSala.getSelectedItem();
        String motivo = txtMotivo.getText();
        String sigVit = cbSignos.getSelectedItem().toString();
        String exaFis = cbFisico.getSelectedItem().toString();
        String diag = txtDiagnostico.getText();
        String plan = txtPlan.getText();
        
        Consulta nueva = new Consulta(codigo, cita, motivo, sigVit, exaFis, diag, plan, recetaActual, ordenesActuales);        
        boolean ok = Sistema.gestionAgendaMedica.agregarConsulta(nueva);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Consulta registrada.");
            padre.actualizarTabla();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar.");
        }
    }//GEN-LAST:event_reResgistrarActionPerformed

    private void cbFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFisicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFisicoActionPerformed

    private void btRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecetaActionPerformed
        RegistrarR RegistrarR = new RegistrarR(this,recetaActual);
        RegistrarR.setVisible(true);
        RegistrarR.pack();
        RegistrarR.setLocationRelativeTo(null);
    }//GEN-LAST:event_btRecetaActionPerformed

    private void btOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrdenActionPerformed
        RegistrarO RegistrarO = new RegistrarO(this, ordenesActuales);
        RegistrarO.setVisible(true);
        RegistrarO.pack();
        RegistrarO.setLocationRelativeTo(null);
    }//GEN-LAST:event_btOrdenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOrden;
    private javax.swing.JButton btReceta;
    private javax.swing.JComboBox<Cita> cbCitaEnSala;
    private javax.swing.JComboBox<String> cbFisico;
    private javax.swing.JComboBox<String> cbSignos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton reCancelar;
    private javax.swing.JButton reResgistrar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtPlan;
    // End of variables declaration//GEN-END:variables
}
