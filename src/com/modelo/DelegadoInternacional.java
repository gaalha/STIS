
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class DelegadoInternacional {
    
    private int coddelegado;
    private String delgadointernacional;
    private String cargo;
    private Usuario usuario;
    private int activo;

    public DelegadoInternacional() {
    }

    public DelegadoInternacional(int coddelegado, String delgadointernacional, String cargo, Usuario usuario, int activo) {
        this.coddelegado = coddelegado;
        this.delgadointernacional = delgadointernacional;
        this.cargo = cargo;
        this.usuario = usuario;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCoddelegado() {
        return coddelegado;
    }

    public void setCoddelegado(int coddelegado) {
        this.coddelegado = coddelegado;
    }

    public String getDelgadointernacional() {
        return delgadointernacional;
    }

    public void setDelgadointernacional(String delgadointernacional) {
        this.delgadointernacional = delgadointernacional;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
