package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the "Delete Product" dashboard
public class DeleteProductDashboard extends JFrame {
    private InventoryManager inventory;

    public DeleteProductDashboard(InventoryManager inventory) {
        this.inventory = inventory;
        setTitle("Delete Product");
        setSize(400, 150);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the form
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        // Delete Product Section
        JLabel idLabel = new JLabel("Product ID:");
        JTextField idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JButton deleteButton = new JButton("Delete");
        panel.add(deleteButton);

        // Delete Button Action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input value and delete the product
                int id = Integer.parseInt(idField.getText());

                inventory.deleteProduct(id);
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
                // Clear the input field
                idField.setText("");
            }
        });

        // Add the panel to the frame
        add(panel);
    }
}