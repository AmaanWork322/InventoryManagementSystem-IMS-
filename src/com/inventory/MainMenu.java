package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the main menu and restricts access based on the user role
public class MainMenu extends JFrame {
    private InventoryManager inventory;

    public MainMenu(boolean isAdmin) {
        this.inventory = new InventoryManager();
        setTitle("Inventory Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        // Add Product Button (Admin only)
        JButton addButton = new JButton("Add Product");
        addButton.setEnabled(isAdmin); // Disable for users
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductDashboard(inventory).setVisible(true);
            }
        });
        panel.add(addButton);

        // Update Product Button (Admin only)
        JButton updateButton = new JButton("Update Product");
        updateButton.setEnabled(isAdmin); // Disable for users
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProductDashboard(inventory).setVisible(true);
            }
        });
        panel.add(updateButton);

        // Delete Product Button (Admin only)
        JButton deleteButton = new JButton("Delete Product");
        deleteButton.setEnabled(isAdmin); // Disable for users
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteProductDashboard(inventory).setVisible(true);
            }
        });
        panel.add(deleteButton);

        // View Inventory Button (Both Admin and User)
        JButton viewButton = new JButton("View Inventory");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInventoryDashboard(inventory).setVisible(true);
            }
        });
        panel.add(viewButton);

        // Generate Report Button (Admin only)
        JButton reportButton = new JButton("Generate Report");
        reportButton.setEnabled(isAdmin); // Disable for users
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GenerateReportDashboard(inventory).setVisible(true);
            }
        });
        panel.add(reportButton);

        // Add the panel to the frame
        add(panel);
    }
}