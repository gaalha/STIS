
package com.controlador;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import com.modelo.Usuario;
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
            String sql="{CALL `insertarUsuario` (?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getCodigousuario());
            pre.setString(2,us.getUsuario());
            pre.setString(3, us.getClave());
            pre.setString(4,us.getTipo());
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
               usu.setCodigousuario(res.getInt("id_usuario"));
               usu.setUsuario(res.getString("usuario"));
               usu.setClave(res.getString("clave"));
               usu.setTipo(res.getString("tipo_usuario"));
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
            String sql="{CALL `modificarUsuario` (?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,us.getCodigousuario());
            pre.setString(2,us.getUsuario());
            pre.setString(3, us.getClave());
            pre.setString(4,us.getTipo());
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
            String sql="{CALL `eliminarUsuario` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,us.getCodigousuario());
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
