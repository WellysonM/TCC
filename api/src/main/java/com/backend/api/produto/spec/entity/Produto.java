package com.backend.api.produto.spec.entity;

import com.backend.api.categoria.spec.entity.Categoria;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String produto;
    private String preco;
    private Categoria categoria;
    private String tempoPreparo;

    public Produto() {
    }

    public Produto(String id, String produto, String preco, Categoria categoria, String tempoPreparo) {
        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}