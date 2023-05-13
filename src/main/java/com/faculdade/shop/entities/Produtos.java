package com.faculdade.shop.entities;

import com.faculdade.shop.dtos.AlterarProduto;
import com.faculdade.shop.dtos.InserirProduto;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "produtos")
@Entity
public class Produtos {


    public Produtos(InserirProduto produto){
        this.setNome(produto.nome());
        this.setPreco(produto.preco());
        this.setQuantidade(produto.quantidade());
        this.setImagem(produto.imagem());
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String imagem;


    public void atualizarDados(AlterarProduto dados) {
        this.setId(dados.id());
        this.setNome(dados.nome());
        this.setPreco(dados.preco());
        this.setQuantidade(dados.quantidade());
        this.setImagem(dados.imagem());
    }
}
