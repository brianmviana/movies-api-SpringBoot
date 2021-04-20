package dev.brianmviana.api.movies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.query.UsuarioRepositoryQuery;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>, UsuarioRepositoryQuery {

	public Usuario findByLogin(String login);
	
}
