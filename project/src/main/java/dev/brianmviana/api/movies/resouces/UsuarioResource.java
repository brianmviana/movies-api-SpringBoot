package dev.brianmviana.api.movies.resouces;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

import dev.brianmviana.api.movies.events.ResourceCreatedEvent;
import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.filters.UsuarioFilter;
import dev.brianmviana.api.movies.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API rest de Usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@ApiOperation(value="Retorna uma lista de usuarios")
	@GetMapping(produces="application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public @ResponseBody Page<Usuario> pesquisar(UsuarioFilter usuarioFilter, Pageable pageable) {
		return usuarioService.pesquisar(usuarioFilter, pageable);
	}
	
	@ApiOperation(value="Retorna um usuario")
	@GetMapping(value = "/{login}",produces = "application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public @ResponseBody ResponseEntity<Usuario> burscarPorLogin(@PathVariable(value = "login") String login) {
		Usuario usuario =  usuarioService.getUsuarioByLogin(login);
 		return (usuario != null) ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value="Cria um novo usuario")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_USER') OR hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Usuario> criar(@RequestBody @Valid Usuario usuario, HttpServletResponse response) {
		Usuario user = usuarioService.saveUsuario(usuario);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, user.getLogin()));
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@ApiOperation(value="Atualiza um novo usuario")
	@PutMapping(value = "/{login}",produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@PathVariable(value = "login") String login, @RequestBody @Valid Usuario usuario) {
		Usuario user = usuarioService.updateUsuario(login, usuario);
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value="Deleta um usuario")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')  OR hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Usuario> deletar(@PathVariable String login) {
		usuarioService.deleteUsuario(login);
		return ResponseEntity.noContent().build();
	}
}
