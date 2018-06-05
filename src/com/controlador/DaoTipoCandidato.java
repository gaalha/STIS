
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Departamento;
import com.modelo.TipoCandidato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos franco
 */
public class DaoTipoCandidato extends Conexion{
    public void insertarTipo(TipoCandidato tipo) throws Exception{
    try 
        {
            this.conectar();
            String sql="{CALL `insertarTipoCandidato`(?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,tipo.getTipocandidato());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public List mostrarTipo() throws Exception
    {
        List listatipo=new ArrayList();
        ResultSet res;
        Statement st;
        try 
        {
            this.conectar();
            String sql="{CALL `mostrarTipo`()}";
            st=this.getCon().createStatement();
            res=st.executeQuery(sql);
            while(res.next())
            {
               TipoCandidato ti=new TipoCandidato();
               ti.setCodtipo(res.getInt("id_tipoCandidato"));
               ti.setTipocandidato(res.getString("tipo_candidato"));
               ti.setActivo(res.getInt("activo"));
               listatipo.add(ti);
            }
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listatipo;
    }
    
    public void modificarTipo(TipoCandidato tipo) throws Exception
    { 
        try 
        {
            this.conectar();
            String sql="{CALL `modificarTipo` (?,?,?)}";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,tipo.getCodtipo());
            pre.setString(2,tipo.getTipocandidato());
            pre.setInt(3, tipo.getActivo());
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
