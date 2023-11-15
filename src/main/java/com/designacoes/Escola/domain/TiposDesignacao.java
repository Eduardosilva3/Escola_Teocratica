package com.designacoes.Escola.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "tipos_designacao")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiposDesignacao {

    @Id
    @Column(name = "id_tipo_designacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDesignacao;

    @Column(name = "titulo")
    private String titulo;


    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tiposDesignacao")
    @JsonIgnore
    private List<Designacao> designacao;
}
