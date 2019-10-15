package com.backend.api.pedido.spec.entity;

import com.backend.api.mesa.spec.entity.Mesa;
import com.backend.api.produto.spec.entity.Produto;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "pedido")
public class Pedido {

    @Id
    private String id;
    private String status;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String valorTotal;
    private Mesa mesa;
    private Usuario usuario;
    private String cliente;

    public Pedido(String id, String status, ArrayList<Produto> produtos, String valorTotal, Mesa mesa, Usuario usuario, String cliente) {
        this.id = id;
        this.status = status;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.mesa = mesa;
        this.usuario = usuario;
        this.cliente = cliente;
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