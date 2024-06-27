// ContaRepository.java
package com.bancosystem.repository;

import com.bancosystem.model.Cliente;
import com.bancosystem.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByCliente(Cliente cliente);
}