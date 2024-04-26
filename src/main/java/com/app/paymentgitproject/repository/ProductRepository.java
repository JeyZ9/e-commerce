package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
