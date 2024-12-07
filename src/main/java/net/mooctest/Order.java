package net.mooctest;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private String customerName;
    private List<String> items;
    private double totalAmount;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(String item, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        items.add(item);
        totalAmount += price;
    }

    public void removeItem(String item, double price) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Item not found in order.");
        }
        items.remove(item);
        totalAmount -= price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
}