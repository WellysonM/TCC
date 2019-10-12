package com.backend.api.produto.spec.dto;

import com.backend.api.categoria.spec.entity.Categoria;
import com.backend.api.produto.spec.entity.Produto;

public class ProdutoDTO {

    private String id;
    private String produto;
    private String preco;
    private Categoria categoria;
    private String tempoPreparo;
    private String quantidade;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        this.tempoPreparo = produto.getTempoPreparo();
        this.quantidade = produto.getQuantidade();
    }

    public ProdutoDTO() {
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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
