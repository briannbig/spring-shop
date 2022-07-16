package com.briannbig.products.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Customer {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private LocalDate joinDate;
}
