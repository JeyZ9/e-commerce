package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.config.ApiResponse;
import com.app.paymentgitproject.dto.CheckoutItemDTO;
import com.app.paymentgitproject.dto.StripeResponse;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.exceptions.OrderNotFoundException;
import com.app.paymentgitproject.model.Order;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.service.AuthenticationService;
import com.app.paymentgitproject.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final AuthenticationService authenticationService;

    @Autowired
    public OrderController(OrderService orderService, AuthenticationService authenticationService){
        this.orderService = orderService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDTO> checkoutItemDTOList) throws StripeException{

        Session session = orderService.createSession(checkoutItemDTOList);

        StripeResponse stripeResponse = new StripeResponse(session.getId());

        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam("token") String token, @RequestParam("sessionId") String sessionId) throws AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        orderService.placeOrder(user, sessionId);

        return new ResponseEntity<>(new ApiResponse(true, "Order placed successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException{

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        List<Order> orderList = orderService.listOrders(user);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Long id, @RequestParam("token") String token) throws AuthenticationFailException , OrderNotFoundException {

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        Order order = orderService.getOrder(id, user);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
