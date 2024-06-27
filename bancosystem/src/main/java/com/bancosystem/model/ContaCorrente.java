package com.bancosystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Cliente cliente, double limite) {
        super(cliente, null);
        this.limite = limite;
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + limite;
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
