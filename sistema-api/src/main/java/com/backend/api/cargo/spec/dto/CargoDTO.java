package com.backend.api.cargo.spec.dto;


import com.backend.api.cargo.spec.entity.Cargo;

public class CargoDTO {

    private String id;
    private String cargo;

    public CargoDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.cargo = cargo.getCargo();
    }

    public CargoDTO() {
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
