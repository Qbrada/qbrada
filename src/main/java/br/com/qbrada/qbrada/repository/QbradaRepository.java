package br.com.qbrada.qbrada.repository;

import br.com.qbrada.qbrada.model.Qbrada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QbradaRepository extends CrudRepository<Qbrada, Long> {

    Optional<Qbrada> findByNome(String nome);

    @Override
    @Query("select f from Qbrada f where f.ativo=true")
    List<Qbrada> findAll();
}
