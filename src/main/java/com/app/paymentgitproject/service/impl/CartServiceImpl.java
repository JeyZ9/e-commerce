package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.dto.AddToCartDTO;
import com.app.paymentgitproject.dto.CartDTO;
import com.app.paymentgitproject.dto.CartItemDTO;
import com.app.paymentgitproject.exceptions.CartItemNotExistException;
import com.app.paymentgitproject.model.Cart;
import com.app.paymentgitproject.model.Product;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.repository.CartRepository;
import com.app.paymentgitproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(AddToCartDTO addToCartDTO, Product product, User user){

        Cart cart = new Cart(product, addToCartDTO.getQuantity(), user);

        cartRepository.save(cart);
    }

    @Override
    public CartDTO listCartItems(User user){
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDTO> cartItemDTOS = new ArrayList<>();

        for(Cart cart : cartList){
            CartItemDTO cartItemDTO = new CartItemDTO(cart);

            cartItemDTOS.add(cartItemDTO);
        }

        double totalCost = 0;

        for(CartItemDTO cartItemDTO : cartItemDTOS){
            totalCost += cartItemDTO.getProduct().getPrice() * cartItemDTO.getQuantity();
        }

        return new CartDTO(cartItemDTOS, totalCost);
    }

    @Override
    public void deleteCartItem(Long cartItemId, User user) throws CartItemNotExistException {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if(optionalCart.isEmpty()) {
            throw new CartItemNotExistException("Cart item id not valid");
        }

        Cart cart = optionalCart.get();

        if(cart.getUser() != user) {
            throw new CartItemNotExistException("Cart item does not belong to user");
        }

        cartRepository.deleteById(cartItemId);
    }
}
