package com.briannbig.products.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class WishList {
    @Id
    @SequenceGenerator(
            name = "wishlist_sequence",
            sequenceName = "wishlist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "wishlist_sequence"
    )
    private long id;

    @Column(unique = true, nullable = false)
    private long customerId;

    @ManyToMany
    private List<Product> products;
}
