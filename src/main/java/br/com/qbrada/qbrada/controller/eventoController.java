package br.com.qbrada.qbrada.controller;

import br.com.qbrada.qbrada.model.Evento;
import br.com.qbrada.qbrada.repository.eventoRepository;
import br.com.qbrada.qbrada.service.eventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class eventoController {

    @Autowired
    private eventoService service;
    @Autowired
    private eventoRepository repository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastrar() {
        return "cadastro";
    }
    @GetMapping("/listarEventos")
    public String mostrarEvento() {
        return "listarEvento";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEvento(Evento evento) {
        service.cadastrarEvento(evento);
        return "listarEventos";
    }
    @GetMapping("/verEventos")
    public String procurarEventos() {
        return "procurarEventos";
    }

    @PostMapping("/listarEvento")
    public String buscarEventos(@ModelAttribute Evento evento, Model model) {
        List<String> eventos = new ArrayList<>();
        eventos.add(String.valueOf(service.buscarNome(evento)));
        model.addAttribute("eventos", evento);
        return "listarEventoPorNome";

    }

    public ModelAndView listarEventos() {
        ModelAndView pagina = new ModelAndView("listarEventos");
        Iterable<Evento> eventos = service.listarEventos();
        pagina.addObject("eventos", eventos);
        return pagina;
    }
    @PostMapping("**/pesquisarevento")
    public ModelAndView pesquisa(@RequestParam ("nomepesquisa") String nomepesquisa ) {
        ModelAndView mdv = new ModelAndView("listarEventos");
        mdv.addObject("eventos", repository.findEventoByNome(nomepesquisa));
        return mdv;

    }



}
