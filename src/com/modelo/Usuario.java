
package com.modelo;

/**
 * Nombre de la Clase: Usuario
 * Version: 1.0
 * Fecha: 05/12/18
 * @author Administrador
 * CopyRight: ITCA-FEPADE
 */
public class Usuario {
    
    private int codigousuario;
    private String usuario;
    private String clave;
    private String tipo;

    public Usuario() {
    }

    public Usuario(int codigousuario, String usuario, String clave, String tipo) {
        this.codigousuario = codigousuario;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
