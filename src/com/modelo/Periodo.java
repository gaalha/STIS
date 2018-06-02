
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Periodo {
    
    private int codperiodo;
    private String periodo;
    private String descripcion;
    private int activo;

    public Periodo() {
    }

    public Periodo(int codperiodo, String periodo, String descripcion, int activo) {
        this.codperiodo = codperiodo;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCodperiodo() {
        return codperiodo;
    }

    public void setCodperiodo(int codperiodo) {
        this.codperiodo = codperiodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
