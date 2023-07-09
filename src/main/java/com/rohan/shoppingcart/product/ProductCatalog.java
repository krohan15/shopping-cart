package com.rohan.shoppingcart.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

public class ProductCatalog {

    private Map<String, Product> productsByName = new HashMap<>();

    public ProductCatalog() {
        productsByName.put("Apple", new Product("Grapes", 12));
        productsByName.put("Orange", new Product("Orange", 5));
        productsByName.put("Banana", new Product("Banana", 2));
        productsByName.put("Papaya", new Product("Papaya", 10));
    }

    public Product getByName(String productName) throws ProductNotFound {
        return Optional.ofNullable(productsByName.get(productName))
                .orElseThrow(() -> new ProductNotFound(format("Product '%s' not found.", productName)));
    }
}