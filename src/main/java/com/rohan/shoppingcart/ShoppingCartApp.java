package com.rohan.shoppingcart;

import java.util.List;

import com.rohan.shoppingcart.cart.ShoppingCart;
import com.rohan.shoppingcart.cart.ShoppingCartView;
import com.rohan.shoppingcart.product.Product;
import com.rohan.shoppingcart.product.ProductCatalog;
import com.rohan.shoppingcart.product.ProductNotFound;
import com.rohan.shoppingcart.util.ProductsListReader;

public class ShoppingCartApp {

    private ProductCatalog productCatalog = new ProductCatalog();
    private ShoppingCart cart = new ShoppingCart();

    private ShoppingCartApp() {
    }

    private void process(String productListFilePath) throws ShoppingCartException {
        List<String> products = ProductsListReader.read(productListFilePath);
        products.forEach(p -> {
            try {
                Product product = productCatalog.getByName(p);
                cart.addProduct(product);
            } catch (ProductNotFound e) {
                System.err.println(e.getMessage());
            }
        });
        System.out.println(new ShoppingCartView(cart).showCart());
    }

    public static void main(String[] args) throws ShoppingCartException {
        String productsListFilePath = getPorductsListFilePath(args);
        new ShoppingCartApp().process(productsListFilePath);
    }

    private static String getPorductsListFilePath(String[] args) {
        if (args.length == 1) {
            return args[0];
        }
        System.err.println("Expected one argument - path to file with product list.");
        System.exit(-1);
        return null;
    }
}