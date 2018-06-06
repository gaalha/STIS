
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
 * @author Edgar Mejía
 */
public class DaoVotante extends Conexion {
    public List mostrarVotante() throws Exception{
        List listavotante = new ArrayList();
        ResultSet res;
        Statement st;
        try {
            this.conectar();
            String sql="{CALL `mostrarVotante`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next()){
               Municipio muni = new Municipio();
               muni.setCodmunicipio(res.getInt("idMunicipio"));
               muni.setMunicipio(res.getString("nombre_municipio"));
               
               Votante vot = new Votante();
               vot.setCodvotante(res.getInt("id_votante"));
               vot.setVotante(res.getString("nombre_votante"));
               vot.setDui(res.getString("dui"));
               vot.setNombremadre(res.getString("nombreMadre"));
               vot.setNombrepadre(res.getString("nombrePadre"));
               vot.setFecha(res.getString("fechaNac"));
               vot.setEstadocivil(res.getString("estadoCivil"));
               vot.setDireccion(res.getString("direccion"));
               vot.setMunicipio(muni);
               vot.setActivo(res.getInt("activo"));
               listavotante.add(vot);
            }
        } catch (Exception e) {
            throw e;
        }
        finally {
            this.desconectar();
        }
        return listavotante;
    }
    
    public void insertarVotante(Votante vot) throws Exception{
        try {
            this.conectar();
            String sql="{CALL `insertarVotante`(?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, vot.getVotante());
            pre.setString(2, vot.getDui());
            pre.setString(3, vot.getNombremadre());
            pre.setString(4, vot.getNombrepadre());
            pre.setString(5, vot.getFecha());
            pre.setString(6, vot.getEstadocivil());
            pre.setString(7, vot.getDireccion());
            pre.setInt(8, vot.getMunicipio().getCodmunicipio());
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
        try {
            this.conectar();
            String sql="{CALL `modificarVotante`(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
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
        try {
            this.conectar();
            String sql="{CALL `eliminarVotante`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, vot.getCodvotante());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
}
