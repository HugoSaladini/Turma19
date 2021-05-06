package com.generation.LojaGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.LojaGame.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	

}
