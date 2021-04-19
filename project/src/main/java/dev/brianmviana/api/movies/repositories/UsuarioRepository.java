package dev.brianmviana.api.movies.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	public Optional<Usuario> findByLogin(String login);
	
}
