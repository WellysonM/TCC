package com.backend.api.usuario.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.entity.Pedido;
import com.backend.api.usuario.impl.bo.UsuarioBO;
import com.backend.api.usuario.spec.dto.UsuarioDTO;
import com.backend.api.usuario.spec.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoverUsuario {

    @Autowired
    private UsuarioBO usuarioBO;

    @Autowired
    private PedidoBO pedidoBO;

    public boolean removerUsuario(String usuarioId) {
        Usuario usuario = usuarioBO.buscarUsuarioPorId(usuarioId);
        if (PossoRemoverUsuario(usuario)) {
            usuarioBO.removerUsuario(usuario);
            return true;
        }
        return false;
    }

    private boolean PossoRemoverUsuario(Usuario usuario) {
        List<Pedido> pedidos = pedidoBO.buscarPedidos();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().getId().equals(usuario.getId())) {
                return false;
            }
        }
        return true;
    }
}
