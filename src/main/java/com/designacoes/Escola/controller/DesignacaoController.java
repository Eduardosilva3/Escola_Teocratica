package com.designacoes.Escola.controller;

import com.designacoes.Escola.domain.Designacao;
import com.designacoes.Escola.dto.DesignacaoSemanaDto;
import com.designacoes.Escola.dto.PublicadorDTO;
import com.designacoes.Escola.service.DesignacaoService;
import com.designacoes.Escola.service.PublicadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DesignacaoController {


    private final DesignacaoService service;

    private final PublicadorService publicadorService;


    public DesignacaoController(DesignacaoService service, PublicadorService publicadorService) {
        this.service = service;
        this.publicadorService = publicadorService;
    }

    @GetMapping("/designacao")
    public List<DesignacaoSemanaDto> retornarDesignacaoDaApstila(@RequestParam int mes){
        return service.retornarDesignacaoDaApstila(mes);
    }

    @GetMapping("/designacao/cadastrar")
    public ResponseEntity<String> cadastrarDesignacao(@RequestParam int designacao, @RequestParam int publicador, @RequestParam int ajudante){
        Designacao designacao1 = service.cadastrarDesignacao(designacao, publicador, ajudante);

        if(designacao1 != null){
            return ResponseEntity.ok("Designacao cadastrada com sucesso");
        }

        return ResponseEntity.badRequest().body("Erro ao cadastrar designacao");


    }

    @GetMapping("/designacao/tempo")
    public ResponseEntity<List<PublicadorDTO>> retornarTempoDesignacao(){
        return ResponseEntity.ok(publicadorService.listarPublicadoreOrdemUltimaDesignacao());
    }

}
