
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class CentroVotacion {
    
    private int codcentrovotacion;
    private String centrovotacion;
    private Municipio municipio;
    private int activo;

    public CentroVotacion() {
    }

    public CentroVotacion(int codcentrovotacion, String centrovotacion, Municipio municipio, int activo) {
        this.codcentrovotacion = codcentrovotacion;
        this.centrovotacion = centrovotacion;
        this.municipio = municipio;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCodcentrovotacion() {
        return codcentrovotacion;
    }

    public void setCodcentrovotacion(int codcentrovotacion) {
        this.codcentrovotacion = codcentrovotacion;
    }

    public String getCentrovotacion() {
        return centrovotacion;
    }

    public void setCentrovotacion(String centrovotacion) {
        this.centrovotacion = centrovotacion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
