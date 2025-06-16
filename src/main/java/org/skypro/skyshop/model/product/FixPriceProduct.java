package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private final int FIX_COST;

    public FixPriceProduct(String name, int fixCost, UUID id) {
        super(name,id);
        try{
            checkCost(fixCost);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        this.FIX_COST = fixCost;
    }

    @Override
    public int getCost() {
        return FIX_COST;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return (name + ": " + FIX_COST);
    }
}
