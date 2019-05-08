package com.tdd.contas.controller;

import com.tdd.contas.environments.EnvHistoricoPeg;
import com.tdd.contas.environments.EnvPrestador;
import io.swagger.annotations.Api;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "harnessController" })
@RestController
@RequestMapping("/harness")
public class HarnessController {

    @Autowired
    private EnvHistoricoPeg envHistoricoPeg;

    @Autowired
    private EnvPrestador envPrestador;

    @PostMapping
    public void loadHistoricoPeg(HttpServletRequest request) {
        envHistoricoPeg.setUmHistoricoPeg();
    }

    @PostMapping(value = "/prestadores")
    public void loadPrestadorXyz(HttpServletRequest request) {
        envPrestador.setPrestadorXyz();
    }

}
