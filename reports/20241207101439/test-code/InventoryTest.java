package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void testAddItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("ItemA", 5);
        assertEquals(5, inventory.getItemQuantity("ItemA"));
    }

    @Test
    public void testRemoveItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("ItemB", 3);
        inventory.removeItem("ItemB", 2);
        assertEquals(1, inventory.getItemQuantity("ItemB"));
    }

    @Test
    public void testGetItemQuantity() {
        Inventory inventory = new Inventory();
        inventory.addItem("ItemC", 10);
        assertEquals(10, inventory.getItemQuantity("ItemC"));
    }

    @Test
    public void testHasItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("ItemD", 1);
        assertTrue(inventory.hasItem("ItemD"));
        assertFalse(inventory.hasItem("ItemE"));
    }
}