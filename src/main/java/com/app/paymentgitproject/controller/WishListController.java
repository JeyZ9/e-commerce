package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.config.ApiResponse;
import com.app.paymentgitproject.dto.ProductDTO;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.model.Product;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.model.WishList;
import com.app.paymentgitproject.repository.ProductRepository;
import com.app.paymentgitproject.service.AuthenticationService;
import com.app.paymentgitproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    private final WishListService wishListService;

    private final AuthenticationService authenticationService;

    private final ProductRepository productRepository;

    @Autowired
    public WishListController(WishListService wishListService, AuthenticationService authenticationService, ProductRepository productRepository){
        this.wishListService = wishListService;
        this.productRepository = productRepository;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody ProductDTO productDTO, @RequestParam("token") String token) throws AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        Product product = productRepository.getById(productDTO.getId());

        WishList wishList = new WishList(user, product);

        wishListService.createdWishList(wishList);

        return new ResponseEntity<>(new ApiResponse(true, "Added to wishlist"), HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDTO>> getWishList(@PathVariable("token") String token) throws AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        List<WishList> wishLists = wishListService.readWishList(user);

        List<ProductDTO> productDTOS = new ArrayList<>();

        for(WishList wishList : wishLists){
            productDTOS.add(new ProductDTO(wishList.getProduct()));
        }

        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }
}
