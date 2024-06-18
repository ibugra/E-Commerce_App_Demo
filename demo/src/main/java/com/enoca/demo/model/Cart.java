package com.enoca.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends Base{

    @ManyToMany
    @JoinTable(name = "cart_product_list", joinColumns = @JoinColumn(name = "cartId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> cartProducts = new ArrayList<>();

    private double totalPrice = 0;
}
