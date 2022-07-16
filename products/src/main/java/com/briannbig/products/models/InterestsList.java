package com.briannbig.products.models;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Entity
public class InterestsList {
    @Id
    @SequenceGenerator(
            name="interests_sequence",
            sequenceName = "interests_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "interests_sequence")
    private long id;

    @Column(unique = true, nullable = false)
    private long customerId;

    @ManyToMany
    private List<Category> categories;
}
