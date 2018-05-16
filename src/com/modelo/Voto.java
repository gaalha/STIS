
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Voto {
    
    private int codigovoto; 
    private int codigocentroVotacion;  
    private int codigovotante;  
    private int codigocandidato;  
    private int acumulativo;

    public Voto() {
    }

    public Voto(int codigovoto, int codigocentroVotacion, int codigovotante, int codigocandidato, int acumulativo) {
        this.codigovoto = codigovoto;
        this.codigocentroVotacion = codigocentroVotacion;
        this.codigovotante = codigovotante;
        this.codigocandidato = codigocandidato;
        this.acumulativo = acumulativo;
    }

    public int getCodigovoto() {
        return codigovoto;
    }

    public void setCodigovoto(int codigovoto) {
        this.codigovoto = codigovoto;
    }

    public int getCodigocentroVotacion() {
        return codigocentroVotacion;
    }

    public void setCodigocentroVotacion(int codigocentroVotacion) {
        this.codigocentroVotacion = codigocentroVotacion;
    }

    public int getCodigovotante() {
        return codigovotante;
    }

    public void setCodigovotante(int codigovotante) {
        this.codigovotante = codigovotante;
    }

    public int getCodigocandidato() {
        return codigocandidato;
    }

    public void setCodigocandidato(int codigocandidato) {
        this.codigocandidato = codigocandidato;
    }

    public int getAcumulativo() {
        return acumulativo;
    }

    public void setAcumulativo(int acumulativo) {
        this.acumulativo = acumulativo;
    }
    
    
    

}
