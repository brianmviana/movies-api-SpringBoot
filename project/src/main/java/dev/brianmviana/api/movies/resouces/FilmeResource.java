package dev.brianmviana.api.movies.resouces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@ApiOperation(value="Retorna uma lista de filmes")
	@GetMapping(produces="application/json")
	public @ResponseBody List<Filme> listFilme() {
		return filmeService.getAllFilmes();
	}
	
	@ApiOperation(value="Retorna um filme")
	@GetMapping(value = "/{id}",produces = "application/json")
	public @ResponseBody Filme getFilme(@PathVariable(value = "id") long id) {
		return filmeService.getFilmeById(id);
	}

	@ApiOperation(value="Cria um novo filme")
	@PostMapping
	public Filme saveFilme(@RequestBody @Valid Filme filme) {
		return filmeService.saveFilme(filme);
	}

	@ApiOperation(value="Deleta um filme")
	@DeleteMapping
	public Filme deleteFilme(Filme filme) {
		return filmeService.deleteFilme(filme);
	}
	
	
	
}
