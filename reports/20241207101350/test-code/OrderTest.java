package net.mooctest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class OrderTest {

    @Test
    public void testConstructorAndGetters() {
        Order order = new Order("123", "John Doe");

        assertEquals("123", order.getOrderId());
        assertEquals("John Doe", order.getCustomerName());
        assertNotNull(order.getItems());
        assertTrue(order.getItems().isEmpty());
        assertEquals(0.0, order.getTotalAmount(), 0.0);
    }

    @Test
    public void testAddItem() {
        Order order = new Order("123", "John Doe");

        order.addItem("item1", 10.0);
        assertEquals(1, order.getItems().size());
        assertEquals(10.0, order.getTotalAmount(), 0.0);

        order.addItem("item2", 20.0);
        assertEquals(2, order.getItems().size());
        assertEquals(30.0, order.getTotalAmount(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePrice() {
        Order order = new Order("123", "John Doe");

        order.addItem("item1", -10.0);
    }

    @Test
    public void testRemoveItem() {
        Order order = new Order("123", "John Doe");

        order.addItem("item1", 10.0);
        assertEquals(1, order.getItems().size());
        assertEquals(10.0, order.getTotalAmount(), 0.0);

        order.removeItem("item1", 10.0);
        assertTrue(order.getItems().isEmpty());
        assertEquals(0.0, order.getTotalAmount(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() {
        Order order = new Order("123", "John Doe");

        order.removeItem("item1", 10.0);
    }

    @Test
    public void testToString() {
        Order order = new Order("123", "John Doe");
        order.addItem("item1", 10.0);
        order.addItem("item2", 20.0);

        assertEquals("Order{orderId='123', customerName='John Doe', items=[item1, item2], totalAmount=30.0}", order.toString());
    }
}