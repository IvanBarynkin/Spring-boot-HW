package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.checks.InputChecks;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable, InputChecks {

    protected String name;
    private final UUID id;

    public Product(String name, UUID id) {
        try {
            checkName(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        this.name = name;
        this.id = id;
    }

    @JsonIgnore
    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String searchName() {
        return name;
    }


    public boolean equalsProduct(Product other) {
        return (this.getName().equals(other.getName()));
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
