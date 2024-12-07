package net.mooctest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddItem() {
        inventory.addItem("apple", 5);
        assertEquals(5, inventory.getItemQuantity("apple"));
    }

    @Test
    public void testRemoveItem() {
        inventory.addItem("banana", 10);
        inventory.removeItem("banana", 5);
        assertEquals(5, inventory.getItemQuantity("banana"));
    }

    @Test
    public void testGetItemQuantity() {
        assertEquals(0, inventory.getItemQuantity("non-existing-item"));
    }

    @Test
    public void testHasItem() {
        assertFalse(inventory.hasItem("non-existing-item"));
        inventory.addItem("orange", 3);
        assertTrue(inventory.hasItem("orange"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithEmptyName() {
        inventory.addItem("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativeQuantity() {
        inventory.addItem("pear", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() {
        inventory.removeItem("non-existing-item", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWithInsufficientQuantity() {
        inventory.addItem("grapes", 2);
        inventory.removeItem("grapes", 5);
    }
}