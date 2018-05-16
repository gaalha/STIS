
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Municipio
{
    private int id_municipio;
    private String nombre;
    private Departamento Departamento;

    public Municipio() {
    }

    public Municipio(int id_municipio, String nombre, Departamento Departamento) {
        this.id_municipio = id_municipio;
        this.nombre = nombre;
        this.Departamento = Departamento;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.Departamento = Departamento;
    }

    
    
    
    
}
