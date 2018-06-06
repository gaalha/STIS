
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author carlos franco
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
    public void conectar() throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/votacion2018bd?user=root&password=");
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void desconectar() throws Exception
    {
        try 
        {
             if(con!=null)
            {
                if(con.isClosed()==false)
                {
                  con.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
       
    }
}
