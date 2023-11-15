package com.designacoes.Escola.service;

import com.designacoes.Escola.domain.Publicador;
import com.designacoes.Escola.dto.PublicadorDTO;
import com.designacoes.Escola.repository.PublicadorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PublicadorService {

    private final PublicadorRepository repository;

    public PublicadorService(PublicadorRepository repository) {
        this.repository = repository;
    }

    public Publicador cadastrarPublicador(Publicador publicador){
        return repository.save(publicador);
    }

    public List<Publicador> listarPublicadores(){
        return repository.findAll();
    }

    public Optional<Publicador> buscarporId(int id){
        return repository.findById(id);
    }

    public List<PublicadorDTO> listarPublicadoreOrdemUltimaDesignacao(){

        List<Publicador> publicadores = repository.findAll();
        List<PublicadorDTO> publicadorDTOs = new ArrayList<>();

        publicadores.stream().forEach(publicador -> {
            LocalDate ultimaDesignacao = publicador.getDesignacao().stream().map(designacao -> designacao.getSemanaApostila().getSemana()).max(LocalDate::compareTo).orElse(null);

            publicadorDTOs.add(new PublicadorDTO(publicador,ultimaDesignacao));
        });

        //Ordernar publicadores por data de ultima designacao sendo null primeiro e depois designacao mais antiga
        Comparator<PublicadorDTO> comparator = Comparator.comparing(PublicadorDTO::getUltimaDesignacao, Comparator.nullsFirst(Comparator.naturalOrder()));

        publicadorDTOs.sort(comparator);

        return publicadorDTOs;



    }
}
