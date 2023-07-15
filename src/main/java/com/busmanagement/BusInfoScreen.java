```java
package com.busmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusInfoScreen extends JFrame {
    private JLabel busNumberLabel;
    private JLabel routeLabel;
    private JButton logoutButton;
    private Connection connection;

    public BusInfoScreen(User user) {
        setLayout(new FlowLayout());

        busNumberLabel = new JLabel();
        routeLabel = new JLabel();
        logoutButton = new JButton("Logout");

        add(busNumberLabel);
        add(routeLabel);
        add(logoutButton);

        displayBusInfo(user);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginScreen();
            }
        });

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayBusInfo(User user) {
        try {
            String query = "SELECT * FROM Bus WHERE userId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Bus bus = new Bus(resultSet.getInt("busNumber"), new Route(resultSet.getString("route")));
                busNumberLabel.setText("Bus Number: " + bus.getBusNumber());
                routeLabel.setText("Route: " + bus.getRoute().getRouteInfo());
            } else {
                busNumberLabel.setText("No bus information available.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
```