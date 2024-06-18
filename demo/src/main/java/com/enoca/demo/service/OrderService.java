package com.enoca.demo.service;

import com.enoca.demo.model.Cart;
import com.enoca.demo.model.Customer;
import com.enoca.demo.model.Order;
import com.enoca.demo.repository.CartRepository;
import com.enoca.demo.repository.CustomerRepository;
import com.enoca.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;


    public Order placeOrder(int customerId){

        Customer customer = customerRepository.findById(customerId).orElseThrow();

        Cart cart = customer.getCart();

        Order order = new Order();

        for(int i = 0; i < cart.getCartProducts().size(); i++){
            order.getOrderProducts().add(cart.getCartProducts().get(i));
        }

        order.setOrderCustomer(customer);

        orderRepository.save(order);

        cart.setTotalPrice(0);

        cart.setCartProducts(null);

        cartRepository.save(cart);

        return order;
    }

    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    public List<Order> getAllOrdersForCustomer(int customerId){
        List<Order> orderListForCustomer = new ArrayList<>();

        List<Order> orders = orderRepository.findAll();

        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderCustomer().getId() == customerId){
                orderListForCustomer.add(orders.get(i));
            }
        }

        return orderListForCustomer;
    }


}
