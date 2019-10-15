package com.backend.api.pedido.spec.dto;


import com.backend.api.mesa.spec.entity.Mesa;
import com.backend.api.pedido.spec.entity.Pedido;
import com.backend.api.produto.spec.entity.Produto;
import com.backend.api.usuario.spec.entity.Usuario;

import java.util.ArrayList;

public class PedidoDTO {

    private String id;
    private String status;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String valorTotal;
    private Mesa mesa;
    private Usuario usuario;
    private String cliente;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        this.produtos = pedido.getProdutos();
        this.valorTotal = pedido.getValorTotal();
        this.mesa = pedido.getMesa();
        this.usuario = pedido.getUsuario();
        this.cliente = pedido.getCliente();
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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
