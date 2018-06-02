
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Usuario {
    
    private int codusuario;
    private String user;
    private String clave;
    private String tipousuario;
    private int activo;

    public Usuario() {
    }

    public Usuario(int codusuario, String user, String clave, String tipousuario, int activo) {
        this.codusuario = codusuario;
        this.user = user;
        this.clave = clave;
        this.tipousuario = tipousuario;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    
}
