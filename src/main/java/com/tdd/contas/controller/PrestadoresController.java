package com.tdd.contas.controller;

import com.tdd.contas.domain.models.Prestador;
import com.tdd.contas.domain.services.PrestadorService;
import io.swagger.annotations.Api;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "prestadoresController" })
@RestController
@RequestMapping("/prestadores")
public class PrestadoresController {

    @Autowired
    private PrestadorService service;

    @GetMapping
    public List<Prestador> getPrestadores(HttpServletRequest request) {
        return service.findAll();
    }

}
