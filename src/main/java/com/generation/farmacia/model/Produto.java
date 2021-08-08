package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long IdProduto;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String nome;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String marca;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String descricao;
	
	@NotNull
	private double preco;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL) /*relacionando as tabelas Produto e Categoria */
	@JsonIgnoreProperties("produto")
	private List <Categoria> categoria;
	
	
	//METODOS GETTERS AND SETTERS
	
	public Long getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(Long idProduto) {
		IdProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
