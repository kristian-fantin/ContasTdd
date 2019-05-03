package com.tdd.contas.domain.services;

import com.tdd.contas.domain.models.HistoricoPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.repositories.HistoricoPegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoricoPegService {

    @Autowired
    private HistoricoPegRepository repository;

    public HistoricoPeg save(Date data, Peg peg, String observacao) {
        return repository.saveAndFlush(getHistorico(data, peg, observacao));
    }

    private HistoricoPeg getHistorico(Date data, Peg peg, String observacao) {
        return HistoricoPeg.builder()
                .data(data)
                .peg(peg)
                .observacao(observacao)
                .build();
    }
}
