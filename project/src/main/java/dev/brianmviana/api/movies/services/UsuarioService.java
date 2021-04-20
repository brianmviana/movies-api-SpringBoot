package dev.brianmviana.api.movies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.UsuarioRepository;
import dev.brianmviana.api.movies.resouces.UsuarioResource;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios(){
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		List<Usuario> usuariosAtivos = new ArrayList<Usuario>();
		
		for (Usuario usuario : usuarios) {
			boolean isAdmin = usuario.getRoles().stream().filter(role -> ("ROLE_ADMIN").equals(role.getNomeRole())).findAny().orElse(null) != null;
			if(usuario.getStatus() && !isAdmin) {
				hiddenPassword(usuario);
				usuario.add(linkTo(methodOn(UsuarioResource.class).getUsuario(usuario.getLogin())).withSelfRel());
				usuariosAtivos.add(usuario);
			}
		}
		
		usuariosAtivos.sort(new Usuario());
		return usuariosAtivos;
	}
	
	public Usuario getUsuarioByLogin(String login) {
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario != null) {
			if(usuario.getStatus()) {
				hiddenPassword(usuario);
				usuario.add(linkTo(methodOn(UsuarioResource.class).listarTodosUsuariosAtivos()).withRel("Lista de Usuarios ativos"));
				return usuario;				
			}
		} 
		return null;
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		Usuario usuarioExist = usuarioRepository.findByLogin(usuario.getLogin());
		
		if (usuarioExist != null) {
			return usuarioExist;
		}
		
		usuario = usuarioRepository.save(usuario);
		hiddenPassword(usuario);
		return usuario;
	}
	
	
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Verificar o usuario atual logado
		return updateUsuario(usuario.getLogin(), usuario);
	}

	public Usuario updateUsuario(String login, Usuario usuario) {
		// TODO Verificar o usuario atual logado
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
		hiddenPassword(usuario);
		return usuario;
	}
	
	public void deleteUsuario(String login) {
		// TODO Verificar o usuario atual logado
		Usuario usuario = getUsuarioByLogin(login);
		usuario.setStatus(false);
		usuarioRepository.save(usuario);
	}
	
	private void hiddenPassword(Usuario user) {
		user.setSenha("********");
	}
	
}
