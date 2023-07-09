package com.rohan.shoppingcart.product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(exclude = { "unitPrice"})
public class Product {

    private String name;
    private int unitPrice;

    public int getPriceForQuantity(int quantity) {
        return unitPrice * quantity;
    }

    public String renderProductLine(int quantity) {
        return String.format("%-20s|%-12s|%-10d|%-10s\n",
                name,
                unitPrice,
                quantity,
                getPriceForQuantity(quantity));
    }

}