/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.conexion.Conexion;
import com.modelo.PartidoPolitico;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class DaoVotacion extends Conexion{
    
    public List getPartidos() throws Exception{
       List partidosList = new ArrayList();
       ResultSet res;
       Statement st;
       
       try{
           this.conectar();
           String sql="{CALL `mostrarPartido`()}";
           st = this.getCon().createStatement();
           res = st.executeQuery(sql);
           
           while(res.next()){
                PartidoPolitico par=new PartidoPolitico();
                par.setCodpartido(res.getInt("id_partidoPolitico"));
                par.setFotoPartido(res.getBytes("fotoPartido"));
                partidosList.add(par);
           }
       }catch(Exception e){
           throw e;
       }
       finally{
           this.desconectar();
       }
       
       return partidosList;
    }
    
    public void getCandidatos(){
        
    }
}
