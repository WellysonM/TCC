package com.backend.api.comanda.spec.dto;


import com.backend.api.comanda.spec.entity.Comanda;
import com.backend.api.mesa.spec.entity.Mesa;
import com.backend.api.pedido.spec.entity.Pedido;

import java.util.ArrayList;

public class ComandaDTO {

    private String id;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public ComandaDTO(Comanda comanda) {
        this.id = comanda.getId();
        this.mesa = comanda.getMesa();
        this.pedidos = comanda.getPedidos();
    }

    public ComandaDTO() {
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
