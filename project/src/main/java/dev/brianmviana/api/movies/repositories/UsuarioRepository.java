package dev.brianmviana.api.movies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
	
}
