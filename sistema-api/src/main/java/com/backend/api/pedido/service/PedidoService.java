package com.backend.api.pedido.service;

import com.backend.api.pedido.spec.IPedido;
import com.backend.api.pedido.spec.dto.PedidoDTO;
import com.backend.api.pedido.spec.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoService {

    @Autowired
    private IPedido iPedido;

    @GetMapping("/pedidos/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<PedidoDTO> buscarPedidos() {
        return iPedido.buscarPedidos();
    }

    @GetMapping("/pedidos/finalizados")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<PedidoDTO> buscarTodosPedidosFinalizados() {
        return iPedido.buscarTodosPedidosFinalizados();
    }

    @GetMapping("/pedidos/espera")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<PedidoDTO> buscarTodosPedidosEspera() {
        return iPedido.buscarTodosPedidosEmEspera();
    }

    @GetMapping("/pedidos/{mesaId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<PedidoDTO> buscarPedidosPorStatusEMesaId(@PathVariable("mesaId") String mesaId) {
        return iPedido.buscarPedidosPorStatusEMesaId(mesaId);
    }

    @PostMapping("/pedido/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirPedido(@RequestBody PedidoDTO pedidoDTO) {
        iPedido.inserirPedido(pedidoDTO);
    }

    @PostMapping("/pedido/atualizar")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void atualizarPedido(@RequestBody List<PedidoDTO> pedidoDTOs) {
        iPedido.atualizarPedido(pedidoDTOs);
    }
}