package com.backend.api.mesa.spec.dto;


import com.backend.api.mesa.spec.entity.Mesa;

public class MesaDTO {

    private String id;
    private int numero;

    public MesaDTO(Mesa mesa) {
        this.id = mesa.getId();
        this.numero = mesa.getNumero();
    }

    public MesaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
