
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Jrv {
    
    private int codjrv;
    private int numerojrv;
    private CentroVotacion centrovotacion;
    private Encargado encargado;
    private int activo;

    public Jrv() {
    }

    public Jrv(int codjrv, int numerojrv, CentroVotacion centrovotacion, Encargado encargado, int activo) {
        this.codjrv = codjrv;
        this.numerojrv = numerojrv;
        this.centrovotacion = centrovotacion;
        this.encargado = encargado;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCodjrv() {
        return codjrv;
    }

    public void setCodjrv(int codjrv) {
        this.codjrv = codjrv;
    }

    public int getNumerojrv() {
        return numerojrv;
    }

    public void setNumerojrv(int numerojrv) {
        this.numerojrv = numerojrv;
    }

    public CentroVotacion getCentrovotacion() {
        return centrovotacion;
    }

    public void setCentrovotacion(CentroVotacion centrovotacion) {
        this.centrovotacion = centrovotacion;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }
    
    
}
