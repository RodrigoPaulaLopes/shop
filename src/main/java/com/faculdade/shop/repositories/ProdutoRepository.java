package com.faculdade.shop.repositories;

import com.faculdade.shop.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
}
