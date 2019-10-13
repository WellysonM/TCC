package com.backend.api.usuario.impl;

import com.backend.api.usuario.impl.usecase.*;
import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioImpl implements IUsuario {

    @Autowired
    private BuscarUsuario buscar;

    @Autowired
    private RemoverUsuario remover;

    @Autowired
    private InserirUsuario inserir;

    @Autowired
    private AtualizarUsuario atualizar;

    @Autowired
    private BuscarUsuarioPorUsername buscarUsuarioPorUsername;

    @Override
    public List<UsuarioDTO> buscarUsuarios() {
        return buscar.BuscarUsuario();
    }

    @Override
    public void removerUsuario(UsuarioDTO usuarioDTO) {
        remover.removerUsuario(usuarioDTO);
    }

    @Override
    public void inserirUsuario(UsuarioDTO usuarioDTO) {
        inserir.inserirUsuario(usuarioDTO);
    }

    @Override
    public void atualizarUsuario(UsuarioDTO usuarioDTO) {
        atualizar.atualizarUsuario(usuarioDTO);
    }

    @Override
    public Usuario buscarUsuarioPorUsername(UsuarioDTO usuarioDTO){
      return buscarUsuarioPorUsername.buscarUsuarioPorUsername(usuarioDTO);
    }
}
