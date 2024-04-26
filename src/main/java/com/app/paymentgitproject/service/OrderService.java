package com.app.paymentgitproject.service;

import com.app.paymentgitproject.dto.CheckoutItemDTO;
import com.app.paymentgitproject.exceptions.OrderNotFoundException;
import com.app.paymentgitproject.model.Order;
import com.app.paymentgitproject.model.User;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import java.util.List;

public interface OrderService {

    Session createSession(List<CheckoutItemDTO> checkoutItemDTOList) throws StripeException;

    void placeOrder(User user, String sessionId);

    List<Order> listOrders(User user);

    Order getOrder(Long id, User user) throws OrderNotFoundException;
}
