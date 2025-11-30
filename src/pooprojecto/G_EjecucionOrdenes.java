package pooprojecto;

import Controller.GestionOrdenes;
import Model.Secundarios.Orden;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Ventana actualizada para Gestionar Órdenes con Archivos y Observaciones
 */
public class G_EjecucionOrdenes extends javax.swing.JFrame {

    private GestionOrdenes gestionOrdenes;
    private Orden ordenActual;
    
    // Variable auxiliar para guardar el archivo seleccionado temporalmente
    private File archivoSeleccionado; 

    public G_EjecucionOrdenes() {
        initComponents();
        // Inicializamos el sistema accediendo a la variable estática si es posible, 
        // o creando una instancia si tu arquitectura lo requiere.
        // Basado en tu código anterior:
        this.gestionOrdenes = new GestionOrdenes(); 
        this.archivoSeleccionado = null;
        limpiarFormulario(); // Iniciar limpio
    }

    private void limpiarFormulario() {
        lblNombreExamen.setText("-");
        lblTipo.setText("-");
        lblEstado.setText("-");
        
        txtObservaciones.setText("");
        txtResultado.setText("");
        lblNombreArchivo.setText(""); 
        archivoSeleccionado = null;

        // Deshabilitar todo por defecto
        txtObservaciones.setEnabled(false);
        btnTomarMuestra.setEnabled(false);
        
        txtResultado.setEnabled(false);
        btnAdjuntar.setEnabled(false);
        btnGuardarResultado.setEnabled(false);

        ordenActual = null;
    }

    private void buscarOrden() {
        String codigo = txtBuscarCodigo.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código de orden.");
            return;
        }

        // Buscamos usando tu controlador existente [cite: 402]
        ordenActual = gestionOrdenes.buscarOrdenPorCodigo(codigo);

