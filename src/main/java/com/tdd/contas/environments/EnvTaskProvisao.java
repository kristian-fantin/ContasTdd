package com.tdd.contas.environments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvTaskProvisao {

    @Autowired
    private EnvPeg envPeg;

    public void setUmaProvisao() {
        envPeg.setUmPeg();
    }
}
