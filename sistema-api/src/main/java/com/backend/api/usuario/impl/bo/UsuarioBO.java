package com.backend.api.usuario.impl.bo;

import com.backend.api.usuario.impl.repository.UsuarioRepository;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioBO {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll(Sort.by("nome").ascending());
    }

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id).get();
    }

    public void removerUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
