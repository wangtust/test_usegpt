package net.mooctest;

public class Product {

    private String productId;
    private String name;
    private double price;
    private int quantity;

    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Restock amount must be positive.");
        }
        quantity += amount;
    }

    public void sell(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Sell amount must be positive.");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Insufficient quantity in stock.");
        }
        quantity -= amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}