package com.briannbig.products.controller;

import com.briannbig.products.domain.CategoryService;
import com.briannbig.products.domain.PersonalizationService;
import com.briannbig.products.models.Category;
import com.briannbig.products.models.InterestsList;
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
    @Autowired
    private final PersonalizationService personalizationService;

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
    public Category add(@RequestBody Category category){
        return service.add(category);
    }

    @PutMapping
    public Category update(@RequestParam long id, @RequestParam String name, @RequestParam String description){
        return service.update(id, name, description);
    }

    @DeleteMapping
    public void delete(@RequestParam long id){
        service.remove(id);
    }

    @GetMapping("/interests/{customerId}")
    public InterestsList interestedCategories(@PathVariable long customerId){
        return personalizationService.findInterestsList(customerId);
    }

    @PostMapping("/interests/{customerId}")
    public InterestsList addInterestedCategory(
            @PathVariable long customerId,
            @RequestBody Category category
            ){
        return personalizationService.addInterestListItem(customerId, category);
    }

}
