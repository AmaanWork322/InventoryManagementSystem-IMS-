package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the login screen and role selection
public class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel for the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        // Admin Button: Grants full access
        JButton adminButton = new JButton("Login as Admin");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(true).setVisible(true); // Admin has full access
                dispose(); // Close the login screen
            }
        });
        panel.add(adminButton);

        // User Button: Grants limited access
        JButton userButton = new JButton("Login as User");
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(false).setVisible(true); // User has limited access
                dispose(); // Close the login screen
            }
        });
        panel.add(userButton);

        // Add the panel to the frame
        add(panel);
    }

    // Main method to start the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}