/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.conexion.Conexion;
import com.controlador.DaoUsuario;
import com.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos franco
 */
public class FrmUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        initComponents();
        jTxtCodigousuario.setVisible(false);
        tablaE();
    }
    
    DaoUsuario daou = new DaoUsuario();
    Usuario usu = new Usuario();

    public void insertar()
    {
        
        try 
        {
           usu.setCodusuario(Integer.parseInt(this.jTxtCodigousuario.getText().trim()));
           usu.setNombre_usuario(this.jTxtNombre.getText().trim());
           usu.setApellido_usuario(this.jTxtApellido.getText().trim());
           usu.setUser(this.jTxtUsuario.getText().trim());
           usu.setClave(this.jPassClave.getText());
           usu.setTipousuario(this.jCbTipo.getSelectedItem().toString());
           daou.insertarUsuario(usu);
           JOptionPane.showMessageDialog(null,"Datos Insertado Correctamente");
          /* tablaE();*/
           limpiar();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this,e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarTabla()
 {
      int fila=this.jTablaUsuario.getSelectedRow();
      this.jTxtCodigousuario.setText(String.valueOf(this.jTablaUsuario.getValueAt(fila, 0)));
      this.jTxtNombre.setText(String.valueOf(this.jTablaUsuario.getValueAt(fila, 1)));
      this.jTxtApellido.setText(String.valueOf(this.jTablaUsuario.getValueAt(fila, 2)));
      this.jTxtUsuario.setText(String.valueOf(this.jTablaUsuario.getValueAt(fila, 3)));
      this.jPassClave.setText(String.valueOf(this.jTablaUsuario.getValueAt(fila, 4)));
      this.jCbTipo.setSelectedItem(String.valueOf(this.jTablaUsuario.getValueAt(fila, 5)));
 }
     public void limpiar()
    {
      this.jTxtCodigousuario.setText("");
      this.jTxtNombre.setText("");
      this.jTxtApellido.setText("");
      this.jTxtUsuario.setText("");
      this.jPassClave.setText("");
      this.jCbTipo.setSelectedIndex(0);
    }
    
     public void modificar()
    {
         try 
        {
            usu.setCodusuario(Integer.parseInt(this.jTxtCodigousuario.getText().trim()));
            usu.setNombre_usuario(this.jTxtNombre.getText().trim());
            usu.setApellido_usuario(this.jTxtApellido.getText().trim());
            usu.setUser(this.jTxtUsuario.getText().trim());
            usu.setClave(this.jPassClave.getText());
            usu.setTipousuario(this.jCbTipo.getSelectedItem().toString());
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea modificar el Departamento",
                    "Modificar Departamento",JOptionPane.YES_NO_OPTION);
            if(SiONo==0)
            {
                daou.modificarUsuario(usu);
                JOptionPane.showMessageDialog(rootPane, "Departamento modificado con exito", 
                        "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaE();
                limpiar();
            }
            else
            {
                limpiar();
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
     
    public void eliminar()
    {

        try 
        {
            usu.setCodusuario(Integer.parseInt(this.jTxtCodigousuario.getText()));
            int SiONo=JOptionPane.showConfirmDialog(this, "Desea eliminar el Departamento",
                    "Eliminar Departamento",JOptionPane.YES_NO_OPTION);
            if(SiONo==0)
            {
                daou.eliminarUsuario(usu);
                JOptionPane.showMessageDialog(rootPane,"Eliminado con exito" , "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaE();
                limpiar();
            }
            else
            {
                limpiar();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void tablaE()
    {
        String [] columnas={"CodigoUsuario","NombreUsuario","Apellido Usuario","Usuario","Clave","Tipo Usuario"} ;
        Object[] obj=new Object[6];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try 
        {
           ls =daou.mostrarUsuario();
            for(int i=0;i<ls.size();i++)
            {   usu=(Usuario)ls.get(i);
                obj[0]=usu.getCodusuario();
                obj[1]=usu.getNombre_usuario();
                obj[2]=usu.getApellido_usuario();
                obj[3]=usu.getUser();
                obj[4]=usu.getClave();
                obj[5]=usu.getTipousuario();
                tabla.addRow(obj);
            }
        
            ls=daou.mostrarUsuario();
            this.jTablaUsuario.setModel(tabla);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPassClave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jCbTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaUsuario = new javax.swing.JTable();
        jBtnBuscar = new javax.swing.JButton();
        jTxtBusqueda = new javax.swing.JTextField();
        jTxtCodigousuario = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setText("NOMBRE USUARIO:");

        jLabel3.setText("APELLIDO USUARIO:");

        jLabel4.setText("USUARIO:");

        jLabel5.setText("CLAVE:");

        jLabel6.setText("TIPO USUARIO:");

        jCbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion...", "Delegado", "Administrador" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTxtNombre)
                        .addComponent(jTxtApellido)
                        .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPassClave, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("GESTIONAR USUARIOS");

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jBtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jBtnAgregar.setText("AGREGAR");
        jBtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarMouseClicked(evt);
            }
        });

        jBtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barajar.png"))); // NOI18N
        jBtnModificar.setText("MODIFICAR");
        jBtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModificarMouseClicked(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login (1).png"))); // NOI18N
        jBtnSalir.setText("CERRAR");
        jBtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSalirMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/goma-de-borrar.png"))); // NOI18N
        jButton1.setText("LIMPIAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSalir)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jTablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablaUsuario);

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR:");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.setBorderPainted(false);
        jBtnBuscar.setContentAreaFilled(false);

        jTxtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBuscar)
                    .addComponent(jTxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(jTxtCodigousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtCodigousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarMouseClicked
        if(jTxtNombre.getText().isEmpty() ||
                jTxtApellido.getText().isEmpty() || 
                jTxtUsuario.getText().isEmpty() || 
                jPassClave.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios");
        }else{
            insertar();
        }
    }//GEN-LAST:event_jBtnAgregarMouseClicked

    private void jBtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModificarMouseClicked
        modificar();
    }//GEN-LAST:event_jBtnModificarMouseClicked

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
        if(jTxtNombre.getText().isEmpty() ||
                jTxtApellido.getText().isEmpty() || 
                jTxtUsuario.getText().isEmpty() || 
                jPassClave.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios");
        }else{
            eliminar();
        }
    }//GEN-LAST:event_jBtnEliminarMouseClicked

    private void jTablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaUsuarioMouseClicked
        llenarTabla();
    }//GEN-LAST:event_jTablaUsuarioMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        limpiar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jBtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalirMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jBtnSalirMouseClicked

    private void jTxtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtBusquedaKeyPressed
        
    }//GEN-LAST:event_jTxtBusquedaKeyPressed

    private void jTxtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtBusquedaKeyReleased
        String [] columnas={"CodigoUsuario","NombreUsuario","Apellido Usuario","Usuario","Clave","Tipo Usuario"} ;
        Object[] obj=new Object[6];
        String sql="SELECT * FROM Usuario WHERE id_usuario LIKE '%"
                +jTxtBusqueda.getText()+"%'"
                +"OR nombre_usuario LIKE '%" + jTxtBusqueda.getText() + "%'"
                +"OR apellido_usuario LIKE '%" + jTxtBusqueda.getText() + "%'"
                +"OR usuario LIKE '%" + jTxtBusqueda.getText() + "%'"
                +"OR tipo_usuario LIKE '%" + jTxtBusqueda.getText() + "%';";
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        Conexion con = new Conexion();
        try {
            con.conectar();
            ResultSet rs;
            Statement st = con.getCon().createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                obj[0] = rs.getString("id_usuario");
                obj[1] = rs.getString("nombre_usuario");
                obj[2] = rs.getString("apellido_usuario");
                obj[3] = rs.getString("usuario");
                obj[4] = rs.getString("clave");
                obj[5] = rs.getString("tipo_usuario");
                model.addRow(obj);
            }
            jTablaUsuario.setModel(model);
        } catch (Exception e) {
            e.toString();
        }
    }//GEN-LAST:event_jTxtBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassClave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablaUsuario;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtBusqueda;
    private javax.swing.JTextField jTxtCodigousuario;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
