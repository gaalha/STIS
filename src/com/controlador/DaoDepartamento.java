
package com.controlador;

import com.modelo.Departamento;
import com.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos franco
 */
public class DaoDepartamento extends Conexion{
    
    public void insertarDepartamento(Departamento depa) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarDepartamento` (?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, depa.getCodigoDepartamento());
            pre.setString(2,depa.getDepartamento());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    public List mostrarDeparatamento() throws Exception
    {
        List listadepartamento=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL mostrarDepartamento ()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Departamento de=new Departamento();
               de.setCodigoDepartamento(res.getInt("id_departamento"));
               de.setDepartamento(res.getString("nombre"));
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
            String sql="{CALL `modificarDepartamento` (?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,depa.getCodigoDepartamento());
            pre.setString(2,depa.getDepartamento());
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
            pre.setInt(1,depa.getCodigoDepartamento());
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
