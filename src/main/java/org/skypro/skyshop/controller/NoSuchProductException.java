package org.skypro.skyshop.controller;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(){
        super("Такого продукта не существует");
    }
}
