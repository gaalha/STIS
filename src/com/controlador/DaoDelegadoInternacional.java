
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
public class DaoDelegadoInternacional extends Conexion{
    public void insertarDelegado(DelegadoInternacional del) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarDelegado`(null,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(2,del.getDelgadointernacional());
            pre.setString(3,del.getCargo());
            pre.setInt(4, del.getUsuario().getCodusuario());
            pre.setInt(5, del.getActivo());
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
    
    public void modificarDelegado(DelegadoInternacional del) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `modificarDelegado`(?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, del.getCoddelegado());
            pre.setString(2,del.getDelgadointernacional());
            pre.setString(3,del.getCargo());
            pre.setInt(4, del.getUsuario().getCodusuario());
            pre.setInt(5, del.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarDelegado(DelegadoInternacional del) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `eliminarDelegado`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, del.getCoddelegado());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarDelegado() throws Exception
    {
        List listadelegado=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarDelegado`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Usuario us = new Usuario();
               us.setCodusuario(res.getInt("id_usuario"));
               us.setUser(res.getString("usuario"));
               us.setClave(res.getString("clave"));
               us.setTipousuario(res.getString("tipo_usuario"));
               DelegadoInternacional del=new DelegadoInternacional();
               del.setCoddelegado(res.getInt("id_delegadoInternacional"));
               del.setDelgadointernacional(res.getString("nombre_delegado"));
               del.setCargo(res.getString("cargo"));
               del.setUsuario(us);
               del.setActivo(res.getInt("activo"));
               listadelegado.add(del);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listadelegado;
    }
}
