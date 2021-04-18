package dev.brianmviana.api.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

}
