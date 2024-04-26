package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.model.WishList;
import com.app.paymentgitproject.repository.WishListRepository;
import com.app.paymentgitproject.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository){
        this.wishListRepository = wishListRepository;
    }

    @Override
    public void createdWishList(WishList wishList){
        wishListRepository.save(wishList);
    }

    @Override
    public List<WishList> readWishList(User user){
        return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
    }
}
