package com.app.paymentgitproject.service;

import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.model.WishList;

import java.util.List;

public interface WishListService {

    void createdWishList(WishList wishList);

    List<WishList> readWishList(User user);
}
