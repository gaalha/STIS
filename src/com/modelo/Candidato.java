
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class Candidato {
    
    private int codcandidato;
    private String candidato;
    private String titulo;
    private TipoCandidato tipo;
    private PartidoPolitico partido;
    private byte[] fotoCandidato;
    private int activo;

    public Candidato() {
    }

    public Candidato(int codcandidato, String candidato, String titulo, TipoCandidato tipo, PartidoPolitico partido, byte[] fotoCandidato, int activo) {
        this.codcandidato = codcandidato;
        this.candidato = candidato;
        this.titulo = titulo;
        this.tipo = tipo;
        this.partido = partido;
        this.fotoCandidato = fotoCandidato;
        this.activo = activo;
    }

    public int getCodcandidato() {
        return codcandidato;
    }

    public void setCodcandidato(int codcandidato) {
        this.codcandidato = codcandidato;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoCandidato getTipo() {
        return tipo;
    }

    public void setTipo(TipoCandidato tipo) {
        this.tipo = tipo;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public byte[] getFotoCandidato() {
        return fotoCandidato;
    }

    public void setFotoCandidato(byte[] fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
