package org.skypro.skyshop.model.userBasket;

import org.skypro.skyshop.model.basketItem.BasketItem;

import java.util.ArrayList;

public final class UserBasket {

    private ArrayList<BasketItem> userBasket;
    private double total;

    public UserBasket(){
       this.userBasket = new ArrayList<>();
       this.total = 0.0;
    }

    public void add(BasketItem item){
        userBasket.add(item);
    }

    public void addAll(UserBasket item){
        userBasket.addAll(item.userBasket);
    }

    @Override
    public String toString(){
        String str = "Корзина продуктов\n";
        for(BasketItem item: userBasket){
            str += " Имя: " + item.getName() + "  ";
            str += " Цена: " + item.getCost() + "  ";
            str += " Количество: " + item.getAmount() + "\n";
        }
        str += " Итого: " + total;
        return str;
    }

}
