package com.mrxunim.vendas.Controller;

import com.mrxunim.vendas.Model.Cliente;
import com.mrxunim.vendas.Repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente) {
        String nomeCliente = cliente.getNome();
        if (clienteRepository.existsByNome(nomeCliente)) {
            return ResponseEntity.badRequest().body("Cliente já existe!");
        }
        clienteRepository.save(cliente);
        return ok("Cliente adicionado com sucesso!");
    }

    @DeleteMapping("/deletar/id/{id}")
    public ResponseEntity<String> deletarClienteId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            clienteRepository.delete(cliente);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Cliente não existe");
        }
    }
    @DeleteMapping("/deletar/nome/{nome}")
    @Transactional
    public ResponseEntity<String> deletarClienteNome(@PathVariable String nome) {
        List<Cliente> clientes = clienteRepository.findByNome(nome);
        if (!nome.isEmpty()) {
            clienteRepository.deleteByNome(nome);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Cliente não existe");
        }
    }
}
