
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Encargado {
    private int codigoencargado; 
    private String nombre;
    private String estado_civil;

    public Encargado() {
    }

    public Encargado(int codigoencargado, String nombre, String estado_civil) {
        this.codigoencargado = codigoencargado;
        this.nombre = nombre;
        this.estado_civil = estado_civil;
    }

    public int getCodigoencargado() {
        return codigoencargado;
    }

    public void setCodigoencargado(int codigoencargado) {
        this.codigoencargado = codigoencargado;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    
}
