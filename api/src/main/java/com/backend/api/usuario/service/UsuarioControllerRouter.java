package com.backend.api.usuario.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsuarioControllerRouter {
    
    @RequestMapping("/entrar")
    public String entrar() {
        return "entrar";
    }

}

