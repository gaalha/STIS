
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Centrodevotacion {
    private int codigocentrovotacion; 
    private String nombre;  
    private int codigomunicipio;  
    private int codigoperiodo;  
    private int codigoJRV;

    public Centrodevotacion() {
    }

    public Centrodevotacion(int codigocentrovotacion, String nombre, int codigomunicipio, int codigoperiodo, int codigoJRV) {
        this.codigocentrovotacion = codigocentrovotacion;
        this.nombre = nombre;
        this.codigomunicipio = codigomunicipio;
        this.codigoperiodo = codigoperiodo;
        this.codigoJRV = codigoJRV;
    }

    public int getCodigocentrovotacion() {
        return codigocentrovotacion;
    }

    public void setCodigocentrovotacion(int codigocentrovotacion) {
        this.codigocentrovotacion = codigocentrovotacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(int codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public int getCodigoperiodo() {
        return codigoperiodo;
    }

    public void setCodigoperiodo(int codigoperiodo) {
        this.codigoperiodo = codigoperiodo;
    }

    public int getCodigoJRV() {
        return codigoJRV;
    }

    public void setCodigoJRV(int codigoJRV) {
        this.codigoJRV = codigoJRV;
    }
    
    
    
}
