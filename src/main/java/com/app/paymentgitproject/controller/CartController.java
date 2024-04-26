package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.config.ApiResponse;
import com.app.paymentgitproject.dto.AddToCartDTO;
import com.app.paymentgitproject.dto.CartDTO;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.exceptions.CartItemNotExistException;
import com.app.paymentgitproject.exceptions.ProductNotExistException;
import com.app.paymentgitproject.model.Product;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.service.AuthenticationService;
import com.app.paymentgitproject.service.CartService;
import com.app.paymentgitproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    private final AuthenticationService authenticationService;

    @Autowired
    public CartController(CartService cartService, ProductService productService, AuthenticationService authenticationService){
        this.cartService = cartService;
        this.productService = productService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDTO addToCartDTO, @RequestParam("token") String token) throws ProductNotExistException, AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        Product product = productService.getProductById(addToCartDTO.getProductId());

        cartService.addToCart(addToCartDTO, product, user);

        return new ResponseEntity<>(new ApiResponse(true,"Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CartDTO> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        CartDTO cartDTO = cartService.listCartItems(user);

        return new ResponseEntity<>(cartDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long cartItemId, @RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        cartService.deleteCartItem(cartItemId, user);

        return new ResponseEntity<>(new ApiResponse(true, "Item removed successfully"), HttpStatus.OK);
    }

}
