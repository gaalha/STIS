
package imagenes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos franco
 */
public class login {
    Connection conect = null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect=DriverManager.getConnection("jdbc:mysql://localhost/votacion2018bd","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
        return conect;
    }
}
