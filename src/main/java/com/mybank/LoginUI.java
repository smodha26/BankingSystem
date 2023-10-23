package com.mybank;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton connectButton;
    private JButton signupButton;

    public LoginUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));


        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        connectButton = new JButton("Connect");
        signupButton = new JButton("Signup");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(new JLabel());
        frame.add(signupButton);
        frame.add(connectButton);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JButton getSignupButton() { return signupButton;}

    public JFrame getFrame() {
        return frame;
    }
}
