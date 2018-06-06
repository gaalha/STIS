
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
public class DaoCandidato extends Conexion{
    public void insertarCandidato(Candidato can) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarCandidato`(null,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(2, can.getCandidato());
            pre.setString(3, can.getTitulo());
            pre.setInt(4, can.getTipo().getCodtipo());
            pre.setInt(5, can.getPartido().getCodpartido());
            pre.setBytes(6, can.getFotoCandidato());
            pre.setInt(7, can.getActivo());
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
    
    public List mostrarCandidato() throws Exception
    {
        List listacandidato=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarCandidato`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               TipoCandidato tipo = new TipoCandidato();
               tipo.setCodtipo(res.getInt("id_tipoCandidato"));
               tipo.setTipocandidato(res.getString("tipo_Candidato"));
               PartidoPolitico par=new PartidoPolitico();
               par.setCodpartido(res.getInt("id_partidoPolitico"));
               par.setPartido(res.getString("nombre_partidoPolitico"));
               Candidato can = new Candidato();
               can.setCodcandidato(res.getInt("id_candidato"));
               can.setCandidato(res.getString("nombre_candidato"));
               can.setTitulo(res.getString("titulo"));
               can.setTipo(tipo);
               can.setPartido(par);
               can.setFotoCandidato(res.getBytes("fotoCandidato"));
               can.setActivo(res.getInt("activo"));
               listacandidato.add(can);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listacandidato;
    }
    
    public void modificarCandidato(Candidato can) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarCandidato` (?,?,?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, can.getCodcandidato());
            pre.setString(2,can.getCandidato());
            pre.setString(3,can.getTitulo());
            pre.setInt(4, can.getTipo().getCodtipo());
            pre.setInt(5, can.getPartido().getCodpartido());
            pre.setBytes(6, can.getFotoCandidato());
            pre.setInt(5, can.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarCandidato(Candidato can) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `eliminarCandidato` (?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,can.getCodcandidato());
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
