package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.Order;
import com.app.paymentgitproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);
}
