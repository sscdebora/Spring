package com.generation.lojaGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojaGame.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByControlesContainingIgnoreCase (String controles);
	
}
