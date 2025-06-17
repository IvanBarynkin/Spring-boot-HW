package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private final int cost;

    public SimpleProduct(String name, int cost, UUID id) {
        super(name,id);
        try{
            checkCost(cost);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return (name + ": " + cost);
    }

}
