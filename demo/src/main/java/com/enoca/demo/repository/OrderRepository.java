package com.enoca.demo.repository;

import com.enoca.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
