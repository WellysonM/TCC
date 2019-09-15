package com.backend.api.pedido.spec.entity;

import com.backend.api.produto.spec.entity.Produto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido")
public class Pedido {

    @Id
    private String id;
    private String status;
    private Produto produto;
    private String quantidade;
    private String subValor;

    public Pedido(String id, String status, Produto produto, String quantidade, String subValor) {
        this.id = id;
        this.status = status;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subValor = subValor;
    }

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getSubValor() {
        return subValor;
    }

    public void setSubValor(String subValor) {
        this.subValor = subValor;
    }
}