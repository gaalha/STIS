
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Departamento;
import com.modelo.Municipio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos franco
 */
public class DaoMunicipio extends Conexion{
    public void insertarMunicipio(Municipio mu) throws Exception{
        try {
            this.conectar();
            String sql="{CALL `insertarMunicipio`(?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, mu.getMunicipio());
            pre.setInt(2, mu.getDepartamento().getCoddepartamento());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
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
            rs = pre.executeQuery();
            while(rs.next()){
                valor = rs.getInt(1);
            }
            c.desconectar();
        } catch (Exception e) {
            e.toString();
        }
        return valor;
    }
    
    public void modificarMunicipio(Municipio mu) throws Exception{
        try {
            this.conectar();
            String sql="{CALL `modificarMunicipio`(?, ?, ?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, mu.getMunicipio());
            pre.setInt(2, mu.getDepartamento().getCoddepartamento());
            pre.setInt(3, mu.getCodmunicipio());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void eliminarMunicipio(Municipio mu) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `eliminarMunicipio`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, mu.getCodmunicipio());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarMunicipio() throws Exception
    {
        List listamunicipio=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarMunicipio`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Departamento dep = new Departamento();
               dep.setCoddepartamento(res.getInt("id_departamento"));
               dep.setDepartamento(res.getString("nombre_departamento"));
               Municipio mu=new Municipio();
               mu.setCodmunicipio(res.getInt("id_municipio"));
               mu.setMunicipio(res.getString("nombre_municipio"));
               mu.setDepartamento(dep);
               mu.setActivo(res.getInt("activo"));
               listamunicipio.add(mu);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listamunicipio;
    }
    
}
