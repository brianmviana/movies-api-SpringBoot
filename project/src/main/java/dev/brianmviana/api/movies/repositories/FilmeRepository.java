package dev.brianmviana.api.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	Filme findById(long id);
	
}
