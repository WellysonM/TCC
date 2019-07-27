package com.backend.api.usuario.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioControllerRouter {

    @RequestMapping("/entrar")
    public String entrar() {
        return "entrar";
    }

    @GetMapping("/cadastrar")
    public String menu() {
        return "cadastrar";
    }
}

