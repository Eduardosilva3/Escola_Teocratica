package com.designacoes.Escola.repository;

import com.designacoes.Escola.domain.Designacao;
import com.designacoes.Escola.domain.SemanaApostila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignacaoRepository extends JpaRepository<Designacao, Integer> {

    List<Designacao> findBySemanaApostila(SemanaApostila idSemana);

}
