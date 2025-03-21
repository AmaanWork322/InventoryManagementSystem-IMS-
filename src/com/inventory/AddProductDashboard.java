package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the "Add Product" dashboard
public class AddProductDashboard extends JFrame {
    private InventoryManager inventory;

    public AddProductDashboard(InventoryManager inventory) {
        this.inventory = inventory;
        setTitle("Add Product");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the form
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Add Product Section
        JLabel idLabel = new JLabel("Product ID:");
        JTextField idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();
        panel.add(quantityLabel);
        panel.add(quantityField);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();
        panel.add(priceLabel);
        panel.add(priceField);

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();
        panel.add(categoryLabel);
        panel.add(categoryField);

        JButton addButton = new JButton("Add");
        panel.add(addButton);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values and add a new product
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String category = categoryField.getText();

                inventory.addProduct(new Product(id, name, quantity, price, category));
                JOptionPane.showMessageDialog(null, "Product added successfully!");
                // Clear the input fields
                idField.setText("");
                nameField.setText("");
                quantityField.setText("");
                priceField.setText("");
                categoryField.setText("");
            }
        });

        // Add the panel to the frame
        add(panel);
    }
}