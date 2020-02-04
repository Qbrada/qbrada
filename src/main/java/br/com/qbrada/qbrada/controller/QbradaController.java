package br.com.qbrada.qbrada.controller;

import br.com.qbrada.qbrada.model.Qbrada;
import br.com.qbrada.qbrada.service.QbradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QbradaController {

    @Autowired
    private QbradaService service;

    @GetMapping("/cadastro")
    public String cadastrar() {
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEvento(Qbrada qbrada) {
        service.cadastrarEvento(qbrada);
        return "cadastro";
    }

}
