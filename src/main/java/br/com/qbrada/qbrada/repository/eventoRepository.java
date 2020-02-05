package br.com.qbrada.qbrada.repository;

import br.com.qbrada.qbrada.model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface eventoRepository extends CrudRepository<Evento, String> {

    @Query("select e from Evento e where e.nome like %?1%")
    List<Evento> findEventoByNome (String nome);
}

