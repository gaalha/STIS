
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Candidato {
    
    private int codigocandidato; 
    private String nombre; 
    private String titulo; 
    private int codigopartidopolitico;  
    private int codigodetcandidato;  

    public Candidato() {
    }

    public Candidato(int codigocandidato, String nombre, String titulo, int codigopartidopolitico, int codigodetcandidato) {
        this.codigocandidato = codigocandidato;
        this.nombre = nombre;
        this.titulo = titulo;
        this.codigopartidopolitico = codigopartidopolitico;
        this.codigodetcandidato = codigodetcandidato;
    }

    public int getCodigocandidato() {
        return codigocandidato;
    }

    public void setCodigocandidato(int codigocandidato) {
        this.codigocandidato = codigocandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigopartidopolitico() {
        return codigopartidopolitico;
    }

    public void setCodigopartidopolitico(int codigopartidopolitico) {
        this.codigopartidopolitico = codigopartidopolitico;
    }

    public int getCodigodetcandidato() {
        return codigodetcandidato;
    }

    public void setCodigodetcandidato(int codigodetcandidato) {
        this.codigodetcandidato = codigodetcandidato;
    }
    
    

    
}
