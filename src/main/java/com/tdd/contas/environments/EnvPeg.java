package com.tdd.contas.environments;

import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.repositories.PrestadorRepository;
import com.tdd.contas.domain.services.PegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EnvPeg {

    @Autowired
    private EnvPrestador envPrestador;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PegService service;

    public void setUmPeg() {
        envPrestador.setUmPrestador();
        Prestador prestador = prestadorRepository.findAll().get(0);

        service.save(
                new Date(),
                1234L,
                prestador,
                "Observacao 01",
                StatusPeg.DIGITACAO
        );
    }
}
