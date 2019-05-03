package com.tdd.contas.test;

import com.tdd.contas.config.core.FunctionalTest;
import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.repositories.HistoricoPegRepository;
import com.tdd.contas.domain.repositories.PegRepository;
import com.tdd.contas.domain.services.PegService;
import com.tdd.contas.environments.EnvPeg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.tdd.contas.domain.enums.StatusPeg.DIGITACAO;
import static com.tdd.contas.domain.enums.StatusPeg.PRONTO;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@FunctionalTest
class PegTest {

    @Autowired
    private PegService service;

    @Autowired
    private PegRepository repository;

    @Autowired
    private HistoricoPegRepository historicoPegRepository;

    @Autowired
    private EnvPeg envPeg;

    @BeforeEach
    public void setup() {
        envPeg.setUmPeg();
    }

    @Test
    void happyDay() {
        assertEquals("Existe 1 PEG", 1, pesquisaPegs());
    }

    @Test
    void validaStatus() {
        Peg peg = repository.findAll().get(0);

        assertEquals(DIGITACAO, peg.getStatus());
    }

    @Test
    void alteraStatusPeg() {
        Peg peg = repository.findAll().get(0);
        service.atualiza(peg, StatusPeg.PRONTO, "mudança de fase (status)");
        assertEquals(PRONTO, peg.getStatus());

        assertEquals("Existem 2 históricos do peg", 2, pesquisaHistorico());
    }

    private int pesquisaHistorico() {
        return historicoPegRepository.findAll().size();
    }

    private int pesquisaPegs() {
        return repository.findAll().size();
    }
}
