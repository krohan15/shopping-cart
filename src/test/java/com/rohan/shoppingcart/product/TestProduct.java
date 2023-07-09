package com.rohan.shoppingcart.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestProduct {

    private Product product;

    @Before
    public void setup() throws Exception {
        product = new Product("Some Name", 1000);
    }

    @Test
    public void shouldReturnPrice() throws Exception {
        int price = product.getPriceForQuantity(12);
        assertEquals(12000, price);
    }

    @Test
    public void shouldRender() throws Exception {
        String productString = product.renderProductLine(19);
        assertNotNull(productString);
    }

}