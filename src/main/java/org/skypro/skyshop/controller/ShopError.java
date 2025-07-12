package org.skypro.skyshop.controller;

class ShopError {
    public final String code;
    public final String message;

    public ShopError(String code, String message){
        this.code = code;
        this.message = message;
    }
}
