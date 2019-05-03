package com.tdd.contas.test;


import com.tdd.contas.config.core.FunctionalTest;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.repositories.PrestadorRepository;
import com.tdd.contas.environments.EnvPrestador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.tdd.contas.domain.enums.TEspecialidade.CLINICO_GERAL;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@FunctionalTest
class PrestadorTest {

    @Autowired
    private EnvPrestador envPrestador;

    @Autowired
    private PrestadorRepository repository;

    @BeforeEach
    void setup() {
        envPrestador.setUmPrestador();
    }

    @Test
    void happyDay() {
        assertEquals("Existe um Prestador Cadastrado", 1, pesquisaQuantidadePrestadores());
    }

    @Test
    void validarEspecialidade() {
        Prestador prestador = repository.findAll().get(0);
        assertEquals(CLINICO_GERAL, prestador.getEspecialidade());
    }

    private int pesquisaQuantidadePrestadores() {
        return repository.findAll().size();
    }

}
