package org.ddd.entities;

public class Ddd {
    private int codigo;
    private String estado;
    private String imagemBandeira;

    public String getImagemBandeira() {
        return imagemBandeira;
    }

    public void setImagemBandeira(String imagemBandeira) {
        this.imagemBandeira = imagemBandeira;
    }

    public Ddd(int codigo, String cidade, String imagemBandeira) {
        this.codigo = codigo;
        this.estado = cidade;
        this.imagemBandeira = imagemBandeira;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String cidade) {
        this.estado = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
