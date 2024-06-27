package com.bancosystem.exception;

public class ContaNaoEncontradaException extends RuntimeException { // Could extend a more specific exception type
    public ContaNaoEncontradaException(Long id) {
        super("Conta com ID " + id + " não encontrada.");
    }
}