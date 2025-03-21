package com.inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Manages the inventory and handles file operations
public class InventoryManager {
    private List<Product> productList; // List to store products
    private static final String FILE_NAME = "inventory.txt"; // File to save/load data

    // Constructor: Initializes the inventory and loads data from file
    public InventoryManager() {
        this.productList = new ArrayList<>();
        loadFromFile(); // Load data when the program starts
    }

    // Add a product to the inventory
    public void addProduct(Product product) {
        productList.add(product);
        saveToFile(); // Save data after adding a product
    }

    // Update the quantity of a product
    public void updateProduct(int productID, int quantity) {
        for (Product p : productList) {
            if (p.getProductID() == productID) {
                p.setQuantity(quantity);
                saveToFile(); // Save data after updating a product
                return;
            }
        }
    }

    // Delete a product from the inventory
    public void deleteProduct(int productID) {
        productList.removeIf(p -> p.getProductID() == productID);
        saveToFile(); // Save data after deleting a product
    }

    // View the current inventory
    public void viewInventory() {
        if (productList.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            for (Product p : productList) {
                System.out.println(p.getProductDetails());
            }
        }
    }

    // Generate a low-stock report
    public void generateReport() {
        System.out.println("Low-Stock Report:");
        for (Product p : productList) {
            if (p.getQuantity() < 10) {
                System.out.println(p.getProductDetails());
            }
        }
    }

    // Get the list of products
    public List<Product> getProductList() {
        return productList;
    }

    // Save inventory data to a file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : productList) {
                // Write product details to the file in a specific format
                writer.write(p.getProductID() + "|" + p.getName() + "|" + p.getQuantity() + "|" + p.getPrice() + "|" + p.getCategory());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    // Load inventory data from a file
    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts and create a Product object
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);
                String category = parts[4];
                productList.add(new Product(id, name, quantity, price, category));
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
        }
    }
}