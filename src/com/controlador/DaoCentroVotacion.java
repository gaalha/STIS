
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
public class DaoCentroVotacion extends Conexion{
    public void insertarCentroVotacion(CentroVotacion centro) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarCentro`(null,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(2,centro.getCentrovotacion());
            pre.setInt(3, centro.getMunicipio().getCodmunicipio());
            pre.setInt(4, centro.getActivo());
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
    
    public void modificarCentro(CentroVotacion centro) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `modificarCentro`(?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, centro.getCodcentrovotacion());
            pre.setString(2,centro.getCentrovotacion());
            pre.setInt(3, centro.getMunicipio().getCodmunicipio());
            pre.setInt(4, centro.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarCentro(CentroVotacion centro) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `eliminarCentro`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, centro.getCodcentrovotacion());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarCentro() throws Exception
    {
        List listacentro = new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarCentro`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Municipio mun = new Municipio();
               mun.setCodmunicipio(res.getInt("id_municipio"));
               mun.setMunicipio(res.getString("nombre_municipio"));
               CentroVotacion centro = new CentroVotacion();
               centro.setCodcentrovotacion(res.getInt("id_centroVotacion"));
               centro.setCentrovotacion(res.getString("nombre_centroVotacion"));
               centro.setMunicipio(mun);
               centro.setActivo(res.getInt("activo"));
               listacentro.add(centro);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listacentro;
    }
}
