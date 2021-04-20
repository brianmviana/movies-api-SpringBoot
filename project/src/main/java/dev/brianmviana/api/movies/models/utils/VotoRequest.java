package dev.brianmviana.api.movies.models.utils;

public class VotoRequest {

	private Integer nota;
	private String login;
	
	public VotoRequest(Integer nota, String login) {
		this.nota = nota;
		this.login = login;
	}

	public Integer getNota() {
		return nota;
	}

	public String getLogin() {
		return login;
	}

}
