package com.briannbig.customers;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            sequenceName = "customer_sequence",
            name = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    private long id;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    @Column
    private LocalDate joinDate;
}
