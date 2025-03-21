package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the "Update Product" dashboard
public class UpdateProductDashboard extends JFrame {
    private InventoryManager inventory;

    public UpdateProductDashboard(InventoryManager inventory) {
        this.inventory = inventory;
        setTitle("Update Product");
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the form
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Update Product Section
        JLabel idLabel = new JLabel("Product ID:");
        JTextField idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel quantityLabel = new JLabel("New Quantity:");
        JTextField quantityField = new JTextField();
        panel.add(quantityLabel);
        panel.add(quantityField);

        JButton updateButton = new JButton("Update");
        panel.add(updateButton);

        // Update Button Action
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values and update the product
                int id = Integer.parseInt(idField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                inventory.updateProduct(id, quantity);
                JOptionPane.showMessageDialog(null, "Product updated successfully!");
                // Clear the input fields
                idField.setText("");
                quantityField.setText("");
            }
        });

        // Add the panel to the frame
        add(panel);
    }
}