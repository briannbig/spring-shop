package com.briannbig.customers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.all();
    }

    @GetMapping("/{id}")
    public Customer customer(@PathVariable long id){
        return service.getCustomer(id);
    }

    @GetMapping(params = {"name"})
    public List<Customer> customersByName(@RequestBody String name){
        return service.searchCustomerByName(name);
    }

    @PostMapping
    public Customer add(@RequestParam String name, @RequestParam String email, @RequestParam String mobile){
        return service.register(name, email, mobile);
    }
}
