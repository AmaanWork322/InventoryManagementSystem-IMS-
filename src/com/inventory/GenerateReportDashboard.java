package com.inventory;

import javax.swing.*;
import java.awt.*;

// Handles the "Generate Report" dashboard
public class GenerateReportDashboard extends JFrame {
    private InventoryManager inventory;

    public GenerateReportDashboard(InventoryManager inventory) {
        this.inventory = inventory;
        setTitle("Generate Report");
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the window

        // Create a text area to display the report
        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Generate and display the report
        reportArea.append("Low-Stock Report:\n");
        for (Product p : inventory.getProductList()) {
            if (p.getQuantity() < 10) {
                reportArea.append(p.getProductDetails() + "\n");
            }
        }

        // Add the text area to the frame
        add(scrollPane);
    }
}