package com.backend.api.produto.service;

import com.backend.api.produto.spec.IProduto;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoService {

    @Autowired
    private IProduto iProduto;

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ProdutoDTO> buscarClientes() {
        return iProduto.buscarProdutos();
    }

    @PostMapping("/cadastrar")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCliente(@RequestBody ProdutoDTO produtoDTO) {
        iProduto.inserirProduto(produtoDTO);
    }

}
