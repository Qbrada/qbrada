package br.com.qbrada.qbrada.service;

import br.com.qbrada.qbrada.model.Qbrada;
import br.com.qbrada.qbrada.repository.QbradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QbradaService {

    @Autowired
    private QbradaRepository repository;

    public Qbrada cadastrarEvento(Qbrada evento) {
            evento.setAtivo(Boolean.TRUE);
            evento.setDataCriacao(LocalDate.now());
            return repository.save(evento);
    }

    public Iterable<Qbrada> listarEventos() {
        Iterable<Qbrada> eventos = repository.findAll();
        return eventos;
    }

    public Qbrada buscarNome(String nome) {
        Optional<Qbrada> eventos = repository.findByNome(nome);
        if (eventos.isPresent()) {
            return eventos.get();
        }
        return null;
    }

    public void excluirEvento(long id) {
        repository.deleteById(id);
    }

    public void desativar(long id) {
        Optional<Qbrada> eventos = repository.findById(id);
        if(eventos.get() != null){
            eventos.get().setAtivo(false);
            repository.save(eventos.get());
        }

    }
}
