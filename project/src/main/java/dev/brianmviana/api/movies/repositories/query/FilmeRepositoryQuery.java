package dev.brianmviana.api.movies.repositories.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.repositories.filters.FilmeFilter;

public interface FilmeRepositoryQuery {

	public Page<Filme> filtrar(FilmeFilter filmeFilter, Pageable pageable);
	
}
