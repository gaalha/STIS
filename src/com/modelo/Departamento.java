
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Departamento {
   
    private int coddepartamento;
    private String departamento;
    private int activo;

    public Departamento() {
    }

    public Departamento(int coddepartamento, String departamento, int activo) {
        this.coddepartamento = coddepartamento;
        this.departamento = departamento;
        this.activo = activo;
    }

    public int getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(int coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
