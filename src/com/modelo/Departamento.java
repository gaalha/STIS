
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Departamento {
    
    private int codigoDepartamento;
    private String Departamento;

    public Departamento() {
    }

    public Departamento(int codigoDepartamento, String Departamento) {
        this.codigoDepartamento = codigoDepartamento;
        this.Departamento = Departamento;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    
    
    
}
