
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
public class DaoJRV extends Conexion{
    public void insertarJRV(Jrv jrv) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarJRV`(null,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(2,jrv.getNumerojrv());
            pre.setInt(3, jrv.getCentrovotacion().getCodcentrovotacion());
            pre.setInt(4, jrv.getEncargado().getCodencargado());
            pre.setInt(5, jrv.getActivo());
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
    
    public void modificarJRV(Jrv jrv) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `modificarJRV`(?,?,?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, jrv.getCodjrv());
            pre.setInt(2,jrv.getNumerojrv());
            pre.setInt(3, jrv.getCentrovotacion().getCodcentrovotacion());
            pre.setInt(4, jrv.getEncargado().getCodencargado());
            pre.setInt(5, jrv.getActivo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarJRV(Jrv jrv) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `eliminarJRV`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, jrv.getCodjrv());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarJRV() throws Exception
    {
        List listajrv = new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarJRV`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               CentroVotacion centro = new CentroVotacion();
               centro.setCodcentrovotacion(res.getInt("id_centroVotacion"));
               centro.setCentrovotacion(res.getString("nombre_centroVotacion"));
               Encargado enc = new Encargado();
               enc.setCodencargado(res.getInt("id_encargado"));
               enc.setEncargado(res.getString("nombre_encargado"));
               Jrv jr = new Jrv();
               jr.setCodjrv(res.getInt("id_JRV"));
               jr.setNumerojrv(res.getInt("numero_JRV"));
               jr.setCentrovotacion(centro);
               jr.setEncargado(enc);
               jr.setActivo(res.getInt("activo"));
               listajrv.add(jr);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listajrv;
    }
}
