package com.designacoes.Escola.service;

import com.designacoes.Escola.domain.Designacao;
import com.designacoes.Escola.domain.Publicador;
import com.designacoes.Escola.domain.SemanaApostila;
import com.designacoes.Escola.dto.DesignacaoSemanaDto;
import com.designacoes.Escola.exception.DadosInvalidosException;
import com.designacoes.Escola.repository.ApostilaRepository;
import com.designacoes.Escola.repository.DesignacaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignacaoService {


    private final DesignacaoRepository repository;
    private final ApostilaRepository apostilaService;
    private final PublicadorService publicadorService;


    public DesignacaoService(DesignacaoRepository repository, ApostilaRepository apostilaService, PublicadorService publicadorService) {
        this.repository = repository;
        this.apostilaService = apostilaService;
        this.publicadorService = publicadorService;
    }

    public List<DesignacaoSemanaDto> retornarDesignacaoDaApstila(int mesInicial){
        List<SemanaApostila> semanaApostilas = apostilaService.findByMesInicial(mesInicial).orElse(null).getSemanaApostilas();
        List<DesignacaoSemanaDto> designacaos = new ArrayList<>();


        if(semanaApostilas == null){
            return designacaos;
        }

        semanaApostilas.stream().forEach(semana -> {
            List<Designacao> designacao = new ArrayList<>();

            repository.findBySemanaApostila(semana).forEach(designacao1 -> {
                designacao.add(designacao1);
            });

            designacaos.add(new DesignacaoSemanaDto(semana.getSemana(), designacao));


        });

        return designacaos;
    }

    public Designacao cadastrarDesignacao(int idDesigncao, int publicador, int ajudante){

        Designacao designacao = repository.findById(idDesigncao).orElseThrow(() -> new DadosInvalidosException("Designacao não encontrada"));

        Publicador publicador1 = publicadorService.buscarporId(publicador).orElseThrow(() -> new DadosInvalidosException("Publicador não encontrado"));
        Publicador ajudante1 = publicadorService.buscarporId(ajudante).orElseThrow(() -> new DadosInvalidosException("Ajudante não encontrado"));

        designacao.setPublicador(publicador1);
        designacao.setAjudante(ajudante1);

        return repository.save(designacao);

    }
}
