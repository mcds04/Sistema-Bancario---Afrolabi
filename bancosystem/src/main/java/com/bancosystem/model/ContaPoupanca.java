package com.bancosystem.model;

import javax.persistence.Entity;

@Entity
public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Cliente cliente, String numeroConta) {
        super(cliente, numeroConta);
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo();
    }

    @Override
    public void realizarTransacao(double valor, Conta contaDestino) {
        try {
            sacar(valor);
            contaDestino.depositar(valor);
        } catch (SaldoInsuficienteException e) {
            // Handle exception
        }
    }
}
