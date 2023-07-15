```java
package com.busmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel loginStatusLabel;

    public LoginScreen() {
        setLayout(new FlowLayout());

        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");
        loginStatusLabel = new JLabel("", JLabel.CENTER);

        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(loginStatusLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_management", "root", "password");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'");

                    if (resultSet.next()) {
                        User user = new User(resultSet.getString("username"), resultSet.getString("password"));
                        new BusInfoScreen(user);
                        dispose();
                    } else {
                        loginStatusLabel.setText("Login failed. Please try again.");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}
```