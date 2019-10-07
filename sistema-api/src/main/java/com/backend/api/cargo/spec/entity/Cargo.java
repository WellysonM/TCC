package com.backend.api.cargo.spec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categoria")
public class Cargo {

    @Id
    private String id;
    private String cargo;

    public Cargo() {
    }

    public Cargo(String id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}