package com.bancosystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String numeroConta;

    public Conta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Conta(Cliente cliente, String numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
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

