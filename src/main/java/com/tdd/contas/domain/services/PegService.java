package com.tdd.contas.domain.services;

import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.observers.ObserverPeg;
import com.tdd.contas.domain.repositories.PegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PegService {

    @Autowired
    private PegRepository repository;

    private List<ObserverPeg> observers = new ArrayList<>();

    public void subscribe(ObserverPeg observer) {
        observers.add(observer);
    }

    public Peg save(Date data, Long numero, Prestador prestador, String observacao, StatusPeg status) {
        Peg peg = repository.saveAndFlush(getPeg(data, numero, prestador, observacao, status));
        notifyObservers(peg);
        return peg;
    }

    private void notifyObservers(Peg peg) {
        observers.forEach(observer -> observer.update(peg));
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

    public void atualiza(Peg peg, StatusPeg novoStatus, String novaObservacao) {
        notifyObservers(getPegAtualizado(peg, novoStatus, novaObservacao));
    }

    private Peg getPegAtualizado(Peg peg, StatusPeg novoStatus, String novaObservacao) {
        peg.setObservacao(novaObservacao);
        peg.setStatus(novoStatus);
        return repository.saveAndFlush(peg);
    }
}
