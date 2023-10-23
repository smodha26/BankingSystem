package com.mybank;

import javax.swing.*;
import java.awt.*;

public class CreateAccountUI{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private JFrame frame;

    public CreateAccountUI() {
        frame = new JFrame("Create Your Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridLayout(4, 2));

        JLabel titleLabel = new JLabel("Create your account !");
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        signupButton = new JButton("Signup");

        frame.add(titleLabel);
        frame.add(new JLabel());
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(signupButton);

        frame.setVisible(true);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getSignupButton(){
        return signupButton;
    }

    public JFrame getFrame(){
        return frame;
    }
}

