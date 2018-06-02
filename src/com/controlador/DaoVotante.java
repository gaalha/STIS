
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
public class DaoVotante extends Conexion{
    public void insertarVotante(Votante vot) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarVotante`(?,?,?,?,?,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, vot.getCodvotante());
            pre.setString(2, vot.getVotante());
            pre.setString(3, vot.getDui());
            pre.setString(4, vot.getNombremadre());
            pre.setString(5, vot.getNombrepadre());
            pre.setString(6, vot.getFecha());
            pre.setString(7, vot.getEstadocivil());
            pre.setString(8, vot.getDireccion());
            pre.setInt(9, vot.getMunicipio().getCodmunicipio());
            pre.setInt(10, vot.getUsuario().getCodusuario());
            pre.setInt(11, vot.getActivo());
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
    
    public void modificarVotante(Votante vot) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarVotante`(?,?,?,?,?,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, vot.getCodvotante());
            pre.setString(2, vot.getVotante());
            pre.setString(3, vot.getDui());
            pre.setString(4, vot.getNombremadre());
            pre.setString(5, vot.getNombrepadre());
            pre.setString(6, vot.getFecha());
            pre.setString(7, vot.getEstadocivil());
            pre.setString(8, vot.getDireccion());
            pre.setInt(9, vot.getMunicipio().getCodmunicipio());
            pre.setInt(10, vot.getUsuario().getCodusuario());
            pre.setInt(11, vot.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarVotante(Votante vot) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `eliminarVotante`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, vot.getCodvotante());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarVotante() throws Exception
    {
        List listavotante = new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarVotante`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               Municipio muni = new Municipio();
               muni.setCodmunicipio(res.getInt("id_municipio"));
               muni.setMunicipio(res.getString("nombre_municipio"));
               Usuario us = new Usuario();
               us.setCodusuario(res.getInt("id_usuario"));
               us.setUser(res.getString("usuario"));
               us.setClave(res.getString("clave"));
               us.setTipousuario(res.getString("tipo_usuario"));
               us.setActivo(res.getInt("activo"));
               Votante vot = new Votante();
               vot.setCodvotante(res.getInt("id_votante"));
               vot.setVotante(res.getString("nombre_votante"));
               vot.setVotante(res.getString("dui"));
               vot.setVotante(res.getString("nombreMadre"));
               vot.setVotante(res.getString("nombrePadre"));
               vot.setVotante(res.getString("fechaNac"));
               vot.setVotante(res.getString("estadoCivil"));
               vot.setVotante(res.getString("estadoCivil"));
               vot.setVotante(res.getString("direccion"));
               vot.setMunicipio(muni);
               vot.setUsuario(us);
               vot.setActivo(res.getInt("activo"));
               listavotante.add(vot);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listavotante;
    }
}
