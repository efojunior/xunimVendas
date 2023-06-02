package com.mrxunim.vendas.Repository;

import com.mrxunim.vendas.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByNome(String nome); // Verifica se existe um cliente com o nome passado

    List<Cliente> findByNome(String nome); // Retorna uma lista de clientes com o nome passado

    void deleteByNome(String nome);
}

