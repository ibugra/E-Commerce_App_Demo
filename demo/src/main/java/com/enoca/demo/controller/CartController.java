package com.enoca.demo.controller;

import com.enoca.demo.model.Cart;
import com.enoca.demo.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Operation(
            summary = "getCart Method",
            description = "Belirli bir müşterinin sepetini görüntülemeye yardımcı olur."
    )
    @GetMapping("getCart/{customerId}")
    public Optional<Cart> cart(@PathVariable int customerId){
        return cartService.getCart(customerId);
    }

//    @PutMapping("updateCart/{customerId}")
//    public Cart updateCart(@PathVariable int customerId, @RequestBody Cart cart){
//        return cartService.updateCart(customerId, cart);
//    }

    @Operation(
            summary = "isEmpty Method",
            description = "Belirli bir müşterinin sepetinin boş olup olmadığını kontrol etmeye yardımcı olur."
    )
    @GetMapping("isEmpty/{customerId}")
    public boolean isEmptyCart(@PathVariable int customerId){
        return cartService.isEmptyCart(customerId);
    }

    @Operation(
            summary = "addProductToCart Method",
            description = "Belirli bir müşterinin sepetine belirli bir ürünü istenilen miktarda eklemeye yardımcı olur"
    )
    @PostMapping("addProductToCart/{customerId}/{productId}/{quantity}")
    public Cart addProductToCart(@PathVariable int customerId, @PathVariable int productId, @PathVariable int quantity){
        return cartService.addProductToCart(customerId, productId, quantity);
    }

    @Operation(
            summary = "removeProductFromCart Method",
            description = "Belirli bir müşterinin sepetinden, belirli bir üründen, bir adet silmeye yardımcı olur."
    )
    @PostMapping("removeProductFromCart/{customerId}/{productId}")
    public Cart removeProductFromCart(@PathVariable int customerId, @PathVariable int productId){
        return cartService.removeProductFromCart(customerId, productId);
    }
}
