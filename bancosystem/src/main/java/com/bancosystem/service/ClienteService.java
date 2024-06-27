
package com.bancosystem.service;

import com.bancosystem.model.Categoria;
import com.bancosystem.model.Cliente;
import com.bancosystem.model.Conta;
import com.bancosystem.repository.ClienteRepository;
import com.bancosystem.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    public Cliente criarCliente(Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    public Cliente atualizarCliente(Cliente clienteAtualizado) throws ClienteNotFoundException {
        Cliente cliente = clienteRepository.findByCpf(clienteAtualizado.getCpf());
        if (cliente == null) {
            throw new ClienteNotFoundException("Cliente não encontrado.");
        }

        // Restante do seu código de atualização do cliente...

        return clienteRepository.save(cliente);
    }

    // Categoria com base na renda salarial

    private Categoria determinarCategoria(double rendaSalarial) {
        if (rendaSalarial < 1800) {
            return Categoria.Standard;
        } else if (rendaSalarial < 3200) {
            return Categoria.PlatinumBlack;
        } else if (rendaSalarial < 7000) {
            return Categoria.Gold;
        } else {
            return Categoria.PlatinumBlack;
        }
    }

    public Cliente buscarClientePorId(Long clienteId) throws ClienteNotFoundException {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado."));
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Conta criarConta(Long clienteId, Conta novaConta) throws ClienteNotFoundException {
        Cliente cliente = buscarClientePorId(clienteId);
        novaConta.setCliente(cliente);
        return contaRepository.save(novaConta);
    }
}
