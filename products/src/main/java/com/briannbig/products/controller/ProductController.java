package com.briannbig.products.controller;

import com.briannbig.products.domain.ProductsService;
import com.briannbig.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> all(){
        return  productsService.fetch();
    }

    @GetMapping("/{id}")
    public Product productById(@PathVariable long id){
        return productsService.fetch(id);
    }
    @GetMapping(params = {"name"})
    public Product productByName(@RequestParam String name){
        return productsService.fetch(name);
    }
    @PostMapping()
    public Product add(@RequestParam String name, @RequestParam double price ){
        return productsService.add(name, price);
    }
    @PutMapping()
    public Product update(@RequestParam long id, @RequestParam String name, @RequestParam double price ){
        return productsService.update(id, name, price);
    }
    @DeleteMapping
    public void delete(@RequestParam long id){
        productsService.remove(id);
    }

}
