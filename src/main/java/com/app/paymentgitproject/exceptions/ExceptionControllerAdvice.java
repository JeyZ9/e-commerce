package com.app.paymentgitproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionControllerAdvice {
    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleUpdateFailException(CustomException customException){
        return new ResponseEntity<>(customException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductNotExistException.class)
    public final ResponseEntity<String> handleUpdateFailException(ProductNotExistException productNotExistsException){
        return new ResponseEntity<>(productNotExistsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CartItemNotExistException.class)
    public final ResponseEntity<String> handleCartItemNotExistException(CartItemNotExistException cartItemNotExistException){
        return new ResponseEntity<>(cartItemNotExistException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = OrderNotFoundException.class)
    public final ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        return new ResponseEntity<>(orderNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
