package org.skypro.skyshop.model.service;

import org.skypro.skyshop.controller.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basketItem.BasketItem;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.userBasket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService){
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public String addProduct(UUID id) throws NoSuchProductException {
        Optional<Product> addProduct = storageService.getProductById(id);
        if(addProduct.isEmpty()) {
            throw new NoSuchProductException();
        }
        else{
            productBasket.addProduct(addProduct.get());
            return "Продукт добавлен в корзину";
        }
    }

    public UserBasket getUserBasket(){
        return productBasket.viewBasket().entrySet().stream()
                .map(p -> new BasketItem(storageService.getProductById(p.getKey()).get(), p.getValue()))
                .collect(UserBasket::new, UserBasket::add, UserBasket::addAll);

    }


}
