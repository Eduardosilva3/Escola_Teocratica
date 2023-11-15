package com.designacoes.Escola.exception;

import org.springframework.http.HttpStatus;

public abstract class exception extends RuntimeException{

    protected exception() {
    }

    protected exception(String msg) {
        super(msg);
    }

    public abstract HttpStatus getStatus();
}
