package br.com.qbrada.qbrada.controller;

import br.com.qbrada.qbrada.service.QbradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QbradaController {

    @Autowired
    private QbradaService service;

}
