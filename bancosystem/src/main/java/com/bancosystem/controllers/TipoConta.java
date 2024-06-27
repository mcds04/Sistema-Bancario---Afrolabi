package com.bancosystem.controllers;

import com.bancosystem.model.Cliente;

// TipoConta.java
public enum TipoConta {
    PAGAMENTO,
    CORRENTE
    // outros tipos de conta
}

// ContaPoupanca.java
class ContaPagamento extends Conta {
    public ContaPagamento(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo();
    }

    private double getSaldo() {
        return 0;
    }

    @Override
    public void realizarTransacao(double valor, Conta contaDestino) {
        try {
            if (valor <= getSaldo()) {
                sacar(valor);
                contaDestino.depositar(valor);
            } else {
                throw new SaldoInsuficienteException("Saldo insuficiente para a transação.");
            }
        } catch (SaldoInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
}
