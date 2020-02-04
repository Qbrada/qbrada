package br.com.qbrada.qbrada.service;

import br.com.qbrada.qbrada.model.Qbrada;
import br.com.qbrada.qbrada.repository.QbradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class QbradaService {

    @Autowired
    private QbradaRepository repository;

    public Qbrada cadastrarEvento(Qbrada evento) {
        evento.setAtivo(Boolean.TRUE);
        evento.setDataCriacao(LocalDate.now());
        return repository.save(evento);
    }
}
