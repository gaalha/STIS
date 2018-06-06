package com.vista;

import com.conexion.Conexion;
import com.controlador.DaoVotante;
import com.modelo.Municipio;
import com.modelo.Votante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar Mejía
 */
public class FrmVotante extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmVotante
     */
    public FrmVotante() {
        initComponents();
        tablaE();
        this.jCbMunicipio.removeAllItems();
        llenarCombo();
        this.jTxtCodVotante.setVisible(false);
    }
    
    DaoVotante daov = new DaoVotante();
    Votante vot = new Votante();
    
    public void tablaE(){
        String [] columnas = {"id", "Nombre", "DUI", "Madre", "Padre", "Fecha nacimiento", "Estado civil", "Direccion", "Municipio"} ;
        Object[] obj = new Object[9];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        List ls;
        try {
           ls = daov.mostrarVotante();
            for(int i=0; i<ls.size(); i++){
                vot = (Votante)ls.get(i);
                obj[0] = vot.getCodvotante();
                obj[1] = vot.getVotante();
                obj[2] = vot.getDui();
                obj[3] = vot.getNombremadre();
                obj[4] = vot.getNombrepadre();
                obj[5] = vot.getFecha();
                obj[6] = vot.getEstadocivil();
                obj[7] = vot.getDireccion();
                obj[8] = vot.getMunicipio().getMunicipio();
                tabla.addRow(obj);
            }
            this.jTableVotante.setModel(tabla);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
    public void llenarTabla(){
        int fila = this.jTableVotante.getSelectedRow();
        this.jTxtCodVotante.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 0)));
        this.jTxtNombreVotante.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 1)));
        this.jTxtDui.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 2)));
        this.jTxtNombreMadre.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 3)));
        this.jTxtNombrePadre.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 4)));
        this.jTxtFechaNacimiento.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 5)));
        this.jCbEstadoCivil.setSelectedItem(String.valueOf(this.jTableVotante.getValueAt(fila, 6)));
        this.jTxtDireccion.setText(String.valueOf(this.jTableVotante.getValueAt(fila, 7)));
        this.jCbMunicipio.setSelectedItem(String.valueOf(this.jTableVotante.getValueAt(fila, 8)));
    }
    
    public void llenarCombo(){
        Conexion c = new Conexion();
        ResultSet res;
        try {
            c.conectar();
            String sql = "SELECT nombre_municipio FROM Municipio WHERE activo = 1";
            
            PreparedStatement pre = c.getCon().prepareCall(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                jCbMunicipio.addItem(res.getString("nombre_municipio"));
            }
        } catch (Exception e) {
            e.toString();
        }
    }
    
    public void limpiar(){
        this.jTxtCodVotante.setText("");
        this.jTxtNombreVotante.setText("");
        this.jTxtDui.setText("");
        this.jTxtNombreMadre.setText("");
        this.jTxtNombrePadre.setText("");
        this.jTxtFechaNacimiento.setText("");
        this.jCbEstadoCivil.setSelectedIndex(0);
        this.jTxtDireccion.setText("");
        this.jCbMunicipio.setSelectedIndex(0);
    }
    
    public void insertar(){
        try {
            Municipio m = new Municipio();

            vot.setVotante(this.jTxtNombreVotante.getText().trim());
            vot.setDui(this.jTxtDui.getText().trim());
            vot.setNombremadre(this.jTxtNombreMadre.getText().trim());
            vot.setNombrepadre(this.jTxtNombrePadre.getText().trim());
            vot.setFecha(this.jTxtFechaNacimiento.getText().trim());
            vot.setEstadocivil(this.jCbEstadoCivil.getSelectedItem().toString().trim());
            vot.setDireccion(this.jTxtDireccion.getText().trim());

            String municipio = this.jCbMunicipio.getSelectedItem().toString().trim();
            String sql = "SELECT id_municipio FROM Municipio WHERE nombre_municipio = '" + municipio + "'";
            int id_municipio = daov.valorInteger(sql);

            m.setCodmunicipio(id_municipio);
            m.setMunicipio(municipio);
            vot.setMunicipio(m);

            daov.insertarVotante(vot);

            JOptionPane.showMessageDialog(null, "Registro guardado con exito.");
            tablaE();
            limpiar();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this,e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificar(){
        try {
            Municipio m = new Municipio();
            
            vot.setCodvotante(Integer.parseInt(this.jTxtCodVotante.getText().trim()));
            vot.setVotante(this.jTxtNombreVotante.getText().trim());
            vot.setDui(this.jTxtDui.getText().trim());
            vot.setNombremadre(this.jTxtNombreMadre.getText().trim());
            vot.setNombrepadre(this.jTxtNombrePadre.getText().trim());
            vot.setFecha(this.jTxtFechaNacimiento.getText().trim());
            vot.setEstadocivil(this.jCbEstadoCivil.getSelectedItem().toString().trim());
            vot.setDireccion(this.jTxtDireccion.getText().trim());
            
            String municipio = this.jCbMunicipio.getSelectedItem().toString().trim();
            String sql = "SELECT id_municipio FROM Municipio WHERE nombre_municipio = '" + municipio + "'";
            int id_municipio = daov.valorInteger(sql);

            m.setCodmunicipio(id_municipio);
            m.setMunicipio(municipio);
            vot.setMunicipio(m);
            
            int SiONo=JOptionPane.showConfirmDialog(this, "¿Desea modificar el Votante?",
                    "Modificar Votante",JOptionPane.YES_NO_OPTION);
            if(SiONo == 0){
                daov.modificarVotante(vot);
                JOptionPane.showMessageDialog(rootPane, "Votante modificado con exito", 
                        "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaE();
                limpiar();
            }
            else{
                limpiar();
            }
        }catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public void eliminar(){
       try{
            vot.setCodvotante(Integer.parseInt(this.jTxtCodVotante.getText().trim()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea eliminar el Votante",
                    "Eliminar Votante", JOptionPane.YES_NO_OPTION);
            if(SiONo == 0){
                daov.eliminarVotante(vot);
                JOptionPane.showMessageDialog(rootPane,"Eliminado con exito" , "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaE();
                limpiar();
            }else{
                limpiar();
            }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane, e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtCodVotante = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtNombreVotante = new javax.swing.JTextField();
        jTxtNombreMadre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtFechaNacimiento = new javax.swing.JFormattedTextField();
        jCbMunicipio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtDireccion = new javax.swing.JTextArea();
        jTxtDui = new javax.swing.JFormattedTextField();
        jTxtNombrePadre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCbEstadoCivil = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVotante = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("GESTIONAR VOTANTES");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("NOMBRE MADRE:");

        jLabel4.setText("NOMBRE PADRE:");

        jLabel5.setText("FECHA NACIMIENTO:");

        jLabel6.setText("MUNICIPIO:");

        jLabel7.setText("DIRECCIÓN:");

        jLabel8.setText("DUI:");

        jTxtDireccion.setColumns(20);
        jTxtDireccion.setRows(5);
        jScrollPane1.setViewportView(jTxtDireccion);

        jLabel9.setText("ESTADO CIVIL:");

        jCbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Viudo/a" }));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jBtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jBtnAgregar.setText("AGREGAR");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jBtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        jBtnModificar.setText("MODIFICAR");
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/goma-de-borrar.png"))); // NOI18N
        jBtnLimpiar.setText("LIMPIAR");
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAgregar)
                .addGap(18, 18, 18)
                .addComponent(jBtnModificar)
                .addGap(18, 18, 18)
                .addComponent(jBtnEliminar)
                .addGap(18, 18, 18)
                .addComponent(jBtnLimpiar)
                .addGap(52, 52, 52))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar)
                    .addComponent(jBtnModificar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableVotante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableVotante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVotanteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVotante);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtNombreVotante, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jTxtNombreMadre)
                                    .addComponent(jTxtFechaNacimiento)
                                    .addComponent(jCbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtNombrePadre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(79, 79, 79)
                                        .addComponent(jTxtDui, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(19, 19, 19)
                                        .addComponent(jCbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jTxtCodVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTxtNombreVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTxtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtNombreMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jCbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        if(this.jTxtNombreVotante.getText().isEmpty() ||
                this.jTxtDui.getText().isEmpty() ||
                this.jTxtNombreMadre.getText().isEmpty() ||
                this.jTxtNombrePadre.getText().isEmpty() ||
                this.jTxtFechaNacimiento.getText().isEmpty() ||
                this.jTxtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
        }else{
            insertar();
        }
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed
        // TODO add your handling code here:
        if(!(this.jTxtCodVotante.getText().isEmpty() &&
                this.jTxtNombreVotante.getText().isEmpty() &&
                this.jTxtDui.getText().isEmpty() &&
                this.jTxtNombreMadre.getText().isEmpty() &&
                this.jTxtNombrePadre.getText().isEmpty() &&
                this.jTxtFechaNacimiento.getText().isEmpty() &&
                this.jTxtDireccion.getText().isEmpty())){
            modificar();
        }else{
            JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
        }
        
    }//GEN-LAST:event_jBtnModificarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
        if(!(this.jTxtCodVotante.getText().isEmpty() &&
                this.jTxtNombreVotante.getText().isEmpty() &&
                this.jTxtDui.getText().isEmpty() &&
                this.jTxtNombreMadre.getText().isEmpty() &&
                this.jTxtNombrePadre.getText().isEmpty() &&
                this.jTxtFechaNacimiento.getText().isEmpty() &&
                this.jTxtDireccion.getText().isEmpty())){
            eliminar();
        }else{
            JOptionPane.showMessageDialog(null, "Nada que eliminar...");
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jTableVotanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVotanteMouseClicked
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jTableVotanteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JComboBox<String> jCbEstadoCivil;
    private javax.swing.JComboBox<String> jCbMunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVotante;
    private javax.swing.JTextField jTxtCodVotante;
    private javax.swing.JTextArea jTxtDireccion;
    private javax.swing.JFormattedTextField jTxtDui;
    private javax.swing.JFormattedTextField jTxtFechaNacimiento;
    private javax.swing.JTextField jTxtNombreMadre;
    private javax.swing.JTextField jTxtNombrePadre;
    private javax.swing.JTextField jTxtNombreVotante;
    // End of variables declaration//GEN-END:variables
}
