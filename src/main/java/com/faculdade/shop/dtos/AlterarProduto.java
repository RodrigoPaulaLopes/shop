package com.faculdade.shop.dtos;

import com.faculdade.shop.entities.Produtos;

public record AlterarProduto(Long id, String nome, Double preco, Integer quantidade, String imagem) {

    public AlterarProduto(Produtos produtos){
        this(produtos.getId(), produtos.getNome(), produtos.getPreco(), produtos.getQuantidade(), produtos.getImagem());
    }
}
