package com.tdd.contas.config;

import com.tdd.contas.domain.services.HistoricoPegService;
import com.tdd.contas.domain.services.PegService;
import com.tdd.contas.domain.services.TaskProvisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PegService pegService;

    @Autowired
    private HistoricoPegService historicoPegService;

    @Autowired
    private TaskProvisaoService taskProvisaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pegService.subscribe(historicoPegService);
        pegService.subscribe(taskProvisaoService);
    }
}
