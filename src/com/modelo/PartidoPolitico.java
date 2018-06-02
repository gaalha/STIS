
package com.modelo;

/**
 *
 * @author carlos franco
 */
public class PartidoPolitico {
    
    private int codpartido;
    private String partido;
    private String presidente;
    private byte[] fotoPartido;
    private int activo;

    public PartidoPolitico() {
    }

    public PartidoPolitico(int codpartido, String partido, String presidente, byte[] fotoPartido, int activo) {
        this.codpartido = codpartido;
        this.partido = partido;
        this.presidente = presidente;
        this.fotoPartido = fotoPartido;
        this.activo = activo;
    }

    public int getCodpartido() {
        return codpartido;
    }

    public void setCodpartido(int codpartido) {
        this.codpartido = codpartido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public byte[] getFotoPartido() {
        return fotoPartido;
    }

    public void setFotoPartido(byte[] fotoPartido) {
        this.fotoPartido = fotoPartido;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
