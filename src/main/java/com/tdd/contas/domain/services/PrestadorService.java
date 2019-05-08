package com.tdd.contas.domain.services;

import com.tdd.contas.domain.enums.TEspecialidade;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.repositories.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadorService {

    @Autowired
    private PrestadorRepository repository;

    public Prestador save(String nome, TEspecialidade especialidade) {
        return repository.saveAndFlush(getPrestador(nome, especialidade));
    }

    private Prestador getPrestador(String nome, TEspecialidade especialidade) {
        return Prestador.builder()
                .nome(nome)
                .especialidade(especialidade)
                .build();
    }

    public List<Prestador> findAll() {
        return repository.findAll();
    }
}
