package com.backend.api.produto.spec.entity;

import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String produto;
    private double preco;
    private Categoria categoria;
    private String TempoPreparo;

    public Produto() {
    }

    public Produto(String id, String produto, double preco, Categoria categoria, String tempoPreparo) {
        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.categoria = categoria;
        TempoPreparo = tempoPreparo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTempoPreparo() {
        return TempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        TempoPreparo = tempoPreparo;
    }
}