package com.tdd.contas.test;

import com.tdd.contas.config.core.FunctionalTest;
import com.tdd.contas.domain.repositories.HistoricoPegRepository;
import com.tdd.contas.environments.EnvHistoricoPeg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@FunctionalTest
public class HistoricoPegTest {

    @Autowired
    private EnvHistoricoPeg envHistoricoPeg;

    @Autowired
    private HistoricoPegRepository repository;

    @Test
    void happyDay() {
        envHistoricoPeg.setUmHistoricoPeg();
        assertEquals("Existe 1 histórico de peg", 1, pesquisaHistorico());
    }

    private int pesquisaHistorico() {
        return repository.findAll().size();
    }
}
