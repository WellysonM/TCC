package com.backend.api.categoria.spec.dto;


import com.backend.api.categoria.spec.entity.Categoria;

public class CategoriaDTO {

    private String id;
    private String icone;
    private String titulo;
    private String subTitulo;
    private double preco;
    private String cor;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.icone = categoria.getIcone();
        this.titulo = categoria.getTitulo();
        this.subTitulo = categoria.getSubTitulo();
        this.preco = categoria.getPreco();
        this.cor = categoria.getCor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
