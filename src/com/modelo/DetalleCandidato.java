
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class DetalleCandidato {
    
    private int id_detCandidato; 
    private String tipoCandidato;  

    public DetalleCandidato() {
    }

    public DetalleCandidato(int id_detCandidato, String tipoCandidato) {
        this.id_detCandidato = id_detCandidato;
        this.tipoCandidato = tipoCandidato;
    }

    public int getId_detCandidato() {
        return id_detCandidato;
    }

    public void setId_detCandidato(int id_detCandidato) {
        this.id_detCandidato = id_detCandidato;
    }

    public String getTipoCandidato() {
        return tipoCandidato;
    }

    public void setTipoCandidato(String tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }
    
    
}
