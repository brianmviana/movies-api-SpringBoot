package dev.brianmviana.api.movies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.repositories.query.FilmeRepositoryQuery;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>, FilmeRepositoryQuery {
	
	List<Filme> findByNome(String nome);
	
}
