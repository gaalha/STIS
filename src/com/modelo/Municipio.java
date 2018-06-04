
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Municipio {
    
    private int codMunicipio;
    private String municipio;
    private Departamento departamento;
    private int activo;

    public Municipio() {
    }

    public Municipio(int codMunicipio, String municipio, Departamento departamento, int activo) {
        this.codMunicipio = codMunicipio;
        this.municipio = municipio;
        this.departamento = departamento;
        this.activo = activo;
    }

    public int getCodmunicipio() {
        return codMunicipio;
    }

    public void setCodmunicipio(int codmunicipio) {
        this.codMunicipio = codmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
