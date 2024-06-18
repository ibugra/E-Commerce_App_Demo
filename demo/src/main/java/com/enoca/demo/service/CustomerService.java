package com.enoca.demo.service;

import com.enoca.demo.model.Cart;
import com.enoca.demo.model.Customer;
import com.enoca.demo.repository.CartRepository;
import com.enoca.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    public Customer addCustomer(Customer customer){
        Cart cart = new Cart();
        customer.setCart(cart);
        cartRepository.save(cart);
        return customerRepository.save(customer);
    }

}
