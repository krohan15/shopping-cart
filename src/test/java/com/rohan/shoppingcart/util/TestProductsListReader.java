package com.rohan.shoppingcart.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.rohan.shoppingcart.ShoppingCartException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;

public class TestProductsListReader {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test(expected = ShoppingCartException.class)
    public void shouldThrowExceptionWhenFileNotFound() throws Exception {
        ProductsListReader.read("not-existing-filename");
    }

    @Test
    public void shouldReadProductsListFromFile() throws Exception {
        String filePath = preparePorductListFile();
        List<String> productList = ProductsListReader.read(filePath);
        assertEquals(8, productList.size());
        assertEquals("Apple", productList.get(0));
    }

    private String preparePorductListFile() throws IOException {
        File productListFile = tempFolder.newFile();
        BufferedWriter writter = new BufferedWriter(new FileWriter(productListFile));
        writter.write("Apple\n");
        writter.write("Banana\n");
        writter.write("Papaya\n");
        writter.write("Papaya\n");
        writter.write("Apple\n");
        writter.write("Orange\n");
        writter.write("Banana\n");
        writter.write("Orange\n");
        writter.close();
        return productListFile.getAbsolutePath();
    }
}