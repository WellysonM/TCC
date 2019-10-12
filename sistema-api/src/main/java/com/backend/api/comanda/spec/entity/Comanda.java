package com.backend.api.comanda.spec.entity;

import com.backend.api.mesa.spec.entity.Mesa;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "comanda")
public class Comanda {

    @Id
    private String id;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Comanda() {
    }

    public Comanda(String id, Mesa mesa, ArrayList<Pedido> pedidos) {
        this.id = id;
        this.mesa = mesa;
        this.pedidos = pedidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}