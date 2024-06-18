package com.enoca.demo.service;

import com.enoca.demo.model.Cart;
import com.enoca.demo.model.Customer;
import com.enoca.demo.model.Product;
import com.enoca.demo.repository.CartRepository;
import com.enoca.demo.repository.CustomerRepository;
import com.enoca.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Cart> getCart(int customerId){
        return cartRepository.findById(customerId);
    }

//    public Cart updateCart(int customerId, Cart cart){
//        Customer customer = customerRepository.findById(customerId).orElseThrow();
//
//        Cart cartCustomer = customer.getCart();
//
//        cartCustomer.setCartProducts(cart.getCartProducts());
//
//        cartCustomer.setTotalPrice(cart.getTotalPrice());
//
//        return cartRepository.save(cartCustomer);
//    }

    public boolean isEmptyCart(int customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        if( customer.getCart().getTotalPrice() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    public Cart addProductToCart(int customerId, int productId, int quantity){

        Product product = productRepository.findById(productId).orElseThrow();

        Customer customer = customerRepository.findById(customerId).orElseThrow();

        Cart cart = customer.getCart();

        if(product.getStock() < quantity){
            throw new RuntimeException("Not enough products found");
        }

        for(int i = 0; i < quantity; i++){
            cart.getCartProducts().add(product);
        }

        cart.setTotalPrice(cart.getTotalPrice() + quantity*product.getPrice());

        cartRepository.save(cart);

        product.setStock(product.getStock() - quantity);

        productRepository.save(product);

        return cart;
    }

    public Cart removeProductFromCart(int customerId, int productId){

        Customer customer = customerRepository.findById(customerId).orElseThrow();

        Product product = productRepository.findById(productId).orElseThrow();

        Cart cart = customer.getCart();

        if (cart.getTotalPrice() == 0){
            throw new RuntimeException("Product not found");
        }

        cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());

        cart.getCartProducts().remove(productId - 1);

        cartRepository.save(cart);

        product.setStock(product.getStock() + 1);

        productRepository.save(product);

        return cart;
    }

}
