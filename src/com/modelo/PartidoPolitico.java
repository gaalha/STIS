
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class PartidoPolitico {
    
    private int codigopartidoPolitico; 
    private String nombre; 
    private int codigopresidentepp;  

    public PartidoPolitico() {
    }

    public PartidoPolitico(int codigopartidoPolitico, String nombre, int codigopresidentepp) {
        this.codigopartidoPolitico = codigopartidoPolitico;
        this.nombre = nombre;
        this.codigopresidentepp = codigopresidentepp;
    }

    public int getCodigopartidoPolitico() {
        return codigopartidoPolitico;
    }

    public void setCodigopartidoPolitico(int codigopartidoPolitico) {
        this.codigopartidoPolitico = codigopartidoPolitico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigopresidentepp() {
        return codigopresidentepp;
    }

    public void setCodigopresidentepp(int codigopresidentepp) {
        this.codigopresidentepp = codigopresidentepp;
    }
    
    


}
