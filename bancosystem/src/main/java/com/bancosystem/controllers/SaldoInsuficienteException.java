package com.bancosystem.controllers;

// SaldoInsuficienteException.java
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
