package net.mooctest;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    public void removeItem(String itemName, int quantity) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (!items.containsKey(itemName)) {
            throw new IllegalArgumentException("Item not found in inventory.");
        }
        int currentQuantity = items.get(itemName);
        if (quantity > currentQuantity) {
            throw new IllegalArgumentException("Insufficient quantity in inventory.");
        }
        items.put(itemName, currentQuantity - quantity);
        if (items.get(itemName) == 0) {
            items.remove(itemName);
        }
    }

    public int getItemQuantity(String itemName) {
        return items.getOrDefault(itemName, 0);
    }

    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}
