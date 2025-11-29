/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pooprojecto;

import Model.Medico;
import Model.Secundarios.Cita;
import Model.Secundarios.Consultorio;
import Model.Secundarios.Paciente;
import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro
 */
public class RegistrarCi extends javax.swing.JFrame {

    private Cita citaEditada;
    private GCitas padre;
    
    public RegistrarCi(GCitas padre, Cita cita) {
        initComponents();
        cargarElementos();
        this.padre = padre;
        citaEditada = cita;
        
        if(citaEditada != null){
            cbDia.setSelectedItem(cita.getDia()); 
            cbHora.setSelectedItem(cita.getHora());
            cbMedico.setSelectedItem(cita.getMedico());
            cbConsultorio.setSelectedItem(cita.getConsultorio());
            cbModalidad.setSelectedItem(cita.getModalidad());
            cbPaciente.setSelectedItem(cita.getPaciente());           
        }
    }

    private void cargarElementos() {
        cbConsultorio.addItem(null);
        Usuario[] lista = Sistema.gestionUsuarios.getUsuarios();
        for (int i = 0; i < Sistema.gestionUsuarios.getNroUsuarios(); i++) {
            Usuario u = lista[i];
            if (u != null && u.getEmpleado() instanceof Medico) {
                Medico m = (Medico) u.getEmpleado();
                cbMedico.addItem(m);
            }
        }
        
        Consultorio[] lista2 = Sistema.gestionConsultorio.getConsultorios();
        for (int i = 0; i < Sistema.gestionConsultorio.getCount(); i++) {
            Consultorio c = lista2[i];
            if (c != null && c.getEstado().equals("Ocupado")) {
                cbConsultorio.addItem(c);
            }
        }
        
        Paciente[] lista3 = Sistema.gestionPacientes.getPacientes();
        for (int i = 0; i < Sistema.gestionPacientes.getCount(); i++) {
            Paciente p = lista3[i];
            if (p != null) {
                cbPaciente.addItem(p);
            }
        }
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
        reCancelar = new javax.swing.JButton();
        reResgistrar = new javax.swing.JButton();
        cbMedico = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbModalidad = new javax.swing.JComboBox<>();
        cbConsultorio = new javax.swing.JComboBox<>();
        cbPaciente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(930, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 600));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jLabel13)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(240, 240, 240))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(235, 235, 235)
                    .addComponent(jLabel13)
                    .addContainerGap(337, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 600);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(530, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cita");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paciente:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Consultorio:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dia:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Medico:");

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

        cbMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedicoActionPerformed(evt);
            }
        });

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" }));
        cbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora:");

        cbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00 - 8:30", "8:30 - 9:00", "9:00 - 9:30", "9:30 - 10:00", "10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30", "11:30 - 12:00", "12:00 - 12:30", "12:30 - 13:00", "13:00 - 13:30", "13:30 - 14:00", "15:00 - 15:30", "15:30 - 16:00", "16:00 - 16:30", "16:30 - 17:00", "17:00 - 17:30", "17:30 - 18:00" }));
        cbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modalidad:");

        cbModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presencial", "Telemedicina", " " }));
        cbModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModalidadActionPerformed(evt);
            }
        });

        cbConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConsultorioActionPerformed(evt);
            }
        });

        cbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbModalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbConsultorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(reResgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(reCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(220, 220, 220))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reResgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 530, 600);

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

    private void reCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_reCancelarActionPerformed

    private void reResgistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reResgistrarActionPerformed
        String dia = cbDia.getSelectedItem().toString();
        String hora = cbHora.getSelectedItem().toString();
        Medico medico = (Medico)cbMedico.getSelectedItem();
        String modalidad = cbModalidad.getSelectedItem().toString();
        Consultorio consultorio = (Consultorio) cbConsultorio.getSelectedItem();
        if (modalidad.equals("Telemedicina")) {
            consultorio = null;
        }
        Paciente paciente = (Paciente)cbPaciente.getSelectedItem();       
        Cita nueva = new Cita(dia, hora, modalidad, paciente, medico, consultorio);
        Cita[] lista = Sistema.gestionCita.getCitas();
        int total = Sistema.gestionCita.getCount();

        for (int i = 0; i < total; i++){
            Cita c = lista[i];
            if (c == null) continue;
            if (c.getHora().equals(hora)){
                if (c.getMedico().getDNI().equals(medico.getDNI())){
                    JOptionPane.showMessageDialog(this,"El médico ya tiene cita en esta hora");
                    return;
                }
                if (modalidad.equals("Presencial")){
                    if (c.getConsultorio() != null && consultorio != null && c.getConsultorio().getCodigo().equals(consultorio.getCodigo())) {
                        JOptionPane.showMessageDialog(this,"El consultorio ya tiene una cita en esta hora");
                        return;
                    }
                }
                if (c.getPaciente().getDni().equals(paciente.getDni())){
                    JOptionPane.showMessageDialog(this,"El paciente ya tiene una cita en esta hora");
                    return;
                }
                if (modalidad.equals("Presencial") && consultorio == null){
                    JOptionPane.showMessageDialog(this,"Debe seleccionar un consultorio para citas presenciales");
                    return;
                }
            }
        }

        if (citaEditada == null) {
            Sistema.gestionCita.AgregarCita(nueva);
            Sistema.gestionCita.AgregarCitaConsultorio(consultorio, nueva);
            Sistema.gestionAgendaMedica.agregarCita(nueva);
        } else {
            Sistema.gestionCita.ActualizarCita(citaEditada, nueva);
            Sistema.gestionCita.ActualizarCitaConsultorio(consultorio, nueva);
            Sistema.gestionAgendaMedica.actualizarCita(nueva);
        }
        JOptionPane.showMessageDialog(this, "Guardado correctamente."
                + "\nTotal citas: " + Sistema.gestionCita.getCount());
        if (padre != null) padre.actualizarTabla();

        this.dispose();
    }//GEN-LAST:event_reResgistrarActionPerformed

    private void cbMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedicoActionPerformed

    }//GEN-LAST:event_cbMedicoActionPerformed

    private void cbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaActionPerformed

    private void cbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHoraActionPerformed

    private void cbConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbConsultorioActionPerformed

    private void cbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPacienteActionPerformed

    private void cbModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModalidadActionPerformed
        if (cbModalidad.getSelectedItem().toString().equals("Telemedicina")){
            cbConsultorio.setEnabled(false); 
            cbConsultorio.setSelectedItem(null);
        } else {
            cbConsultorio.setEnabled(true);
        }
    }//GEN-LAST:event_cbModalidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Consultorio> cbConsultorio;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<Medico> cbMedico;
    private javax.swing.JComboBox<String> cbModalidad;
    private javax.swing.JComboBox<Paciente> cbPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton reCancelar;
    private javax.swing.JButton reResgistrar;
    // End of variables declaration//GEN-END:variables
}
