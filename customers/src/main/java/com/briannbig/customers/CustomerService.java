package com.briannbig.customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> all(){
        return repository.findAll();
    }
    public Customer register(String name, String email, String mobile){
        return repository.save(
                Customer.builder()
                        .name(name)
                        .email(email)
                        .mobile(mobile)
                        .build()
        );
    }
    public Customer getCustomer(long id){
        var customer = repository.findById(id);
        return customer.orElse(null);
    }
    public Customer getCustomerByEmail(String email){
        return repository.findByEmail(email);
    }
    public Customer getCustomerByMobile(String mobile){
        return repository.findByMobile(mobile);
    }
    public List<Customer> searchCustomerByName(String name){
        return repository.findCustomerByName(name);
    }
}
