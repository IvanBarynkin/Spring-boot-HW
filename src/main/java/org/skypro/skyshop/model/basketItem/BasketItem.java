package org.skypro.skyshop.model.basketItem;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {
    private final Product product;
    private final int amount;

    public BasketItem(Product product, int amount){
        this.amount = amount;
        this.product = product;
    }

    public int getCost(){
        return product.getCost();
    }

    public int getAmount(){
        return amount;
    }

    public String getName(){
        return product.getName();
    }

}
