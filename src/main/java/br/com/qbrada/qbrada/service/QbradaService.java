package br.com.qbrada.qbrada.service;

import br.com.qbrada.qbrada.repository.QbradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QbradaService {

    @Autowired
    private QbradaRepository repository;
}
