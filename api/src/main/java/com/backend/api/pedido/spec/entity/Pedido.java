package com.backend.api.pedido.spec.entity;

import com.backend.api.produto.spec.entity.Produto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "pedido")
public class Pedido {

    @Id
    private String id;
    private String status;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String quantidade;
    private String subValor;

    public Pedido(String id, String status, ArrayList<Produto> produtos, String quantidade, String subValor) {
        this.id = id;
        this.status = status;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.subValor = subValor;
    }

    public Pedido() {
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
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