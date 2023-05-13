package com.faculdade.shop.dtos;

import com.faculdade.shop.entities.Produtos;

public record InserirProduto(String nome, Double preco, Integer quantidade, String imagem) {

    public InserirProduto(Produtos produto){
        this(produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getImagem());
    }
}
