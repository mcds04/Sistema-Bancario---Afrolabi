package com.bancosystem.controller;

import com.bancosystem.model.Cliente;
import com.bancosystem.model.Conta;
import com.bancosystem.service.ClienteNotFoundException;
import com.bancosystem.service.ClienteService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Getter
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente novoCliente) {
        Cliente cliente = clienteService.criarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PostMapping("/{clienteId}/contas")
    public ResponseEntity<Conta> criarConta(@PathVariable Long clienteId, @RequestBody Conta novaConta) {
        try {
            Conta conta = clienteService.criarConta(clienteId, novaConta);
            return ResponseEntity.status(HttpStatus.CREATED).body(conta);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
