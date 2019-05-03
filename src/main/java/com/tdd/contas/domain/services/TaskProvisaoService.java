package com.tdd.contas.domain.services;

import com.tdd.contas.domain.enums.StatusProvisao;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.models.TaskProvisao;
import com.tdd.contas.domain.repositories.TaskProvisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskProvisaoService {

    @Autowired
    private TaskProvisaoRepository repository;

    public TaskProvisao save(Date data, Peg peg, StatusProvisao status) {
        TaskProvisao build = TaskProvisao.builder()
                .data(data)
                .peg(peg)
                .status(status)
                .build();

        return repository.saveAndFlush(build);
    }
}
