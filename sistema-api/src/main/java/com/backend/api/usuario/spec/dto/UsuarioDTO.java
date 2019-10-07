package com.backend.api.usuario.spec.dto;

import com.backend.api.cargo.spec.entity.Cargo;
import com.backend.api.usuario.spec.entity.Usuario;

public class UsuarioDTO {

    private String id;
    private String username;
    private String password;
    private String name;
    private boolean admin;
    private Cargo cargo;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.name = usuario.getName();
        this.admin = usuario.isAdmin();
        this.cargo = usuario.getCargo();

    }

    public UsuarioDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}