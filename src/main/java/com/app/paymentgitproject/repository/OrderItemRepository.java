package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
