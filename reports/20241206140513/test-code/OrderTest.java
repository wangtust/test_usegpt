package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testAddItem() {
        Order order = new Order("12345", "Alice");
        order.addItem("Apple", 1.5);
        order.addItem("Banana", 0.8);
        
        assertEquals(2, order.getItems().size());
        assertEquals(2.3, order.getTotalAmount(), 0.01);
    }

    @Test
    public void testRemoveItem() {
        Order order = new Order("54321", "Bob");
        order.addItem("Apple", 1.0);
        order.addItem("Banana", 0.5);
        
        order.removeItem("Banana", 0.5);
        
        assertEquals(1, order.getItems().size());
        assertEquals(1.0, order.getTotalAmount(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePrice() {
        Order order = new Order("98765", "Charlie");
        order.addItem("Apple", -1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() {
        Order order = new Order("13579", "David");
        order.addItem("Apple", 1.0);
        order.removeItem("Orange", 0.7);
    }

}