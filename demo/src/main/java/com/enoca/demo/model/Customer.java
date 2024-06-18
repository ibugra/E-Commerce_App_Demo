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
@Table(name = "customer")
public class Customer extends Base{

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart;

}
