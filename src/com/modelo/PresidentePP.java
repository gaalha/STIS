
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class PresidentePP {
    
    private int codigopresidentePP; 
    private String nombre; 
    int codigousuario;

    public PresidentePP() {
    }

    public PresidentePP(int codigopresidentePP, String nombre, int codigousuario) {
        this.codigopresidentePP = codigopresidentePP;
        this.nombre = nombre;
        this.codigousuario = codigousuario;
    }

    public int getCodigopresidentePP() {
        return codigopresidentePP;
    }

    public void setCodigopresidentePP(int codigopresidentePP) {
        this.codigopresidentePP = codigopresidentePP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }
    
    

}
