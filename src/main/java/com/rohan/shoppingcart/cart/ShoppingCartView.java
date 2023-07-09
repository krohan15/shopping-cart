package com.rohan.shoppingcart.cart;

import com.rohan.shoppingcart.product.Product;

public class ShoppingCartView {

    private static final String SEPARATOR = "----------------------------------------------------\n";
    private ShoppingCart shoppingCart;

    public ShoppingCartView(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String showCart() {
        StringBuilder textualRepresentation = new StringBuilder();
        textualRepresentation.append(getHeader());
        for (Product product : shoppingCart.quantities.keySet()) {
            textualRepresentation.append(product.renderProductLine(shoppingCart.quantities.get(product)));
        }
        textualRepresentation.append(getFooter());
        return textualRepresentation.toString();
    }

    private String getHeader() {
        StringBuilder headerBuilder = new StringBuilder();
        headerBuilder
                .append(String.format("%-10s|%-10s|%-10s|%-10s\n", "Product name", "Unit price(INR)", "Quantity", "Price(INR)"));
        headerBuilder.append(SEPARATOR);
        return headerBuilder.toString();
    }

    private String getFooter() {
        StringBuilder footerBuilder = new StringBuilder();
        footerBuilder.append(SEPARATOR);
        footerBuilder.append(String.format("%44s|%-10s\n", "Total price(INR): ", shoppingCart.getTotalPrice()));
        return footerBuilder.toString();
    }
}