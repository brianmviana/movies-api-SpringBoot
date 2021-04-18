package dev.brianmviana.api.movies.models;

public enum ROLE {
	DEFAULT("default"),
	ADMIN("administrador");

	private String descricao;

	ROLE(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}

