package br.com.qbrada.qbrada.repository;

import br.com.qbrada.qbrada.model.Qbrada;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QbradaRepository extends CrudRepository<Qbrada, String> {

    Optional<Qbrada> findByNome(String nome);
}
