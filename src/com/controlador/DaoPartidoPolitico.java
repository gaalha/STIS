
package com.controlador;

import com.conexion.Conexion;
import com.modelo.PartidoPolitico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar Mejia
 */
public class DaoPartidoPolitico extends Conexion{
    public void insertarPartido(PartidoPolitico par) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarPartido`(null,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,par.getPartido());
            pre.setString(2,par.getPresidente());
            pre.setBytes(3, par.getFotoPartido());
            pre.setInt(4, par.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarPartido() throws Exception
    {
        List listapartido=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarPartido`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               PartidoPolitico par=new PartidoPolitico();
               par.setCodpartido(res.getInt("id_partidoPolitico"));
               par.setPartido(res.getString("nombre_partidoPolitico"));
               par.setPresidente(res.getString("nombre_presidente"));
               par.setFotoPartido(res.getBytes("fotoPartido"));
               par.setActivo(res.getInt("activo"));
               listapartido.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listapartido;
    }
    
    public void modificarPartido(PartidoPolitico par) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarPartido` (?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, par.getCodpartido());
            pre.setString(2,par.getPartido());
            pre.setString(3,par.getPresidente());
            pre.setBytes(4, par.getFotoPartido());
            pre.setInt(5, par.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarPartido(PartidoPolitico par) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarPartido` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,par.getCodpartido());
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
