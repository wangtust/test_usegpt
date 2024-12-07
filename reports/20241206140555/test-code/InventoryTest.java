package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void testAddItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("Apple", 3);
        assertEquals(3, inventory.getItemQuantity("Apple"));
    }

    @Test
    public void testRemoveItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("Banana", 5);
        inventory.removeItem("Banana", 3);
        assertEquals(2, inventory.getItemQuantity("Banana"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNullName() {
        Inventory inventory = new Inventory();
        inventory.addItem(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithEmptyName() {
        Inventory inventory = new Inventory();
        inventory.addItem("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativeQuantity() {
        Inventory inventory = new Inventory();
        inventory.addItem("Orange", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotInInventory() {
        Inventory inventory = new Inventory();
        inventory.removeItem("Pineapple", 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWithInsufficientQuantity() {
        Inventory inventory = new Inventory();
        inventory.addItem("Grapes", 3);
        inventory.removeItem("Grapes", 5);
    }
}