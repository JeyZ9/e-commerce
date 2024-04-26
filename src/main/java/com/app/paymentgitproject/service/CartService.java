package com.app.paymentgitproject.service;

import com.app.paymentgitproject.dto.AddToCartDTO;
import com.app.paymentgitproject.dto.CartDTO;
import com.app.paymentgitproject.exceptions.CartItemNotExistException;
import com.app.paymentgitproject.model.Product;
import com.app.paymentgitproject.model.User;

public interface CartService {
    void addToCart(AddToCartDTO addToCartDTO, Product product, User user);

    CartDTO listCartItems(User user);

    void deleteCartItem(Long cartItemId, User user) throws CartItemNotExistException;
}
