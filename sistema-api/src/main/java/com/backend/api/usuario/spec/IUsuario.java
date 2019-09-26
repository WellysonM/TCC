package com.backend.api.usuario.spec;

import com.backend.api.usuario.spec.dto.UsuarioDTO;

import java.util.List;

public interface IUsuario {

    List<UsuarioDTO> buscarUsuarios();

    void removerUsuario(UsuarioDTO usuarioDTO);

    void inserirUsuario(UsuarioDTO usuarioDTO);

    void atualizarUsuario(UsuarioDTO usuarioDTO);
}

