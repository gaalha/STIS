
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Municipio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author carlos franco
 */
public class DaoMunicipio extends Conexion {
    
    
    public void insertarMunicipio(Municipio mu) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarMunicipio`(?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, mu.getId_municipio());
            pre.setString(2,mu.getNombre());
            pre.setInt(3, mu.getDepartamento().getCodigoDepartamento());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public int valorInteger(String sql){
        Conexion c = new Conexion();
        ResultSet rs;
        int valor = 0;
        try {
            c.conectar();
            PreparedStatement pre = c.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                valor=rs.getInt(1);
            }
            c.desconectar();
        } catch (Exception e) {
            e.toString();
        }
        return valor;
    }
}
