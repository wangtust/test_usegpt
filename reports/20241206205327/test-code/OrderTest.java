package net.mooctest;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order("123456", "Alice");
        order.addItem("Item1", 10.0);
        order.addItem("Item2", 20.0);
    }

    @Test
    public void testGetOrderId() {
        assertEquals("123456", order.getOrderId());
    }

    @Test
    public void testGetCustomerName() {
        assertEquals("Alice", order.getCustomerName());
    }

    @Test
    public void testGetItems() {
        List<String> items = order.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains("Item1"));
        assertTrue(items.contains("Item2"));
    }

    @Test
    public void testGetTotalAmount() {
        assertEquals(30.0, order.getTotalAmount(), 0.0);
    }

    @Test
    public void testAddItem() {
        order.addItem("Item3", 15.0);
        assertEquals(45.0, order.getTotalAmount(), 0.0);
        assertTrue(order.getItems().contains("Item3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePrice() {
        order.addItem("InvalidItem", -5.0);
    }

    @Test
    public void testRemoveItem() {
        order.removeItem("Item1", 10.0);
        assertEquals(20.0, order.getTotalAmount(), 0.0);
        assertFalse(order.getItems().contains("Item1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonexistentItem() {
        order.removeItem("NonexistentItem", 0.0);
    }

    @Test
    public void testToString() {
        String expectedString = "Order{orderId='123456', customerName='Alice', items=[Item1, Item2], totalAmount=30.0}";
        assertEquals(expectedString, order.toString());
    }
}