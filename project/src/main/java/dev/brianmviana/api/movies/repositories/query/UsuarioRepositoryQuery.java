package dev.brianmviana.api.movies.repositories.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.filters.UsuarioFilter;

public interface UsuarioRepositoryQuery {

	public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);
	
}
