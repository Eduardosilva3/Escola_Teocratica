package com.designacoes.Escola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publicador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicador")
    private int idPublicador;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "publicador")
    @JsonIgnore
    private List<Designacao> designacao;

    @OneToMany(mappedBy = "ajudante")
    @JsonIgnore
    private List<Designacao> ajudante;



}
