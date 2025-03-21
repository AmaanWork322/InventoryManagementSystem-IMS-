package com.inventory;

import javax.swing.*;
import java.awt.*;

// Handles the "View Inventory" dashboard
public class ViewInventoryDashboard extends JFrame {
    private InventoryManager inventory;

    public ViewInventoryDashboard(InventoryManager inventory) {
        this.inventory = inventory;
        setTitle("View Inventory");
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the window

        // Create a text area to display the inventory
        JTextArea inventoryArea = new JTextArea();
        inventoryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventoryArea);

        // Display the inventory
        for (Product p : inventory.getProductList()) {
            inventoryArea.append(p.getProductDetails() + "\n");
        }

        // Add the text area to the frame
        add(scrollPane);
    }
}