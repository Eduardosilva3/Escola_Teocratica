package com.designacoes.Escola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "semana_apostila")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SemanaApostila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semana")
    private int idSemana;

    @Column(name = "semana")
    private LocalDate semana;

    @ManyToOne
    @JoinColumn(name = "id_apostila")
    private Apostila apostila;

    @OneToMany(mappedBy = "semanaApostila")
    @JsonIgnore
    private List<Designacao> designacao;

}
