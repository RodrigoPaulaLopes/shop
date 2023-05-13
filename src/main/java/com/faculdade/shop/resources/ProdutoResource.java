package com.faculdade.shop.resources;

import com.faculdade.shop.dtos.AlterarProduto;
import com.faculdade.shop.dtos.InserirProduto;
import com.faculdade.shop.dtos.ListarProduto;
import com.faculdade.shop.services.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ListarProduto>> findAll(Pageable paginacao){
        return ResponseEntity.ok().body(produtoService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListarProduto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findOne(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ListarProduto> create(@RequestBody InserirProduto dados, UriComponentsBuilder builder){
        var produto = produtoService.create(dados);
        var uri = builder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new ListarProduto(produto));
    }
    @PutMapping
    @Transactional
    public ResponseEntity<ListarProduto> update(@RequestBody AlterarProduto dados){
        var produto = produtoService.update(dados);
        return ResponseEntity.ok().body(new ListarProduto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
