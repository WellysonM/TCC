package com.backend.api.produto.impl.usecase;

import com.backend.api.pedido.impl.bo.PedidoBO;
import com.backend.api.pedido.spec.entity.Pedido;
import com.backend.api.produto.impl.bo.ProdutoBO;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoverProduto {

    @Autowired
    private ProdutoBO produtoBO;

    @Autowired
    private PedidoBO pedidoBO;

    public void RemoverProduto(String produtoDTOId) {
        Produto produto = produtoBO.buscarProdutoPorId(produtoDTOId);
        if (PossoRemoverProduto(produto)) {
            produtoBO.removerProduto(produto);
        }
    }

    private boolean PossoRemoverProduto(Produto produto) {
        List<Pedido> pedidos = pedidoBO.buscarPedidos();
        for (Pedido pedido : pedidos) {
            for (Produto produtoPedido : pedido.getProdutos()) {
                if (produtoPedido.getId().equals(produto.getId())) {
                    return false;
                }
            }
        }
        return true;
    }
}