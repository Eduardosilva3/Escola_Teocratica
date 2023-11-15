package com.designacoes.Escola.exception;

import org.springframework.http.HttpStatus;

public class DadosInvalidosException extends exception {

    public DadosInvalidosException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
