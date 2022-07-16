package com.briannbig.products.controller;

import com.briannbig.products.domain.CategoryService;
import com.briannbig.products.models.Category;
import com.briannbig.products.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private final CategoryService service;

    @GetMapping
    public List<Category> all(){
        return service.fetch();
    }

    @GetMapping("/{id}")
    public Category categoryById(@PathVariable long id){
        return service.fetch(id);
    }

    @GetMapping("/{name}")
    public Category categoryById(@PathVariable String name){
        return service.fetch(name);
    }

    @GetMapping("/{name}/products")
    public List<Product> products(@PathVariable String name){
        return service.products(name);
    }

    @PostMapping
    public Category add(@RequestParam String name, @RequestParam String description){
        return service.add(name, description);
    }

    @PutMapping
    public Category update(@RequestParam long id, @RequestParam String name, @RequestParam String description){
        return service.update(id, name, description);
    }

    @DeleteMapping
    public void delete(@RequestParam long id){
        service.remove(id);
    }

}
