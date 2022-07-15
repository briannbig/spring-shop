package com.briannbig.products.domain;

import com.briannbig.products.models.Category;
import com.briannbig.products.models.Product;
import com.briannbig.products.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final ProductsService productsService;

    public CategoryService(CategoryRepository repository,
                           ProductsService productsService) {
        this.repository = repository;
        this.productsService = productsService;
    }

    public List<Category> fetch(){
        return repository.findAll();
    }

    public Category fetch(long id){
        return repository.findById(id).orElse(null);
    }

    public Category fetch(String name){
        return repository.findByName(name);
    }

    public Category add(String name, String description){
        return repository.save(Category.builder()
                .name(name)
                .description(description)
                .build()
        );
    }
    @Transactional
    public Category update(long id, String name, String description){
        var category = repository.findById(id);
        if (category.isPresent()){
            return repository.save(Category.builder()
                    .id(id)
                    .name(name)
                    .description(description)
                    .build());
        }
        return null;
    }

    public void remove(long id){
        repository.deleteById(id);
    }
    public List<Product> products(long id){
        return productsService.products(id);
    }
    public  List<Product> products(String name){
        return productsService.products(name);
    }
    @DeleteMapping
    public void delete(@RequestParam long id){
        productsService.remove(id);
    }

}
