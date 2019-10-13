package com.backend.api.usuario.service;

import com.backend.api.usuario.spec.IUsuario;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuario iUsuario;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @PostMapping("/usuario/inserir")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        iUsuario.inserirUsuario(usuarioDTO);
    }

    @GetMapping("/usuario/usuarioLogado")
    @CrossOrigin(origins = "http://localhost:8080")
    public UserDetails getUsuario(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @GetMapping("/usuarios/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<UsuarioDTO> buscarUsuarios() {
        return iUsuario.buscarUsuarios();
    }

    @GetMapping("/usuario/entrar")
    @CrossOrigin(origins = "http://localhost:8080")
    public Usuario authWithHttpServletRequest(HttpServletRequest request, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            request.login(usuarioDTO.getUsername(), usuarioDTO.getPassword());
            System.out.println(iUsuario.buscarUsuarioPorUsername(usuarioDTO));
            return iUsuario.buscarUsuarioPorUsername(usuarioDTO);
        } catch (ServletException e) {
            System.out.println("Error while login ->" + e);
            return null;
        }
    }
}