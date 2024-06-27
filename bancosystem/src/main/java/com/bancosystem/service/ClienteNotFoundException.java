package com.bancosystem.service;

import com.bancosystem.model.Cliente;

public class ClienteNotFoundException extends Throwable {

    public ClienteNotFoundException(String s) {
    }

    public void meuMetodo() throws com.bancosystem.controllers.ClienteNotFoundException {
        // Alguma operação que pode lançar ClienteNotFoundException
        // Por exemplo, buscar um cliente pelo ID
        Cliente cliente = buscarClientePorId(123L);
    }

    public Cliente buscarClientePorId(Long clienteId) throws com.bancosystem.controllers.ClienteNotFoundException {
        // Lógica para buscar o cliente por ID
        // Se o cliente não for encontrado, lance a exceção
        throw new com.bancosystem.controllers.ClienteNotFoundException("Cliente não encontrado com ID: " + clienteId);
    }
}
