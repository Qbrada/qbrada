package br.com.qbrada.qbrada.service;

import br.com.qbrada.qbrada.model.Evento;
import br.com.qbrada.qbrada.repository.eventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class eventoService {

    @Autowired
    private eventoRepository repository;

    public Evento cadastrarEvento(Evento evento) {
        evento.setAtivo(Boolean.TRUE);
        evento.setDataCriacao(LocalDate.now());
        return repository.save(evento);
    }

    public Iterable<Evento> retornarPorNome(String nome){
        return repository.findByNome(nome);
    }


    public Iterable<Evento> listarEventos() {
        Iterable<Evento> eventos = repository.findAll();
        return eventos;
    }

}