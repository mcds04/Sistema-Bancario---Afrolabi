package com.bancosystem.controllers;

import com.bancosystem.model.Cliente;
import com.bancosystem.service.ClienteNotFoundException;
import com.bancosystem.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class BankingController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente novoCliente) {
        Cliente cliente = clienteService.criarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) throws ClienteNotFoundException {
        Cliente cliente = clienteService.atualizarCliente(clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) throws ClienteNotFoundException {
        Cliente cliente = null;
        try {
            cliente = clienteService.buscarClientePorId(id);
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(cliente);
    }
}
