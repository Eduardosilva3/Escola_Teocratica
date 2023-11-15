package com.designacoes.Escola.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "designacao")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Designacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "designacao_id")
    private int idDesignacao;

    @Column(name = "ponto_conselho")
    private String pontoConselho;

    @ManyToOne
    @JoinColumn(name = "id_publicador")
    private Publicador publicador;

    @ManyToOne
    @JoinColumn(name = "id_ajudante")
    private Publicador ajudante;

    @ManyToOne
    @JoinColumn(name = "id_semana")
    private SemanaApostila semanaApostila;

    @ManyToOne
    @JoinColumn(name = "id_tipo_designacao")
    private TiposDesignacao tiposDesignacao;


}
