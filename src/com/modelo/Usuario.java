
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Usuario {
    
    private int codusuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String user;
    private String clave;
    private String tipousuario;
    private int activo;

    public Usuario() {
    }

    public Usuario(int codusuario, String nombre_usuario, String apellido_usuario, String user, String clave, String tipousuario, int activo) {
        this.codusuario = codusuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.user = user;
        this.clave = clave;
        this.tipousuario = tipousuario;
        this.activo = activo;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
    
    
}
