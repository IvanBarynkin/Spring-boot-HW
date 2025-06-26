package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@Configuration
@SessionScope
public class ProductBasket {

    private final HashMap<UUID,Integer> basketContainer;

    public ProductBasket(){
        basketContainer = new HashMap<>();
    }

    public void addProduct(Product addProduct){

        UUID addProductUUID = addProduct.getId();

        if(basketContainer.containsKey(addProductUUID)){
            basketContainer.put(addProductUUID,basketContainer.get(addProductUUID)+1);
        }
        else{
            basketContainer.put(addProduct.getId(),1);
        }
    }

    public Map<UUID,Integer> viewBasket(){
        return Collections.unmodifiableMap(basketContainer);
    }
}
