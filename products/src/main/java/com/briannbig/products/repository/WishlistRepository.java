package com.briannbig.products.repository;

import com.briannbig.products.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishList, Long> {
    WishList findByCustomerId(long personId);
}
