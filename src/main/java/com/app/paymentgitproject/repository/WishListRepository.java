package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
