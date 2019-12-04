package com.backend.api.mesa.spec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mesa")
public class Mesa {

    @Id
    private String id;
    private int numero;
    private String status;

    public Mesa() {
    }

    public Mesa(String id, int numero, String status) {
        this.id = id;
        this.numero = numero;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}