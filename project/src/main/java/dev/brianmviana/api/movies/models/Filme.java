	package dev.brianmviana.api.movies.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Filme extends RepresentationModel<Filme> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String diretor;
	
	@NotNull
	private String genero;
	
//	@NotNull
//	private ArrayList<String> atores;
	
	@NotNull
	private int qtdVotos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
//	public ArrayList<String> getAtores() {
//		return atores;
//	}
//	
//	public void setAtores(ArrayList<String> atores) {
//		this.atores = atores;
//	}
	
	public int getQtdVotos() {
		return qtdVotos;
	}
	
	public void setQtdVotos(int qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((atores == null) ? 0 : atores.hashCode());
		result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qtdVotos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
//		if (atores == null) {
//			if (other.atores != null)
//				return false;
//		} else if (!atores.equals(other.atores))
//			return false;
		if (diretor == null) {
			if (other.diretor != null)
				return false;
		} else if (!diretor.equals(other.diretor))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdVotos != other.qtdVotos)
			return false;
		return true;
	}
	
	
}
