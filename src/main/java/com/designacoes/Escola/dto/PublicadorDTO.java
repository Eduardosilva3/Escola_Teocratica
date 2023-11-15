package com.designacoes.Escola.dto;

import com.designacoes.Escola.domain.Publicador;

import java.time.LocalDate;

public class PublicadorDTO {

    private Publicador publicador;
    private LocalDate ultimaDesignacao;

    public PublicadorDTO(Publicador publicador, LocalDate ultimaDesignacao) {
        this.publicador = publicador;
        this.ultimaDesignacao = ultimaDesignacao;
    }

    public Publicador getPublicador() {
        return publicador;
    }

    public void setPublicador(Publicador publicador) {
        this.publicador = publicador;
    }

    public LocalDate getUltimaDesignacao() {
        return ultimaDesignacao;
    }

    public void setUltimaDesignacao(LocalDate ultimaDesignacao) {
        this.ultimaDesignacao = ultimaDesignacao;
    }
}
