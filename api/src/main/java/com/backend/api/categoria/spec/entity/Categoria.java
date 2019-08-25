package com.backend.api.categoria.spec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categoria")
public class Categoria {

    @Id
    private String id;
    private String icone;
    private String titulo;
    private String subTitulo;
    private double preco;
    private String cor;

    public Categoria() {
    }

    public Categoria(String id, String icone, String titulo, String subTitulo, double preco, String cor) {
        this.id = id;
        this.icone = icone;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.cor = cor;
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