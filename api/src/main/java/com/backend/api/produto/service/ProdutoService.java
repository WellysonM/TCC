package com.backend.api.produto.service;

import com.backend.api.produto.impl.repository.ProdutoRepository;
import com.backend.api.produto.spec.IProduto;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private IProduto iProduto;

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ProdutoDTO> buscarClientes() {
        return iProduto.buscarProdutos();
    }

    @GetMapping("/produto/all/{categoriaId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Produto> buscarClientesPorCategoria(@PathVariable("categoriaId") String categoriaId) {
        List<Produto> produtos = this.produtoRepository.findProdutosByCategoria_Id(categoriaId);
        return produtos;
    }
    @PostMapping("/cadastrar")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCliente(@RequestBody ProdutoDTO produtoDTO) {
        iProduto.inserirProduto(produtoDTO);
    }
}
