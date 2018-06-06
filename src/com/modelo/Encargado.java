
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Encargado {
    
    private int codencargado;
    private String encargado;
    private String dui;
    private int activo;

    public Encargado() {
    }

    public Encargado(int codencargado, String encargado, String dui, int activo) {
        this.codencargado = codencargado;
        this.encargado = encargado;
        this.dui = dui;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCodencargado() {
        return codencargado;
    }

    public void setCodencargado(int codencargado) {
        this.codencargado = codencargado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    
    
}
