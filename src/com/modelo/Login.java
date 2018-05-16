
package com.modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos franco
 */
public class Login {
    Connection conect = null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect=DriverManager.getConnection("jdbc:mysql://localhost/Votacion2018","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
        return conect;
    }
}
