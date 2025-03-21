package com.inventory;

// Represents a product in the inventory
public class Product {
    private int productID;
    private String name;
    private int quantity;
    private double price;
    private String category;

    // Constructor to initialize a product
    public Product(int productID, String name, int quantity, double price, String category) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters for product attributes
    public int getProductID() { return productID; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // Method to display product details as a string
    public String getProductDetails() {
        return "ID: " + productID + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price + ", Category: " + category;
    }
}