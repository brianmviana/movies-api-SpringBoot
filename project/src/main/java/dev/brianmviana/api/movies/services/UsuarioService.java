package dev.brianmviana.api.movies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.UsuarioRepository;
import dev.brianmviana.api.movies.repositories.filters.UsuarioFilter;
import dev.brianmviana.api.movies.resouces.UsuarioResource;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Page<Usuario> pesquisar(UsuarioFilter usuarioFilter, Pageable pageable){
		Page<Usuario> usuarios = usuarioRepository.filtrar(usuarioFilter, pageable);
		
		for (Usuario usuario : usuarios) {
			hiddenPassword(usuario);
			usuario.add(linkTo(methodOn(UsuarioResource.class).burscarPorLogin(usuario.getLogin())).withSelfRel());

		}
		
	//	usuariosAtivos.sort(new Usuario());
		return usuarios;
	}
	
	public Usuario getUsuarioByLogin(String login) {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		if(usuario != null) {
			if(usuario.getStatus()) {
				hiddenPassword(usuario);
				usuario.add(linkTo(methodOn(UsuarioResource.class).pesquisar(new UsuarioFilter(), null)).withRel("Lista de Usuarios ativos"));
				return usuario;				
			}
		} 
		throw new EmptyResultDataAccessException(1);
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