        if (ordenActual != null) {
            // Mostrar datos básicos [cite: 1268]
            lblNombreExamen.setText(ordenActual.getNombre());
            lblTipo.setText(ordenActual.getTipo());

            String estado = ordenActual.getEstado();
            lblEstado.setText(estado != null ? estado : "-");

            // Cargar datos previos si existen
            // 1. Resultado Texto
            String res = ordenActual.getResultado();
            txtResultado.setText(res != null ? res : "");
            
            // 2. Observaciones (Nuevo campo agregado en Paso 1)
            String obs = ordenActual.getObservacionesMuestra();
            txtObservaciones.setText(obs != null ? obs : "");
            
            // 3. Archivo (Nuevo campo agregado en Paso 1)
            String ruta = ordenActual.getRutaArchivoResultado();
            if(ruta != null && !ruta.isEmpty()){
                File f = new File(ruta);
                lblNombreArchivo.setText("Archivo: " + f.getName());
            } else {
                lblNombreArchivo.setText("(Sin archivo)");
            }

            actualizarBotones(estado);

        } else {
            JOptionPane.showMessageDialog(this, "Orden no encontrada.");
            limpiarFormulario();
        }
    }

    private void actualizarBotones(String estado) {
        if (estado == null) estado = "";

        // Lógica de estados según tus requisitos [cite: 1256]
        if ("Pendiente".equalsIgnoreCase(estado)) {
            // FASE 1: Habilitada
            txtObservaciones.setEnabled(true);
            btnTomarMuestra.setEnabled(true);
            
            // FASE 2: Deshabilitada
            txtResultado.setEnabled(false);
            btnAdjuntar.setEnabled(false);
            btnGuardarResultado.setEnabled(false);
            
        } else if ("En Proceso".equalsIgnoreCase(estado) || "EnProceso".equalsIgnoreCase(estado)) {
            // FASE 1: Deshabilitada (ya pasó)
            txtObservaciones.setEnabled(false); 
            btnTomarMuestra.setEnabled(false);
            
            // FASE 2: Habilitada
            txtResultado.setEnabled(true);
            btnAdjuntar.setEnabled(true);
            btnGuardarResultado.setEnabled(true);
            
        } else if ("Finalizado".equalsIgnoreCase(estado) || "Finalizada".equalsIgnoreCase(estado)) {
            // Todo bloqueado (solo lectura)
            txtObservaciones.setEnabled(false);
            btnTomarMuestra.setEnabled(false);
            txtResultado.setEnabled(false);
            btnAdjuntar.setEnabled(false);
            btnGuardarResultado.setEnabled(false);
        } else {
            limpiarFormulario();
        }
    }

    // --- ACCIÓN 1: TOMAR MUESTRA ---
    private void accionTomarMuestra() {
        if (ordenActual != null) {
            String obs = txtObservaciones.getText().trim();
            
            // Usamos el NUEVO método creado en el Paso 2
            boolean exito = gestionOrdenes.registrarTomaDeMuestra(ordenActual.getCodigo(), obs);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Muestra registrada. Estado: En Proceso.");
                buscarOrden(); // Refrescar
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo cambiar el estado.");
            }
        }
    }

    // --- ACCIÓN AUXILIAR: SELECCIONAR ARCHIVO ---
    private void accionAdjuntarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccionar resultado (PDF, Imagen, Texto)");
        
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = fc.getSelectedFile();
            lblNombreArchivo.setText(archivoSeleccionado.getName());
        }
    }

    // --- ACCIÓN 2: GUARDAR RESULTADO ---
    private void accionGuardarResultado() {
        if (ordenActual != null) {
            String resultadoTexto = txtResultado.getText().trim();
            
            // Validar que haya al menos texto O un archivo
            if (resultadoTexto.isEmpty() && archivoSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Debe escribir un resultado o adjuntar un archivo.");
                return;
            }

            String rutaArchivo = (archivoSeleccionado != null) ? archivoSeleccionado.getAbsolutePath() : null;

            // Usamos el NUEVO método creado en el Paso 2
            boolean exito = gestionOrdenes.cargarResultado(ordenActual.getCodigo(), resultadoTexto, rutaArchivo);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Resultado guardado. Orden FINALIZADA.");
                buscarOrden(); // Refrescar
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar resultado.");
            }
        }
    }

    // --- INICIALIZACIÓN DE COMPONENTES ---
    // (Este código reemplaza tu initComponents generado por NetBeans para incluir los nuevos campos)
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
        
        // Componentes Nuevos
        jLabelObs = new javax.swing.JLabel();
        jScrollPaneObs = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        
        btnTomarMuestra = new javax.swing.JButton();
        
        // Botones nuevos para archivo
        btnAdjuntar = new javax.swing.JButton();
        lblNombreArchivo = new javax.swing.JLabel();
        
        btnGuardarResultado = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ejecución de Órdenes");

        jLabel1.setText("Código de Orden:");
        
        // Listeners
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> buscarOrden());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestión de la Orden"));

        jLabel2.setText("Examen:");
        lblNombreExamen.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        lblNombreExamen.setText("---");

        jLabel4.setText("Tipo:");
        lblTipo.setText("---");

        jLabel6.setText("Estado:");
        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        lblEstado.setForeground(new java.awt.Color(0, 102, 204));
        lblEstado.setText("---");

        // Configuración Observaciones
        jLabelObs.setText("Observaciones / Toma de Muestra:");
        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(3);
        jScrollPaneObs.setViewportView(txtObservaciones);

        btnTomarMuestra.setBackground(new java.awt.Color(255, 255, 204));
        btnTomarMuestra.setText("1. Registrar Muestra");
        btnTomarMuestra.addActionListener(evt -> accionTomarMuestra());

        // Configuración Resultados
        jLabel8.setText("Informe Técnico (Texto):");
        txtResultado.setColumns(20);
        txtResultado.setRows(4);
        jScrollPane1.setViewportView(txtResultado);

        btnAdjuntar.setText("Adjuntar Archivo");
        btnAdjuntar.addActionListener(evt -> accionAdjuntarArchivo());
        
        lblNombreArchivo.setFont(new java.awt.Font("Segoe UI", 2, 12));
        lblNombreArchivo.setText("(Ninguno)");

        btnGuardarResultado.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarResultado.setText("2. Guardar y Finalizar");
        btnGuardarResultado.addActionListener(evt -> accionGuardarResultado());

        // Layout Manual (Copiado y adaptado de tu estilo)
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                    
                    // Sección Observaciones
                    .addComponent(jLabelObs)
                    .addComponent(jScrollPaneObs)
                    .addComponent(btnTomarMuestra, javax.swing.GroupLayout.Alignment.TRAILING)
                    
                    // Separador visual
                    .addComponent(jLabel8) // Titulo Resultado
                    .addComponent(jScrollPane1)
                    
                    // Sección Archivos y Guardado final
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdjuntar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarResultado)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                // Info Header
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2).addComponent(lblNombreExamen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4).addComponent(lblTipo).addComponent(jLabel6).addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                // Observaciones
                .addComponent(jLabelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneObs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTomarMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                .addGap(10, 10, 10)
                
                // Resultados
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreArchivo)
                    .addComponent(btnGuardarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(evt -> dispose());

        // Layout Principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
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

    // Declaración de Variables
    private javax.swing.JButton btnAdjuntar; // Nuevo
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardarResultado;
    private javax.swing.JButton btnTomarMuestra;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelObs; // Nuevo
    private javax.swing.JLabel lblNombreArchivo; // Nuevo
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneObs; // Nuevo
    private javax.swing.JSeparator jSeparator1;
    
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreExamen;
    private javax.swing.JLabel lblTipo;
    
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextArea txtObservaciones; // Nuevo
    private javax.swing.JTextArea txtResultado;
}