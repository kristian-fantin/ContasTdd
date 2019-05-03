package com.tdd.contas.test;

import com.tdd.contas.config.core.FunctionalTest;
import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.repositories.PegRepository;
import com.tdd.contas.domain.repositories.TaskProvisaoRepository;
import com.tdd.contas.domain.services.PegService;
import com.tdd.contas.environments.EnvTaskProvisao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@FunctionalTest
public class TaskProvisaoTest {

    @Autowired
    private TaskProvisaoRepository repository;

    @Autowired
    private EnvTaskProvisao envTaskProvisao;

    @Autowired
    private PegRepository pegRepository;

    @Autowired
    private PegService pegService;

    @BeforeEach
    public void setup() {
        envTaskProvisao.setUmaProvisao();
    }

    @Test
    void happyDay() {
        Peg peg = pegRepository.findAll().get(0);
        pegService.atualiza(peg, StatusPeg.PRONTO, "mudança de fase (status)");
        assertEquals("Existe uma Provisao", 1, pesquisaProvisoes());
    }

    @Test
    void naoDeveGerarProvisao() {
        Peg peg = pegRepository.findAll().get(0);
        pegService.atualiza(peg, StatusPeg.DIGITACAO, "mudança de fase (status)");
        assertEquals("Não deve existir Provisao", 0, pesquisaProvisoes());
    }

    private int pesquisaProvisoes() {
        return repository.findAll().size();
    }
}
