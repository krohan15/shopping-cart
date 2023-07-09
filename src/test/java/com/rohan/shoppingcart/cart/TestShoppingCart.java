package com.rohan.shoppingcart.cart;

import com.rohan.shoppingcart.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestShoppingCart {

    private ShoppingCart cart = new ShoppingCart();

    private Product product1 = new Product("Name1", 1000);
    private Product product2 = new Product("Name2", 300);

    @Test
    public void shouldAddNewProduct() throws Exception {
        cart.addProduct(product1);
        assertEquals(1, cart.quantities.get(product1).intValue());

    }

    @Test
    public void shouldIncreaseQuantityOfAlreadyAddedProduct() throws Exception {
        cart.addProduct(product1);
        cart.addProduct(product1);
        assertEquals(2, cart.quantities.get(product1).intValue());
    }

    @Test
    public void shouldTotalPriceBeZeroWhenCartEmpty() throws Exception {
        int totalPrice = cart.getTotalPrice();
        assertEquals(0, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceForCart() throws Exception {
        cart.addProduct(product1);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product2);
        cart.addProduct(product2);
        int totalPrice = cart.getTotalPrice();
        assertEquals(2900, totalPrice);
    }
}