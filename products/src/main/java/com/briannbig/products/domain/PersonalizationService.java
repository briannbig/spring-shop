package com.briannbig.products.domain;

import com.briannbig.products.models.Category;
import com.briannbig.products.models.InterestsList;
import com.briannbig.products.models.Product;
import com.briannbig.products.models.WishList;
import com.briannbig.products.repository.InterestsRepository;
import com.briannbig.products.repository.WishlistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonalizationService {
    private final WishlistRepository wishlistRepository;
    private final InterestsRepository interestsRepository;

    public WishList findWishlist(long customerId){
        return wishlistRepository.findByCustomerId(customerId);
    }

    public WishList addWishlistItem(long customerId, Product product){
        var wishList = wishlistRepository.findByCustomerId(customerId);
        if (wishList != null){
            wishList.getProducts().add(product);
            return wishlistRepository.save(wishList);
        }
        //todo check if customer exists before proceeding
        wishList = WishList.builder()
                .customerId(customerId)
                .products(List.of(product))
                .build();
        return wishlistRepository.save(wishList);
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
        // todo check if customer exists before proceeding
        list = InterestsList.builder()
                .customerId(customerId)
                .categories(List.of(category))
                .build();
        return interestsRepository.save(list);
    }

    private boolean customerExists(long customerId){
        //todo check if customer exists
        return true;
    }

}
