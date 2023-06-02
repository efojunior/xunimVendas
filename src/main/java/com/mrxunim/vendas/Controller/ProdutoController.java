package com.mrxunim.vendas.Controller;

import com.mrxunim.vendas.Model.Produto;
import com.mrxunim.vendas.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping("/adicionar")
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
