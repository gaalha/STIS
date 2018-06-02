
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
public class DaoPeriodo extends Conexion{
    public void insertarPeriodo(Periodo per) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarPerido`(?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, per.getCodperiodo());
            pre.setString(2,per.getPeriodo());
            pre.setString(3, per.getDescripcion());
            pre.setInt(4, per.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarPeriodo() throws Exception
    {
        List listaperiodo = new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarPeriodo`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Periodo  per = new Periodo();
               per.setCodperiodo(res.getInt("id_periodo"));
               per.setPeriodo(res.getString("nombreperido"));
               per.setDescripcion(res.getString("descripcion"));
               per.setActivo(res.getInt("activo"));
               listaperiodo.add(per);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaperiodo;
    }
    
    public void modificarPeriodo(Periodo per) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarPeriodo` (?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, per.getCodperiodo());
            pre.setString(2,per.getPeriodo());
            pre.setString(3, per.getDescripcion());
            pre.setInt(4, per.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarPeriodo(Periodo per) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarPeriodo` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,per.getCodperiodo());
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
