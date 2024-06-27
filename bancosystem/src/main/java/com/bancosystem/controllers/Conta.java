package com.bancosystem.controllers;

import com.bancosystem.model.Cliente;

// Conta.java
public abstract class Conta {
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract double getSaldoDisponivel();

    public abstract void realizarTransacao(double valor, Conta contaDestino);

    protected void depositar(double valor) {
        saldo += valor;
    }

    protected void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= getSaldoDisponivel()) {
            saldo -= valor;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
    }
}
