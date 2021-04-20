package dev.brianmviana.api.movies.resouces;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.brianmviana.api.movies.events.ResourceCreatedEvent;
import dev.brianmviana.api.movies.models.Voto;
import dev.brianmviana.api.movies.models.utils.VotoRequest;
import dev.brianmviana.api.movies.services.VotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API rest para usuarios votarem em filmes")
@RestController
public class VotoResource {

	@Autowired
	private VotoService votoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@ApiOperation(value="Retorna uma lista de votos")
	@GetMapping(path = "/filmes/{id}/votos", produces="application/json")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ResponseEntity<List<Voto>> getAllVotosByFilme(@PathVariable Long id) {
		List<Voto> votos = votoService.getVotosByFilme(id);
		return (votos != null) ? ResponseEntity.ok(votos) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Retorna uma lista de votos")
	@GetMapping(path = "/usuarios/{login}/votos", produces="application/json")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ResponseEntity<List<Voto>> getAllVotosByFilme(@PathVariable String login) {
		List<Voto> votos = votoService.getVotosByUsuario(login);
		return (votos != null) ? ResponseEntity.ok(votos) : ResponseEntity.notFound().build();

	}
	
	@ApiOperation(value="Cria um novo voto")
	@PostMapping(path = "/filmes/{idFilme}/votar")
	public ResponseEntity<Voto> votar(@PathVariable Long idFilme, @RequestBody @Valid VotoRequest votoRequest, HttpServletResponse response) {
		Voto voto = votoService.votar(idFilme, votoRequest);
		if (voto != null) {
			publisher.publishEvent(new ResourceCreatedEvent(this, response, voto.getId().toString()));
		}
		return (voto != null) ? ResponseEntity.status(HttpStatus.CREATED).body(voto) : ResponseEntity.badRequest().build();
	}

}
