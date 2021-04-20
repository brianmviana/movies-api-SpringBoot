	package dev.brianmviana.api.movies.resouces;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.services.FilmeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API rest de Filmes")
@RestController
@RequestMapping("/filmes")
public class FilmeResource {

	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
		
	@ApiOperation(value = "Retorna uma lista de filmes")
	@GetMapping(produces = "application/json")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody List<Filme> listarTodos() {
		return filmeService.getAllFilmes(); //!filmes.isEmpty() ? ResponseEntity.ok(filmes) : ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna um filme")
	@GetMapping(value = "/{id}", produces = "application/json")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ResponseEntity<Filme> buscarFilme(@PathVariable(value = "id") Long id) {
		Filme filme = filmeService.getFilmeById(id);
 		return (filme != null) ? ResponseEntity.ok(filme) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Cria um novo filme")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Filme> criarFilme(@RequestBody @Valid Filme filme, HttpServletResponse response) {
		Filme filmeSalvo = filmeService.saveFilme(filme);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, filmeSalvo.getId().toString()));
		return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
	}

	@ApiOperation(value = "Deleta um filme")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public  ResponseEntity<?> deletarFilme(@PathVariable Long id) {
		filmeService.deleteFilme(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Atualiza as informações de um filme")
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Filme> criarFilme(@PathVariable(value = "id") Long id, @RequestBody @Valid Filme filme) {
		Filme filmeAtualizado = filmeService.updateFilme(id, filme);
		return ResponseEntity.ok(filmeAtualizado);
	}
	
}
