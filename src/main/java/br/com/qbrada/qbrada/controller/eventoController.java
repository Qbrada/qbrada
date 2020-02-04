package br.com.qbrada.qbrada.controller;

import br.com.qbrada.qbrada.model.Evento;
import br.com.qbrada.qbrada.service.eventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class eventoController {

    @Autowired
    private eventoService service;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/verEventos")
    public String procurarEventos() {
        return "procurarEventos";
    }

    @GetMapping("/cadastro")
    public String cadastrar() {
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEvento(Evento qbrada) {
        service.cadastrarEvento(qbrada);
        return "listarEventos";
    }

    @GetMapping("/buscarNome")
    public ModelAndView listarEventos() {
        ModelAndView pagina = new ModelAndView("listarEventos");
        Iterable<Evento> eventos = service.listarEventos();
        pagina.addObject("eventos", eventos);
        return pagina;
    }

    @PostMapping("/listarEvento")
    public String buscarEventos() {
        return "listarEvento";
    }
    @GetMapping("/busca")
    public String buscaNome(){
        return "mostrarEventos";
    }


}
