package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testRestock() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        product.restock(3);
        assertEquals(8, product.getQuantity());
    }

    @Test
    public void testSellSufficientQuantity() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        product.sell(3);
        assertEquals(2, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestockWithInvalidAmount() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        product.restock(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellWithInvalidAmount() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        product.sell(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellInsufficientQuantity() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        product.sell(10);
    }

    @Test
    public void testGetters() {
        Product product = new Product("123", "Test Product", 10.0, 5);
        assertEquals("123", product.getProductId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());
    }
}