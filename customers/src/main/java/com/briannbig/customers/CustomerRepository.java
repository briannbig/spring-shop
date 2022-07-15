package com.briannbig.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByMobile(String mobile);

    @Query("select c from Customer c where c.name = ?1")
    List<Customer> findCustomerByName(String name);
}
