package com.designacoes.Escola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "apostila")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Apostila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apostila")
    private int idApostila;

    @Column(name = "mes_inicial")
    private int mesInicial;

    @Column(name = "mes_final")
    private int mesFinal;

    @OneToMany(mappedBy = "apostila")
    @JsonIgnore
    private List<SemanaApostila> semanaApostilas;




}
