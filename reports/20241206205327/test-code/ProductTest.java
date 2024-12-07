package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testConstructorAndGetters() {
        Product product = new Product("123", "TestProduct", 10.0, 5);
        assertEquals("123", product.getProductId());
        assertEquals("TestProduct", product.getName());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testRestock() {
        Product product = new Product("123", "TestProduct", 10.0, 5);
        product.restock(3);
        assertEquals(8, product.getQuantity());
        try {
            product.restock(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSell() {
        Product product = new Product("123", "TestProduct", 10.0, 5);
        
        product.sell(2);
        assertEquals(3, product.getQuantity());
        
        try {
            product.sell(-1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            product.sell(5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testToString() {
        Product product = new Product("123", "TestProduct", 10.0, 5);
        assertEquals("Product{productId='123', name='TestProduct', price=10.0, quantity=5}", product.toString());
    }
}