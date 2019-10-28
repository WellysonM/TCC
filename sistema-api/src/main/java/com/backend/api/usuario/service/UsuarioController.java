package com.backend.api.usuario.service;

import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuario iUsuario;

    @Autowired
    private UsuarioBO usuarioBO;

    private Usuario usuario = new Usuario();

    @PostMapping("/usuario/inserir")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        iUsuario.inserirUsuario(usuarioDTO);
    }

    @GetMapping("/usuarios/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<UsuarioDTO> buscarUsuarios() {
        return iUsuario.buscarUsuarios();
    }

    @PostMapping("/usuario/entrar")
    @CrossOrigin(origins = "http://localhost:8080")
    public Usuario authWithHttpServletRequest(HttpServletRequest request, @RequestBody UsuarioDTO usuarioDTO) {
        return validarLogin(request, usuarioDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/usuario/atualizar"})
    @CrossOrigin(origins = "http://localhost:8080")
    public void atualizaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        iUsuario.atualizarUsuario(usuarioDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/usuario/remover/{usuarioId}"})
    @CrossOrigin(origins = "http://localhost:8080")
    public void removerUsuario(@PathVariable(value = "usuarioId") String usuarioId) {
        iUsuario.removerUsuario(usuarioId);
    }

    @GetMapping("/usuario/sair")
    @CrossOrigin(origins = "http://localhost:8080")
    public void sairDoSistema() {
        usuario.setId(null);
        usuario.setUsername(null);
        usuario.setName(null);
        usuario.setPassword(null);
        usuario.setAdmin(false);
    }

    @GetMapping("/usuario/usuarioLogado")
    @CrossOrigin(origins = "http://localhost:8080")
    public Usuario getUsuarioLogado() {
        if (usuario.getId() != null) {
            return usuarioBO.buscarUsuarioPorId(usuario.getId());
        } else {
            return usuario;
        }
    }

    private Usuario validarLogin(HttpServletRequest request, UsuarioDTO usuarioDTO) {
        try {
            request.login(usuarioDTO.getUsername(), usuarioDTO.getPassword());
            usuario = iUsuario.buscarUsuarioPorUsername(usuarioDTO);
            return usuario;
        } catch (ServletException e) {
            System.out.println("Error while login ->" + e);
            return null;
        }
    }
}