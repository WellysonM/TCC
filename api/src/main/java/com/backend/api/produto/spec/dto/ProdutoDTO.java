package com.backend.api.produto.spec.dto;

import com.backend.api.categoria.spec.entity.Categoria;
import com.backend.api.produto.spec.entity.Produto;

public class ProdutoDTO {

    private String id;
    private String produto;
    private double preco;
    private Categoria categoria;
    private String TempoPreparo;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        TempoPreparo = produto.getTempoPreparo();
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
