/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooprojecto;
import Controller.GestionOrdenes;
import Model.Secundarios.Orden;
import javax.swing.JOptionPane;

/**

 * @author leonardorodriguez
 */
public class G_EjecucionOrdenes extends javax.swing.JFrame {

    private GestionOrdenes gestionOrdenes;
    private Orden ordenActual; 

    public G_EjecucionOrdenes() {
       
        initComponents();
        
       
        this.gestionOrdenes = Sistema.getGestionOrdenes(); 
        setLocationRelativeTo(null);
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        lblNombreExamen.setText("-");
        lblTipo.setText("-");
        lblEstado.setText("-");
        txtResultado.setText("");
        
    
        txtResultado.setEnabled(false);
        btnTomarMuestra.setEnabled(false);
        btnGuardarResultado.setEnabled(false);
        
        ordenActual = null;
    }



    private void buscarOrden() {
        String codigo = txtBuscarCodigo.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código de orden.");
            return;
        }

        ordenActual = gestionOrdenes.buscarOrdenPorCodigo(codigo);

        if (ordenActual != null) {
            // Mostrar datos
            lblNombreExamen.setText(ordenActual.getNombre());
            lblTipo.setText(ordenActual.getTipo());
            
            String estado = ordenActual.getEstado();
            lblEstado.setText(estado);
            
            // Cargar resultado previo si existe
            if (ordenActual.getResultado() != null) {
                txtResultado.setText(ordenActual.getResultado());
            } else {
                txtResultado.setText("");
            }

            // Habilitar botones según estado
            actualizarBotones(estado);
            
        } else {
            JOptionPane.showMessageDialog(this, "Orden no encontrada.");
            limpiarFormulario();
        }
    }

    private void actualizarBotones(String estado) {
        if (estado.equals("Pendiente")) {
            btnTomarMuestra.setEnabled(true);
            btnGuardarResultado.setEnabled(false);
            txtResultado.setEnabled(false);
        } else if (estado.equals("En Proceso")) {
            btnTomarMuestra.setEnabled(false);
            btnGuardarResultado.setEnabled(true);
            txtResultado.setEnabled(true);
        } else { // Finalizado
            btnTomarMuestra.setEnabled(false);
            btnGuardarResultado.setEnabled(false);
            txtResultado.setEnabled(false);
        }
    }

    private void accionTomarMuestra() {
        if (ordenActual != null) {
            boolean exito = gestionOrdenes.registrarTomaDeMuestra(ordenActual.getCodigo());
            if (exito) {
                JOptionPane.showMessageDialog(this, "Muestra registrada. Estado: En Proceso.");
                buscarOrden(); // Refrescar pantalla
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo cambiar el estado.");
            }
        }
    }

    private void accionGuardarResultado() {
        if (ordenActual != null) {
            String resultado = txtResultado.getText();
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe escribir un resultado.");
                return;
            }
            
            boolean exito = gestionOrdenes.cargarResultado(ordenActual.getCodigo(), resultado);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Resultado guardado. Orden FINALIZADA.");
                buscarOrden(); // Refrescar pantalla
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar resultado.");
            }
        }
    }



    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        buscarOrden();
    }                                       

    private void btnTomarMuestraActionPerformed(java.awt.event.ActionEvent evt) {                                                
        accionTomarMuestra();
    }                                               

    private void btnGuardarResultadoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        accionGuardarResultado();
    }                                                   

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }     

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreExamen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnTomarMuestra = new javax.swing.JButton();
        btnGuardarResultado = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laboratorio e Imágenes - Ejecución");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel1.setText("Ingrese Código de Orden:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de la Orden"));

        jLabel2.setText("Examen:");
        lblNombreExamen.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        lblNombreExamen.setText("---");

        jLabel4.setText("Tipo:");
        lblTipo.setText("---");

        jLabel6.setText("Estado:");
        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        lblEstado.setForeground(new java.awt.Color(0, 102, 204));
        lblEstado.setText("---");

        jLabel8.setText("Resultados / Informe Técnico:");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        btnTomarMuestra.setBackground(new java.awt.Color(255, 255, 204));
        btnTomarMuestra.setText("1. Registrar Toma de Muestra");
        btnTomarMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarMuestraActionPerformed(evt);
            }
        });

        btnGuardarResultado.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarResultado.setText("2. Guardar Resultado");
        btnGuardarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTomarMuestra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btnGuardarResultado)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombreExamen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTipo)
                    .addComponent(jLabel6)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTomarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

  
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }                        


    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardarResultado;
    private javax.swing.JButton btnTomarMuestra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreExamen;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextArea txtResultado;
                   
}
