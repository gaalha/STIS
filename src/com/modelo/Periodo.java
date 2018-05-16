
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Periodo {
    
    private int codigoperiodo; 
    private int anio;  
    private String tipoVotacion;

    public Periodo() {
    }

    public Periodo(int codigoperiodo, int anio, String tipoVotacion) {
        this.codigoperiodo = codigoperiodo;
        this.anio = anio;
        this.tipoVotacion = tipoVotacion;
    }

    public int getCodigoperiodo() {
        return codigoperiodo;
    }

    public void setCodigoperiodo(int codigoperiodo) {
        this.codigoperiodo = codigoperiodo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipoVotacion() {
        return tipoVotacion;
    }

    public void setTipoVotacion(String tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
    }

    
}
