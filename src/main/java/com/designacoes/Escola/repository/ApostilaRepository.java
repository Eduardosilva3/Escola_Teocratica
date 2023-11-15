package com.designacoes.Escola.repository;

import com.designacoes.Escola.domain.Apostila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApostilaRepository extends JpaRepository<Apostila, Integer> {

    Optional<Apostila> findByMesInicial (int mesInicial);
}
