package br.com.matosmelo.facelitico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Litico {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Nome precisa ser preenchido")
	private String nome;
	@NotNull(message="Partido precisa ser preenchido")	
	private String partido;

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

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

}
