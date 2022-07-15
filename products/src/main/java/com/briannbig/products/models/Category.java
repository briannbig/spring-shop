package com.briannbig.products.models;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_sequence"
    )
    private long id;

    @Column(unique = true)
    private String name;

    @Column
    private String description;

}
