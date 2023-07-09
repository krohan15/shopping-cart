package com.rohan.shoppingcart.cart;

import com.rohan.shoppingcart.product.ProductCatalog;
import com.rohan.shoppingcart.product.ProductNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestShoppingCartView {

    private ShoppingCart cart;
    private ShoppingCartView renderer;

    @Before
    public void setup() throws Exception {
        cart = prepareShopingCart();
        renderer = new ShoppingCartView(cart);
    }

    @Test
    public void shouldRenderCart() throws Exception {
        String cartText = renderer.showCart();
        assertTrue(cartText.contains("Total price(INR): |116"));
    }

    @Test
    public void shouldRenderEmptyCart() throws Exception {
        renderer = new ShoppingCartView(new ShoppingCart());
        String cartText = renderer.showCart();
        assertTrue(cartText.contains("Total price(INR): |0"));
    }

    private ShoppingCart prepareShopingCart() throws ProductNotFound {
        ProductCatalog productCatalog = new ProductCatalog();
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        return cart;
    }

}