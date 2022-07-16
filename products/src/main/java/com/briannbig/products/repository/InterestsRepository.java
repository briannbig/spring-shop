package com.briannbig.products.repository;

import com.briannbig.products.models.InterestsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsRepository extends JpaRepository<InterestsList, Long> {
    InterestsList findByCustomerId(long id);
}
