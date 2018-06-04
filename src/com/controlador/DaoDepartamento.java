
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar Mejía
 */
public class DaoDepartamento extends Conexion{
    public void insertarDepartamento(Departamento depa) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarDepartamento`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,depa.getDepartamento());
            //pre.setInt(2, depa.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public List mostrarDepartamento() throws Exception
    {
        List listadepartamento=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarDepartamento`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Departamento de=new Departamento();
               de.setCoddepartamento(res.getInt("id_departamento"));
               de.setDepartamento(res.getString("nombre_departamento"));
               de.setActivo(res.getInt("activo"));
               listadepartamento.add(de);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listadepartamento;
    }
    
    public void modificarDepartamento(Departamento depa) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarDepartamento` (?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,depa.getCoddepartamento());
            pre.setString(2,depa.getDepartamento());
            pre.setInt(3, depa.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarDepartamento(Departamento depa) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarDepartamento` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,depa.getCoddepartamento());
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
