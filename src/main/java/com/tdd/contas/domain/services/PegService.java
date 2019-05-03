package com.tdd.contas.domain.services;

import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.repositories.PegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PegService {

    @Autowired
    private PegRepository repository;

    public Peg save(Date data, Long numero, Prestador prestador, String observacao, StatusPeg status) {
        return repository.saveAndFlush(getPeg(data, numero, prestador, observacao, status));
    }

    private Peg getPeg(Date data, Long numero, Prestador prestador, String observacao, StatusPeg status) {
        return Peg.builder()
                .data(data)
                .numero(numero)
                .prestador(prestador)
                .observacao(observacao)
                .status(status)
                .build();
    }
}
