package br.com.qbrada.qbrada.repository;

import br.com.qbrada.qbrada.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface eventoRepository extends CrudRepository<Evento, String> {
    Iterable<Evento> findByNome(String nome);


}

