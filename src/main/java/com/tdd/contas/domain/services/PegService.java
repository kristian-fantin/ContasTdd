package com.tdd.contas.domain.services;

import com.tdd.contas.domain.enums.StatusPeg;
import com.tdd.contas.domain.models.Peg;
import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.repositories.PegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.tdd.contas.domain.enums.StatusProvisao.ABERTO;

@Service
public class PegService {

    @Autowired
    private PegRepository repository;

    @Autowired
    private HistoricoPegService historicoPegService;

    @Autowired
    private TaskProvisaoService taskProvisaoService;

    public Peg save(Date data, Long numero, Prestador prestador, String observacao, StatusPeg status) {
        Peg peg = repository.saveAndFlush(getPeg(data, numero, prestador, observacao, status));
        historicoPegService.save(data, peg, peg.getObservacao());
        return peg;
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
        peg.setObservacao(novaObservacao);
        peg.setStatus(novoStatus);

        Peg pegAtualizado = repository.saveAndFlush(peg);
        historicoPegService.save(new Date(), pegAtualizado, pegAtualizado.getObservacao());
        if (novoStatus.equals(StatusPeg.PRONTO)) {
            taskProvisaoService.save(new Date(), pegAtualizado, ABERTO);
        }
    }
}
