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
@Table(name = "orders")
public class Order extends Base{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer orderCustomer;

    @ManyToMany
    @JoinTable(name = "order_product_list", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> orderProducts = new ArrayList<>();

}
