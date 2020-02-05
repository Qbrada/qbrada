package br.com.qbrada.qbrada.controller;

import br.com.qbrada.qbrada.model.Qbrada;
import br.com.qbrada.qbrada.service.QbradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Controller
public class QbradaController {

    @Autowired
    private QbradaService service;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastrar() {
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEvento(@Valid Qbrada qbrada) {
        service.cadastrarEvento(qbrada);
        return "cadastro";
    }

    @ExceptionHandler({BindException.class})
    public String tratarErrosValidacao(BindException exception, Model model){
        System.out.println(exception);

        model.addAttribute("erros", exception.getFieldErrors());
        return "cadastro";
    }

    @GetMapping("/eventos")
    public ModelAndView listarEventos() {
        ModelAndView pagina = new ModelAndView("listarEventos");
        Iterable<Qbrada> eventos = service.listarEventos();
        pagina.addObject("eventos", eventos);
        return pagina;
    }

    @GetMapping("/buscar")
    public String buscaNome(){
        return "buscaNome";
    }

    @GetMapping("evento")
    public String buscarNome(@RequestParam("nome") String nome, Model model) {
        Qbrada evento = service.buscarNome(nome);
        if(evento != null){
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else{
            model.addAttribute("msg", "O evento " + nome + " não foi encontrado!! procure novamente");
            return "buscaNome";
        }
    }

    @GetMapping("evento/{nome}")
    public String buscarNomePagina(@PathVariable("nome") String nome, Model model) {
        Qbrada evento = service.buscarNome(nome);
        if(evento != null){
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else{
            model.addAttribute("msg", "O evento " + nome + " não foi encontrado!! procure novamente");
            return "buscaNome";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirFilme(@PathVariable("id") long id, Model model){
        service.excluirEvento(id);
        model.addAttribute("msg", "Um item foi excluido");
        return "listarEventos";
    }

    @GetMapping("/desativar/{id}")
    public String desativar(@PathVariable("id") long id, Model model){
        service.desativar(id);
        model.addAttribute("msg", "Um item foi desativado");
        return "listarEventos";
    }
}
