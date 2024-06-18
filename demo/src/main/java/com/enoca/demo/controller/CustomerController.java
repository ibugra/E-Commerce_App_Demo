package com.enoca.demo.controller;

import com.enoca.demo.model.Customer;
import com.enoca.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(
            summary = "addCustomer Method",
            description = "Müşteri kaydı yapmaya yardımcı olur."
    )
    @PostMapping("addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}
