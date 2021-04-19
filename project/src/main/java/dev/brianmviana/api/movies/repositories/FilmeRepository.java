package dev.brianmviana.api.movies.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	Optional<Filme> findById(Long id);
	
	List<Filme> findByNome(String nome);
	
}
