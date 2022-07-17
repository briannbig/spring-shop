package com.briannbig.products.domain;

import com.briannbig.products.models.Category;
import com.briannbig.products.models.InterestsList;
import com.briannbig.products.models.Product;
import com.briannbig.products.models.WishList;
import com.briannbig.products.repository.InterestsRepository;
import com.briannbig.products.repository.WishlistRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonalizationService {
    private final WishlistRepository wishlistRepository;
    private final InterestsRepository interestsRepository;
    private final RestTemplate restTemplate;

    public WishList findWishlist(long customerId){
        return wishlistRepository.findByCustomerId(customerId);
    }

    public WishList addWishlistItem(long customerId, Product product){
        var wishList = wishlistRepository.findByCustomerId(customerId);
        if (wishList != null){
            wishList.getProducts().add(product);
            return wishlistRepository.save(wishList);
        }
        //todo: replace rest template
        if (customerExists(customerId)){
            wishList = WishList.builder()
                    .customerId(customerId)
                    .products(List.of(product))
                    .build();
            return wishlistRepository.save(wishList);
        }
        return WishList.builder().build();

    }

    public InterestsList findInterestsList(long customerId){
        return interestsRepository.findByCustomerId(customerId);
    }

    public InterestsList addInterestListItem(long customerId, Category category){
        var list = interestsRepository.findByCustomerId(customerId);
        if (list != null){
            list.getCategories().add(category);
            return interestsRepository.save(list);
        }
        if (customerExists(customerId)) {
            list = InterestsList.builder()
                    .customerId(customerId)
                    .categories(List.of(category))
                    .build();
            return interestsRepository.save(list);
        }
        return InterestsList.builder().build();
    }

    private boolean customerExists(long customerId){
        Customer customer =restTemplate.getForObject(
                "http://localhost:8081/api/v1/customers/{id}",
                Customer.class,
                customerId
        );
        System.out.println("Check Customer-------------------------: " +customer);
        return customer != null;
    }

}
