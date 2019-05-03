package com.tdd.contas.environments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvHistoricoPeg {

    @Autowired
    private EnvPeg envPeg;

    public void setUmHistoricoPeg() {
        envPeg.setUmPeg();
    }


}
