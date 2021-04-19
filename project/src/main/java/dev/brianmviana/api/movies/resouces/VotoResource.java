package dev.brianmviana.api.movies.resouces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.brianmviana.api.movies.models.Voto;
import dev.brianmviana.api.movies.services.VotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API rest para usuarios votarem em filmes")
@RestController
//@RequestMapping("/votos")
public class VotoResource {

	@Autowired
	private VotoService votoService;
	
	@ApiOperation(value="Retorna uma lista de votos")
	@GetMapping(path = "/votos", produces="application/json")
	public @ResponseBody List<Voto> getAllFilme() {
		return votoService.getAllVotos();
	}
	
	@ApiOperation(value="Cria um novo voto")
	@PostMapping(path = "/votar")
	public Voto votar(@RequestBody @Valid Voto voto){//(@RequestBody @Valid Integer nota, @RequestBody @Valid Long idFilme, @RequestBody @Valid Long idUsuario) {
		//System.out.println(voto.getUsuario().getNome());
		
		return votoService.votar(voto);
	}

	
	
}
