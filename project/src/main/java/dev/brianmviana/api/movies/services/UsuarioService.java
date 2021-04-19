package dev.brianmviana.api.movies.services;

import java.util.ArrayList;
import java.util.List;

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
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario != null && usuario.getStatus()) {
			usuario = hiddenPassword(usuario);
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		Usuario usuarioExist = usuarioRepository.findByLogin(usuario.getLogin());
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
		Usuario usuarioExist = usuarioRepository.findByLogin(login);
		Usuario usuarioLoginExist = usuarioRepository.findByLogin(usuario.getLogin());
		if (usuarioExist == null) {
			// TODO return Response
			return null;
		}
		if((usuarioLoginExist != null) && usuarioExist.getLogin() != usuarioLoginExist.getLogin()) {
			// TODO return Response
			return null;
		}

		usuario.setLogin(usuarioExist.getLogin());
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
