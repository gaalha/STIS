
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class TipoCandidato {
    private int codtipo;
    private String tipocandidato;

    public TipoCandidato() {
    }

    public TipoCandidato(int codtipo, String tipocandidato) {
        this.codtipo = codtipo;
        this.tipocandidato = tipocandidato;
    }

    public int getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(int codtipo) {
        this.codtipo = codtipo;
    }

    public String getTipocandidato() {
        return tipocandidato;
    }

    public void setTipocandidato(String tipocandidato) {
        this.tipocandidato = tipocandidato;
    }

    
}
