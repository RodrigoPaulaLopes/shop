package com.faculdade.shop.config;

import com.faculdade.shop.entities.Produtos;
import com.faculdade.shop.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfigProfile implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public void run(String... args) throws Exception {


        var p1 = new Produtos(null, "Tênis Nike SB", 826.75, 5, "https://maze.cdn.plataformaneo.com.br/produto/multifotos/hd/20220106152639_2545997455_DZ.png");
        var p2 = new Produtos(null, "Boné Nike SB", 826.75, 5, "https://static.netshoes.com.br/produtos/bone-nike-sb-aba-curva-tailwind/72/HZM-1776-172/HZM-1776-172_zoom1.jpg?ts=1564054012");
        var p3 = new Produtos(null, "Camisa Nike SB", 826.75, 5, "https://maze.cdn.plataformaneo.com.br/produto/multifotos/hd/20201028163931_143999857_DZ.jpg");
        var p4 = new Produtos(null, "Shape Santa Cruz", 826.75, 5, "https://static.rockcity.com.br/public/rockcity/imagens/produtos/shape-santa-cruz-screaming-hand-powerlyte-preto-103833.jpg");

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }
}
