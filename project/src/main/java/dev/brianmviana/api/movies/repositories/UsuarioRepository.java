package dev.brianmviana.api.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.brianmviana.api.movies.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findById(long id);

	Usuario findByLogin(String login);
	
}
