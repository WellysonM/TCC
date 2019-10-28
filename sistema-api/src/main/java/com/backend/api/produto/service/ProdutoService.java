package com.backend.api.produto.service;

import com.backend.api.produto.impl.repository.ProdutoRepository;
import com.backend.api.produto.spec.IProduto;
import com.backend.api.produto.spec.dto.ProdutoDTO;
import com.backend.api.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private IProduto iProduto;

    @GetMapping("/produtos/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ProdutoDTO> buscarProdutos() {
        return iProduto.buscarProdutos();
    }

    @GetMapping("/produtos/all/{categoriaId}")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Produto> buscarClientesPorCategoria(@PathVariable("categoriaId") String categoriaId) {
        List<Produto> produtos = this.produtoRepository.findProdutosByCategoria_Id(categoriaId);
        return produtos;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/produto/atualizar"})
    @CrossOrigin(origins = "http://localhost:8080")
    public void atualizaProduto(@RequestBody ProdutoDTO produtoDTO) {
        iProduto.atualizarProduto(produtoDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/produto/remover/{produtoDTOId}"})
    @CrossOrigin(origins = "http://localhost:8080")
    public void removerProduto(@PathVariable(value = "produtoDTOId") String produtoDTOId) {
        iProduto.removerProduto(produtoDTOId);
    }

    @PostMapping("/produto/inserir")
    //@PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8080")
    public void inserirCliente(@RequestBody ProdutoDTO produtoDTO) {
        iProduto.inserirProduto(produtoDTO);
    }
}
