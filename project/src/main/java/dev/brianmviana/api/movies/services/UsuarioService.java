package dev.brianmviana.api.movies.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.models.Voto;
import dev.brianmviana.api.movies.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Usuario> usuariosAtivos = new ArrayList<Usuario>();
		for (Usuario usuario : usuarios) {
			if(usuario.getStatus() && !usuario.isAdmin()) {
				usuario = hiddenPassword(usuario);
				usuariosAtivos.add(usuario);
			}
		}
		
		usuariosAtivos.sort(new Usuario());
		return usuariosAtivos;
	}
	
	public ResponseEntity<Usuario> getUsuarioById(long id) {
		Usuario usuario = usuarioRepository.findById(id);
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
		if(usuario.getVotos() == null) {
			usuario.setVotos(new HashSet<Voto>());
		}
		usuario = usuarioRepository.save(usuario);
		usuario = hiddenPassword(usuario);
		return usuario;
	}
	
	
	public Usuario updateUsuario(Usuario usuario) {
		return updateUsuario(usuario.getId(), usuario);
	}

	public Usuario updateUsuario(long id, Usuario usuario) {
		Usuario usuarioExist = usuarioRepository.findById(id);
		Usuario usuarioLoginExist = usuarioRepository.findByLogin(usuario.getLogin());
		if (usuarioExist == null) {
			// TODO return Response
			return null;
		}
		if(usuarioExist.getId() != usuarioLoginExist.getId()) {
			// TODO return Response
			return null;
		}

		usuario.setId(usuarioExist.getId());
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
