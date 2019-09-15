package com.backend.api.pedido.service;

import com.backend.api.pedido.spec.IPedido;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoService {

    @Autowired
    private IPedido iPedido;

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<PedidoDTO> buscarPedidos() {
        return iPedido.buscarPedidos();
    }

    @PostMapping("/cadastrar")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirPedido(@RequestBody PedidoDTO pedidoDTO) {
        iPedido.inserirPedido(pedidoDTO);
    }
}
