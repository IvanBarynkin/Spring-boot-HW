package org.skypro.skyshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductHandler (NoSuchProductException e){
        return new ResponseEntity<ShopError>(new ShopError("404","Несуществующий продукт"), HttpStatus.NOT_FOUND);
    }
}
