package com.designacoes.Escola.controller;

import com.designacoes.Escola.domain.Publicador;
import com.designacoes.Escola.service.PublicadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class PublicadorController {


    private final PublicadorService service;

    public PublicadorController(PublicadorService service) {
        this.service = service;
    }

    @PostMapping("/publicador")
    public ResponseEntity<String> cadastrarPublicador(@RequestBody Publicador publicador){

        Publicador publicadorRetorno = service.cadastrarPublicador(publicador);

        if(publicadorRetorno != null){
            return ResponseEntity.ok("Publicador cadastrado com sucesso");
        }

        return ResponseEntity.badRequest().body("Erro ao cadastrar publicador");

    }

    @GetMapping("/publicador")
    public ResponseEntity<List<Publicador>> listarPublicadores(){
        return ResponseEntity.ok(service.listarPublicadores());
    }

}
