package com.briannbig.products.models;

import com.briannbig.products.models.Category;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    private long id;

    @ManyToOne
    private Category category;

    @Column
    private String name;
    @Column
    private double price;
}
