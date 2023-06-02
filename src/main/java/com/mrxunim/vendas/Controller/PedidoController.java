package com.mrxunim.vendas.Controller;

import com.mrxunim.vendas.Model.Pedido;
import com.mrxunim.vendas.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/listar")
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @PostMapping("/adicionar")
    public Pedido adicionarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
