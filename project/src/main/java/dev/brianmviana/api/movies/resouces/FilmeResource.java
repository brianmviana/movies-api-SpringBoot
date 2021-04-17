package dev.brianmviana.api.movies.resouces;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//import javax.validation.Valid;
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
import dev.brianmviana.api.movies.repositories.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeResource {

	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody ArrayList<Filme> listFilme() {
		Iterable<Filme> filmeslist = filmeRepository.findAll();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		for (Filme filme : filmeslist) {
			long id = filme.getId();
			filme.add(linkTo(methodOn(FilmeResource.class).getFilme(id)).withSelfRel());
			filmes.add(filme);
		}
		return filmes;
	}
	
	@GetMapping(value = "/{id}",produces = "application/json")
	public @ResponseBody Filme getFilme(@PathVariable(value = "id") long id) {
		Filme filme = filmeRepository.findById(id);
		filme.add(linkTo(methodOn(FilmeResource.class).listFilme()).withRel("Filmes list"));
		return filme;
	}

	@PostMapping
	public Filme saveFilme(@RequestBody  Filme filme) { //TODO @Valid
		return filmeRepository.save(filme);
	}

	@DeleteMapping
	public Filme deleteFilme(@RequestBody Filme filme) {
		filmeRepository.delete(filme);
		return filme;
	}
	
	
	
}
