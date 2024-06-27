package com.bancosystem.service;

public class ContaNotFoundExceptionImpl extends RuntimeException {
    public ContaNotFoundExceptionImpl(String s) {
        super(s);
    }
}
