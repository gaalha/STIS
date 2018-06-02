
package com.controlador;

import com.conexion.Conexion;
import com.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos franco
 */
public class DaoEncargado extends Conexion{
    public void insertarEncargado(Encargado enc) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarEncargado`(?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, enc.getCodencargado());
            pre.setString(2,enc.getEncargado());
            pre.setString(3, enc.getDui());
            pre.setInt(4, enc.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarEncargado() throws Exception
    {
        List listaencargado = new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarEncargado`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Encargado  enc = new Encargado();
               enc.setCodencargado(res.getInt("id_encargado"));
               enc.setEncargado(res.getString("nombre_encargado"));
               enc.setDui(res.getString("dui"));
               enc.setActivo(res.getInt("activo"));
               listaencargado.add(enc);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaencargado;
    }
    
    public void modificarEncargado(Encargado enc) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarEncargado` (?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, enc.getCodencargado());
            pre.setString(2,enc.getEncargado());
            pre.setString(3, enc.getDui());
            pre.setInt(4, enc.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarEncargado(Encargado enc) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarEncargado` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,enc.getCodencargado());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
}
