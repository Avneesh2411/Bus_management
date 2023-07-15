```java
package com.busmanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class App {

    private static Connection connection;
    private static User currentUser;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                connection = DatabaseConnection.getConnection();
                displayLoginScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void displayLoginScreen() {
        JFrame frame = new JFrame("Bus Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginScreen loginScreen = new LoginScreen(connection, App::login);
        frame.add(loginScreen, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static void login(User user) {
        currentUser = user;
        displayBusInfoScreen();
    }

    private static void displayBusInfoScreen() {
        JFrame frame = new JFrame("Bus Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BusInfoScreen busInfoScreen = new BusInfoScreen(connection, currentUser, App::logout);
        frame.add(busInfoScreen, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static void logout() {
        currentUser = null;
        displayLoginScreen();
    }
}
```