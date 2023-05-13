package com.faculdade.shop.services;

import com.faculdade.shop.dtos.AlterarProduto;
import com.faculdade.shop.dtos.InserirProduto;
import com.faculdade.shop.dtos.ListarProduto;
import com.faculdade.shop.entities.Produtos;
import com.faculdade.shop.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;




    public Page<ListarProduto> findAll(Pageable paginacao){
        return produtoRepository.findAll(paginacao).map(ListarProduto::new);
    }
    public ListarProduto findOne(Long id){
        return new ListarProduto(produtoRepository.getReferenceById(id));
    }

    public Produtos create(InserirProduto dados) {
        var produto = new Produtos(dados);
        return produtoRepository.save(produto);

    }

    public Produtos update(AlterarProduto dados) {
        var p =  produtoRepository.getReferenceById(dados.id());
        p.atualizarDados(dados);

        return produtoRepository.save(p);


    }
    public void delete(Long id){
        var p = this.produtoRepository.getReferenceById(id);
        this.produtoRepository.delete(p);
    }
}
