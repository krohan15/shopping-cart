package com.rohan.shoppingcart.product;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestProductCatalog {

    private ProductCatalog catalog = new ProductCatalog();

    @Test
    public void shouldGetProductByName() throws Exception {
        Product product = catalog.getByName("Apple");
        assertNotNull(product);
    }

    @Test(expected = ProductNotFound.class)
    public void shouldThrowExceptionWhenProductNotFound() throws Exception {
        catalog.getByName("NotExistaing");
    }
}