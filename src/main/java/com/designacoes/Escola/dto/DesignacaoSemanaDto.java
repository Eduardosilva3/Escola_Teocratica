package com.designacoes.Escola.dto;

import com.designacoes.Escola.domain.Designacao;
import com.designacoes.Escola.domain.SemanaApostila;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignacaoSemanaDto {

    private LocalDate semanaApostila;
    private List<Designacao> designacao;
}
