/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class DelegadoInternacional {
    private int id_delgadointernacional;
    private String nombre;
    private String apellido;
    private String cargo;
    private int id_Usuario;

    public DelegadoInternacional() {
    }

    public DelegadoInternacional(int id_delgadointernacional, String nombre, String apellido, String cargo, int id_Usuario) {
        this.id_delgadointernacional = id_delgadointernacional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.id_Usuario = id_Usuario;
    }

    public int getId_delgadointernacional() {
        return id_delgadointernacional;
    }

    public void setId_delgadointernacional(int id_delgadointernacional) {
        this.id_delgadointernacional = id_delgadointernacional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    
    

}
