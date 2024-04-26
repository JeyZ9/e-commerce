package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.Cart;
import com.app.paymentgitproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
