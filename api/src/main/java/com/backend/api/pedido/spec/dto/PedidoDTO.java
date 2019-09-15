package com.backend.api.pedido.spec.dto;


import com.backend.api.pedido.spec.entity.Pedido;
import com.backend.api.produto.spec.entity.Produto;

public class PedidoDTO {

    private String id;
    private String status;
    private Produto produto;
    private String quantidade;
    private String subValor;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        this.produto = pedido.getProduto();
        this.quantidade = pedido.getQuantidade();
        this.subValor = pedido.getSubValor();
    }

    public PedidoDTO() {
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
