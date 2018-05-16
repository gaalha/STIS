
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Votante {
    
    private int codigovotante;
    private String nombre;
    private String dui;
    private String nombreMadre;
    private String nombrePadre;
    private String fechanac;
    private String estadocivil;
    private String direccion;
    private int codigousuario;
    private int codigomunicipio;

    public Votante() {
    }

    public Votante(int codigovotante, String nombre, String dui, String nombreMadre, String nombrePadre, String fechanac, String estadocivil, String direccion, int codigousuario, int codigomunicipio) {
        this.codigovotante = codigovotante;
        this.nombre = nombre;
        this.dui = dui;
        this.nombreMadre = nombreMadre;
        this.nombrePadre = nombrePadre;
        this.fechanac = fechanac;
        this.estadocivil = estadocivil;
        this.direccion = direccion;
        this.codigousuario = codigousuario;
        this.codigomunicipio = codigomunicipio;
    }

    public int getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(int codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public int getCodigovotante() {
        return codigovotante;
    }

    public void setCodigovotante(int codigovotante) {
        this.codigovotante = codigovotante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }
    
    
}
