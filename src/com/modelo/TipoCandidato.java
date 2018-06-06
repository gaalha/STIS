
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class TipoCandidato {
    private int codtipo;
    private String tipocandidato;
    private int activo;

    public TipoCandidato() {
    }

    public TipoCandidato(int codtipo, String tipocandidato, int activo) {
        this.codtipo = codtipo;
        this.tipocandidato = tipocandidato;
        this.activo = activo;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
    
}
