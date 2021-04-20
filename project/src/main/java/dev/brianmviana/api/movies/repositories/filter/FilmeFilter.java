package dev.brianmviana.api.movies.repositories.filter;

import java.util.List;

import dev.brianmviana.api.movies.models.Atores;

public class FilmeFilter {

	private String nome;
	private String diretor;
	private String genero;
	private String ano;
	private String ator;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getAtor() {
		return ator;
	}
	
	public void setAtor(String ator) {
		this.ator = ator;
	}
	
	

}
