
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class DetalleEncargado {
    private int id_detJRV; 
    private int numeroJRV;  
    private int id_Encargado;  

    public DetalleEncargado() {
    }

    public DetalleEncargado(int id_detJRV, int numeroJRV, int id_Encargado) {
        this.id_detJRV = id_detJRV;
        this.numeroJRV = numeroJRV;
        this.id_Encargado = id_Encargado;
    }

    public int getId_detJRV() {
        return id_detJRV;
    }

    public void setId_detJRV(int id_detJRV) {
        this.id_detJRV = id_detJRV;
    }

    public int getNumeroJRV() {
        return numeroJRV;
    }

    public void setNumeroJRV(int numeroJRV) {
        this.numeroJRV = numeroJRV;
    }

    public int getId_Encargado() {
        return id_Encargado;
    }

    public void setId_Encargado(int id_Encargado) {
        this.id_Encargado = id_Encargado;
    }

    
}
