// ClienteRepository.java
package com.bancosystem.repository;

import com.bancosystem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}