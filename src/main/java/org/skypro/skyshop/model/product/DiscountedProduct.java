package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int baseCost;
    private final int discountPercent;

    public DiscountedProduct(String name, int baseCost, int discountPercent, UUID id) {
        super(name, id);
        try {
            checkCost(baseCost);
            checkDiscount(discountPercent);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        this.baseCost = baseCost;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getCost() {
        return baseCost * (100 - discountPercent) / 100;
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
        return (name + ": " + getCost() + " " + "(" + discountPercent + "%" + ")");
    }
}
