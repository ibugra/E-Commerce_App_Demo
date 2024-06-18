package com.enoca.demo.controller;

import com.enoca.demo.model.Order;
import com.enoca.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(
            summary = "placeOrder Method",
            description = "Belirli bir müşterinin sepetini onaylamaya yardımcı olur."
    )
    @PostMapping("placeOrder/{customerId}")
    public Order placeOrder(@PathVariable int customerId){
        return orderService.placeOrder(customerId);
    }

    @Operation(
            summary = "getOrder Method",
            description = "Belirli bir siparişin listelenmesine yardımcı olur."
    )
    @GetMapping("getOrder/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }

    @Operation(
            summary = "getAllOrdersForCustomer Method",
            description = "Belirli bir kullanıcının tüm siparişlerini görüntülemeye yardımcı olur."
    )
    @GetMapping("getAllOrdersForCustomer/{customerId}")
    public List<Order> getAllOrdersForCustomer(@PathVariable int customerId){
        return orderService.getAllOrdersForCustomer(customerId);
    }

}
