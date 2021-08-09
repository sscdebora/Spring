package com.generation.lojaGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String controles;
	
	private String fone;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getControles() {
		return controles;
	}

	public void setControles(String controles) {
		controles = controles;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		fone = fone;
	}

}
