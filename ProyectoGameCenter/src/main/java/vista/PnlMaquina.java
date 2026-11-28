
package vista;

import controlador.ControladorMaquina;
import modelo.TipoMaquina;
import modelo.Maquina;
import utilitario.ErrorBaseDatosException;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class PnlMaquina extends javax.swing.JPanel {
    
    ControladorMaquina con = new ControladorMaquina();
    String idMaquinaSeleccionada;
    TipoMaquina tipoComputadora;
    TipoMaquina tipoConsola;

    public PnlMaquina() {
        initComponents();
        cargarMaquinas();
        cargarTarifas();
    }
    
    public void cargarMaquinas(){
    
        try {
            List<Maquina> lista = con.listarMaquina();
            DefaultTableModel dt = (DefaultTableModel) tablaMaquinas.getModel();
            dt.setRowCount(0);
            idMaquinaSeleccionada=null;
            
            for(Maquina m:lista){
                Object[] o = {
                    m.getId_maquina(), m.getNombre_maquina(), m.getTipo().getNombre_tipo(), m.getEstado_maquina()
                };
                dt.addRow(o);
            }
        } catch (ErrorBaseDatosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al listar máquinas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarTarifas(){
        try {
            for(TipoMaquina x:con.listarTipoMaquina()){
                String tarifa = String.format("Tarifa actual: "+"S/ %.2f", x.getTarifa_hora());
                
                if("Computadora".equals(x.getNombre_tipo())){
                    tipoComputadora=x;
                    lblTarifaComputadora.setText(tarifa);
                } else if ("Consola".equals(x.getNombre_tipo())){
                    tipoConsola=x;
                    lblTarifaConsola.setText(tarifa);
                }
            }
            
        } catch (ErrorBaseDatosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al cargar las tarifas", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabMaquina = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreNuevo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbComputadora = new javax.swing.JRadioButton();
        rbConsola = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cbEstadoNuevo = new javax.swing.JComboBox<>();
        btnGrabar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaquinas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lblMaquinaCod = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreModificar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbEstadoModificar = new javax.swing.JComboBox<>();
        btnGuardarCambios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblClienteCod1 = new javax.swing.JLabel();
        lblClienteCod2 = new javax.swing.JLabel();
        lblTarifaComputadora = new javax.swing.JLabel();
        lblClienteCod4 = new javax.swing.JLabel();
        lblTarifaConsola = new javax.swing.JLabel();
        lblClienteCod6 = new javax.swing.JLabel();
        txtTarifaComputadoraNueva = new javax.swing.JTextField();
        txtTarifaConsolaNueva = new javax.swing.JTextField();
        btnComputadoraActualizar = new javax.swing.JButton();
        btnConsolaActualizar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR NUEVA MAQUINA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tipo:");

        buttonGroup1.add(rbComputadora);
        rbComputadora.setText("Computadora");

        buttonGroup1.add(rbConsola);
        rbConsola.setText("Consola");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Estado:");

        cbEstadoNuevo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Elegir", "Habilitada", "Mantenimiento", "Retirada" }));

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(this::btnGrabarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreNuevo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbComputadora)
                                .addGap(31, 31, 31)
                                .addComponent(rbConsola)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbEstadoNuevo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btnGrabar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbComputadora)
                    .addComponent(rbConsola))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbEstadoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(btnGrabar)
                .addGap(54, 54, 54))
        );

        tabMaquina.addTab("Nuevo", jPanel1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LISTA DE MAQUINAS");

        tablaMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Tipo ", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMaquinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMaquinas);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("MODIFICAR");

        lblMaquinaCod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaquinaCod.setText("Maquina: ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Estado:");

        cbEstadoModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Elegir", "Habilitada", "Mantenimiento", "Retirada" }));

        btnGuardarCambios.setText("GUARDAR CAMBIOS");
        btnGuardarCambios.addActionListener(this::btnGuardarCambiosActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("________________________________________________________");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaquinaCod)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cbEstadoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardarCambios)
                        .addGap(182, 182, 182))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(lblMaquinaCod)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbEstadoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnGuardarCambios)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(243, 243, 243)
                    .addComponent(jLabel8)
                    .addContainerGap(244, Short.MAX_VALUE)))
        );

        tabMaquina.addTab("Modificar", jPanel2);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CAMBIAR TARIFA DE LAS MÁQUINAS");

        lblClienteCod1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClienteCod1.setText("COMPUTADORA");

        lblClienteCod2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClienteCod2.setText("CONSOLA");

        lblTarifaComputadora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTarifaComputadora.setText("Tarifa actual: ");

        lblClienteCod4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClienteCod4.setText("Tarifa nueva:");

        lblTarifaConsola.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTarifaConsola.setText("Tarifa actual:");

        lblClienteCod6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClienteCod6.setText("Tarifa nueva:");

        btnComputadoraActualizar.setText("Actualizar");
        btnComputadoraActualizar.addActionListener(this::btnComputadoraActualizarActionPerformed);

        btnConsolaActualizar.setText("Actualizar");
        btnConsolaActualizar.addActionListener(this::btnConsolaActualizarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblClienteCod1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTarifaComputadora)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblClienteCod4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTarifaComputadoraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClienteCod2)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTarifaConsola)
                            .addComponent(lblClienteCod6))
                        .addGap(18, 18, 18)
                        .addComponent(txtTarifaConsolaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnComputadoraActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsolaActualizar)
                        .addGap(111, 111, 111))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCod1)
                    .addComponent(lblClienteCod2))
                .addGap(173, 173, 173)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTarifaComputadora)
                    .addComponent(lblTarifaConsola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCod4)
                    .addComponent(lblClienteCod6)
                    .addComponent(txtTarifaComputadoraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarifaConsolaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComputadoraActualizar)
                    .addComponent(btnConsolaActualizar))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tabMaquina.addTab("Tarifa", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaquina)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaquina)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        
        try {
            Maquina m = new Maquina();
            m.setNombre_maquina(txtNombreNuevo.getText());
            
            if(cbEstadoNuevo.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(this, "Selecciona el estado de la máquina");
                return;
            }
            m.setEstado_maquina((String)cbEstadoNuevo.getSelectedItem());
            
            String nombreTipo;
            if(rbComputadora.isSelected()){
                nombreTipo = "Computadora";
            } else if(rbConsola.isSelected()){
                nombreTipo = "Consola";
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona el tipo de máquina");
                return;
            }
            for(TipoMaquina x:con.listarTipoMaquina()){
                if(nombreTipo.equals(x.getNombre_tipo())){
                    m.setTipo(x);
                    
                    con.registrarMaquina(m);
                    JOptionPane.showMessageDialog(this,"Máquina registrada correctamente");
                    txtNombreNuevo.setText("");
                    buttonGroup1.clearSelection();
                    cbEstadoNuevo.setSelectedIndex(0);
                    cargarMaquinas();
                    return;
                } 
            }
            
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Campo inválido",JOptionPane.WARNING_MESSAGE);
        } catch (ErrorBaseDatosException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tablaMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMaquinasMouseClicked
        
        int fila = tablaMaquinas.getSelectedRow();
        if(fila<0){
            return;
        }
        
        idMaquinaSeleccionada=(String) tablaMaquinas.getValueAt(fila,0);
        lblMaquinaCod.setText("Maquina: "+idMaquinaSeleccionada);
        txtNombreModificar.setText((String)tablaMaquinas.getValueAt(fila, 1));
        cbEstadoModificar.setSelectedItem(tablaMaquinas.getValueAt(fila, 3));
    }//GEN-LAST:event_tablaMaquinasMouseClicked

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        
        if(idMaquinaSeleccionada == null){
            JOptionPane.showMessageDialog(this, "Selecciona una máquina de la tabla", "Error al modificar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Maquina m = new Maquina();
            m.setId_maquina(idMaquinaSeleccionada);
            m.setNombre_maquina(txtNombreModificar.getText());
            m.setEstado_maquina((String)cbEstadoModificar.getSelectedItem());
            con.modificarMaquina(m);
            JOptionPane.showMessageDialog(this, "Datos modificados correctamente.");
            
            tablaMaquinas.clearSelection();
            lblMaquinaCod.setText("Máquina: ");
            txtNombreModificar.setText("");
            cbEstadoModificar.setSelectedIndex(0);
            cargarMaquinas();
            
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campo inválido", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cambio de estado no realizado", JOptionPane.WARNING_MESSAGE);
        } catch (ErrorBaseDatosException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnComputadoraActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadoraActualizarActionPerformed
        
        try {
            double nuevaTarifa = Double.parseDouble(txtTarifaComputadoraNueva.getText());
            
            TipoMaquina t = new TipoMaquina();
            t.setId_tipo(tipoComputadora.getId_tipo());
            t.setTarifa_hora(nuevaTarifa);
            
            con.actualizarTarifa(t);
            JOptionPane.showMessageDialog(this, "Se ha actualizado la tarifa correctamente");
            txtTarifaComputadoraNueva.setText("");
            cargarTarifas();
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ingresa un número, por ejemplo 3.50", "Importe inválido", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Tarfia inválida", JOptionPane.WARNING_MESSAGE);
        } catch (ErrorBaseDatosException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al actualizar la tarifa", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnComputadoraActualizarActionPerformed

    private void btnConsolaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsolaActualizarActionPerformed
        
        try {
            double nuevaTarifa = Double.parseDouble(txtTarifaConsolaNueva.getText());
            
            TipoMaquina t = new TipoMaquina();
            t.setId_tipo(tipoConsola.getId_tipo());
            t.setTarifa_hora(nuevaTarifa);
            
            con.actualizarTarifa(t);
            JOptionPane.showMessageDialog(this, "Se ha actualizado la tarifa correctamente");
            txtTarifaConsolaNueva.setText("");
            cargarTarifas();
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ingresa un número, por ejemplo 3.50", "Importe inválido", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Tarfia inválida", JOptionPane.WARNING_MESSAGE);
        } catch (ErrorBaseDatosException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al actualizar la tarifa", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btnConsolaActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComputadoraActualizar;
    private javax.swing.JButton btnConsolaActualizar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbEstadoModificar;
    private javax.swing.JComboBox<String> cbEstadoNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClienteCod1;
    private javax.swing.JLabel lblClienteCod2;
    private javax.swing.JLabel lblClienteCod4;
    private javax.swing.JLabel lblClienteCod6;
    private javax.swing.JLabel lblMaquinaCod;
    private javax.swing.JLabel lblTarifaComputadora;
    private javax.swing.JLabel lblTarifaConsola;
    private javax.swing.JRadioButton rbComputadora;
    private javax.swing.JRadioButton rbConsola;
    private javax.swing.JTabbedPane tabMaquina;
    private javax.swing.JTable tablaMaquinas;
    private javax.swing.JTextField txtNombreModificar;
    private javax.swing.JTextField txtNombreNuevo;
    private javax.swing.JTextField txtTarifaComputadoraNueva;
    private javax.swing.JTextField txtTarifaConsolaNueva;
    // End of variables declaration//GEN-END:variables
}
