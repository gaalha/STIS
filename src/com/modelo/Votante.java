
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Votante {
    
    private int codvotante;
    private String votante;
    private String dui;
    private String nombrepadre;
    private String nombremadre;
    private String fecha;
    private String estadocivil;
    private String direccion;
    private Municipio municipio;
    private int activo;

    public Votante() {
    }

    public Votante(int codvotante, String votante, String dui, String nombrepadre, String nombremadre, String fecha, String estadocivil, String direccion, Municipio municipio, int activo) {
        this.codvotante = codvotante;
        this.votante = votante;
        this.dui = dui;
        this.nombrepadre = nombrepadre;
        this.nombremadre = nombremadre;
        this.fecha = fecha;
        this.estadocivil = estadocivil;
        this.direccion = direccion;
        this.municipio = municipio;
        this.activo = activo;
    }

    public int getCodvotante() {
        return codvotante;
    }

    public void setCodvotante(int codvotante) {
        this.codvotante = codvotante;
    }

    public String getVotante() {
        return votante;
    }

    public void setVotante(String votante) {
        this.votante = votante;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombrepadre() {
        return nombrepadre;
    }

    public void setNombrepadre(String nombrepadre) {
        this.nombrepadre = nombrepadre;
    }

    public String getNombremadre() {
        return nombremadre;
    }

    public void setNombremadre(String nombremadre) {
        this.nombremadre = nombremadre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
