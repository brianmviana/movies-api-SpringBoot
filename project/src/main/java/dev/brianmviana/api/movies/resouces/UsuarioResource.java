package dev.brianmviana.api.movies.resouces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API rest de Usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value="Retorna uma lista de usuarios")
	@GetMapping(produces="application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public @ResponseBody List<Usuario> getAllUsuario() {
		return usuarioService.getAllUsuarios();
	}
	
	@ApiOperation(value="Retorna um usuario")
	@GetMapping(value = "/{login}",produces = "application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public @ResponseBody ResponseEntity<Usuario> getUsuario(@PathVariable(value = "login") String login) {
		return usuarioService.getUsuarioByLogin(login);
	}

	@ApiOperation(value="Cria um novo usuario")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Usuario saveUsuario(@RequestBody @Valid Usuario usuario) {
		Usuario user = usuarioService.saveUsuario(usuario);
		return user;
	}

	@ApiOperation(value="Atualiza um novo usuario")
	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Usuario updateUsuario(@RequestBody @Valid Usuario usuario) {
		Usuario user = usuarioService.updateUsuario(usuario);
		return user;
	}

	@ApiOperation(value="Atualiza um novo usuario")
	@PutMapping(value = "/{login}",produces = "application/json")
	public Usuario updateUsuario(@PathVariable(value = "login") String login, @RequestBody @Valid Usuario usuario) {
		Usuario user = usuarioService.updateUsuario(login, usuario);
		return user;
	}

	@ApiOperation(value="Deleta um usuario")
	@DeleteMapping
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Usuario deleteUsuario(Usuario usuario) {
		return usuarioService.deleteUsuario(usuario);
	}
}
