package dev.brianmviana.api.movies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios(){
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		List<Usuario> usuariosAtivos = new ArrayList<Usuario>();
		for (Usuario usuario : usuarios) {
			if(usuario.getStatus()) { //TODO usuario is Admin()
				usuario = hiddenPassword(usuario);
				usuariosAtivos.add(usuario);
			}
		}
		
		usuariosAtivos.sort(new Usuario());
		return usuariosAtivos;
	}
	
	public ResponseEntity<Usuario> getUsuarioByLogin(String login) {
		Optional<Usuario> user = usuarioRepository.findByLogin(login);
		Usuario usuario = user.get();
		if(usuario != null && usuario.getStatus()) {
			usuario = hiddenPassword(usuario);
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByLogin(usuario.getLogin());
		Usuario usuarioExist = user.get();
		if (usuarioExist != null) {
			return usuarioExist;
		}
		
		// cria uma lista vazia caso o usuario não tenha nenhum voto
//		if(usuario.getVotos() == null) {
//			usuario.setVotos(new HashSet<Voto>());
//		}
		usuario = usuarioRepository.save(usuario);
		usuario = hiddenPassword(usuario);
		return usuario;
	}
	
	
	public Usuario updateUsuario(Usuario usuario) {
		return updateUsuario(usuario.getLogin(), usuario);
	}

	public Usuario updateUsuario(String login, Usuario usuario) {
		Optional<Usuario> usuarioExist = usuarioRepository.findByLogin(login);
		Optional<Usuario> usuarioLoginExist = usuarioRepository.findByLogin(usuario.getLogin());
		if (usuarioExist == null) {
			// TODO return Response
			return null;
		}
		if((usuarioLoginExist != null) && usuarioExist.get().getLogin() != usuarioLoginExist.get().getLogin()) {
			// TODO return Response
			return null;
		}

		usuario.setLogin(usuarioExist.get().getLogin());
		usuario = usuarioRepository.save(usuario);
		usuario = hiddenPassword(usuario);
		return usuario;
	}
	
	public Usuario deleteUsuario(Usuario usuario) {
		usuario.setStatus(false);
		usuarioRepository.save(usuario);
		hiddenPassword(usuario);
		return usuario;
	}
	
	private Usuario hiddenPassword(Usuario user) {
		user.setSenha("********");
		return user;
	}
	
}
