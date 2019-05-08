package com.tdd.contas.environments;

import com.tdd.contas.domain.services.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdd.contas.domain.enums.TEspecialidade.CLINICO_GERAL;

@Component
public class EnvPrestador {

    @Autowired
    private PrestadorService service;

    public void setUmPrestador() {
        service.save("Prestador A", CLINICO_GERAL);
    }

    public void setPrestadorXyz() {
        service.save("Prestador XYZ", CLINICO_GERAL);
    }
}
