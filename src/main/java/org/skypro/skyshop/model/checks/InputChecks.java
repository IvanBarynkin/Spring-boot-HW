package org.skypro.skyshop.model.checks;

public interface InputChecks {

    default void checkName(String name) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым!");
        }
    }

    default void checkCost(int cost) throws IllegalArgumentException {
        if (cost <= 0) {
            throw new IllegalArgumentException("Цена продукта не может быть отрицательной или нулевой!");
        }
    }

    default void checkDiscount(int percent) throws IllegalArgumentException {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Скидка на продукт должна находиться в диапазоне от 0 до 100%");
        }
    }
}
