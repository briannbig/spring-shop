package com.briannbig.products.repository;

import com.briannbig.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    @Query("select p from Product p where p.category.id = ?1")
    List<Product> findByCategoryId(long id);

    @Query("select p from Product p where p.category.name = ?1")
    List<Product> findByCategoryName(String categoryName);
}
