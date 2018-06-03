
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos franco
 */
public class DaoUsuario extends Conexion{
    public void insertarUsuario(Usuario us) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarUsuario` (null,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(2, us.getNombre_usuario());
            pre.setString(3, us.getApellido_usuario());
            pre.setString(4,us.getUser());
            pre.setString(5, us.getClave());
            pre.setString(6,us.getTipousuario());
            pre.setInt(7, us.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    public List mostrarUsuario() throws Exception
    {
        List listausuario=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarUsuario`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Usuario usu=new Usuario();
               usu.setCodusuario(res.getInt("id_usuario"));
               usu.setNombre_usuario(res.getString("nombre_usuario"));
               usu.setApellido_usuario(res.getString("apellido_usuario"));
               usu.setUser(res.getString("usuario"));
               usu.setClave(res.getString("clave"));
               usu.setTipousuario(res.getString("tipo_usuario"));
               usu.setActivo(res.getInt("activo"));
               listausuario.add(usu);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listausuario;
    }
    public void modificarUsuario(Usuario us) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarUsuario` (?,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getCodusuario());
            pre.setString(2, us.getNombre_usuario());
            pre.setString(3, us.getApellido_usuario());
            pre.setString(4,us.getUser());
            pre.setString(5, us.getClave());
            pre.setString(6,us.getTipousuario());
            pre.setInt(7, us.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    public void eliminarUsuario(Usuario us) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarUsuario`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,us.getCodusuario());
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
