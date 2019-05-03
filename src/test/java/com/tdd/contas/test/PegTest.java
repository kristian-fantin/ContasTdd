package com.tdd.contas.test;

import com.tdd.contas.config.core.FunctionalTest;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.repositories.PegRepository;
import com.tdd.contas.environments.EnvPeg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.tdd.contas.domain.enums.StatusPeg.DIGITACAO;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@FunctionalTest
class PegTest {

    @Autowired
    private PegRepository repository;

    @Autowired
    private EnvPeg envPeg;

    @Test
    void happyDay() {
        envPeg.setUmPeg();
        assertEquals("Existe 1 PEG", 1, pesquisaPegs());
    }

    @Test
    void validarStatus() {
        envPeg.setUmPeg();
        Peg peg = repository.findAll().get(0);

        assertEquals(DIGITACAO, peg.getStatus());
    }

    private int pesquisaPegs() {
        return repository.findAll().size();
    }
}
