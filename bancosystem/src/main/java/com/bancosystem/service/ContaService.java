package com.bancosystem.service;

import com.bancosystem.controllers.TipoConta;
import com.bancosystem.exception.ContaNaoEncontradaException;
import com.bancosystem.model.Cliente;
import com.bancosystem.model.Conta;
import com.bancosystem.model.ContaCorrente;
import com.bancosystem.model.ContaPoupanca;
import com.bancosystem.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository contaRepository;
    private final ClienteService clienteService;

    @Transactional
    public Conta criarConta(Long clienteId, TipoConta tipoConta) {
        Cliente cliente = null;
        try {
            cliente = clienteService.buscarClientePorId(clienteId);
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e);
        }

        Conta conta;
        if (tipoConta == TipoConta.CORRENTE) {
            conta = new ContaCorrente(cliente, cliente.getRendaSalarial() * 0.1);
        } else if (tipoConta == TipoConta.PAGAMENTO) {
            conta = new ContaPoupanca(cliente, null); //  ContaPoupanca precisa de numeroConta
        } else {
            throw new IllegalArgumentException("Tipo de conta inválido");
        }

        return contaRepository.save(conta);
    }

    @Transactional
    public void realizarTransacao(Long contaOrigemId, Long contaDestinoId, double valor) throws SaldoInsuficienteException {
        Conta contaOrigem = buscarContaPorId(contaOrigemId);
        Conta contaDestino = buscarContaPorId(contaDestinoId);

        if (contaOrigem instanceof ContaCorrente contaCorrenteOrigem) {
            if (valor > contaCorrenteOrigem.getSaldoDisponivel()) {
                throw new SaldoInsuficienteException("Saldo insuficiente na conta de origem.");
            }
        } else if (contaOrigem instanceof ContaPoupanca contaPoupancaOrigem) {
            if (valor > contaPoupancaOrigem.getSaldo()) {
                throw new SaldoInsuficienteException("Saldo insuficiente na conta de origem.");
            }
        }

        contaOrigem.realizarTransacao(valor, contaDestino);
        contaRepository.saveAll(List.of(contaOrigem, contaDestino));
    }

    public double consultarSaldo(Long contaId) {
        Conta conta = buscarContaPorId(contaId);
        return conta.getSaldo();
    }

    private Conta buscarContaPorId(Long contaId) {
        return contaRepository.findById(contaId)
                .orElseThrow(() -> new ContaNaoEncontradaException(contaId));
    }
}
