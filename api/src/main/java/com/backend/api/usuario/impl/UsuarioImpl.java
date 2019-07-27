package com.backend.api.usuario.impl;

import com.backend.api.usuario.impl.usecase.AtualizarUsuario;
import com.backend.api.usuario.impl.usecase.BuscarUsuario;
import com.backend.api.usuario.impl.usecase.InserirUsuario;
import com.backend.api.usuario.impl.usecase.RemoverUsuario;
import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
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
}
