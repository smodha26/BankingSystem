package com.mybank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginUI loginUI;
    private String jsonDatabaseFilePath;
    private JsonDataManager jsonDataManager;

    public LoginController(LoginUI loginUI, String jsonDatabaseFilePath) {
        this.loginUI = loginUI;
        this.jsonDatabaseFilePath = jsonDatabaseFilePath;
        jsonDataManager = new JsonDataManager(this.jsonDatabaseFilePath);

        // Attach the ActionListener to the connectButton
        loginUI.getConnectButton().addActionListener(new ConnectButtonListener());
        loginUI.getUsernameField().addActionListener(new ConnectButtonListener());
        loginUI.getPasswordField().addActionListener(new ConnectButtonListener());

        // Attach the ActionListener to the signupButton
        loginUI.getSignupButton().addActionListener(new SignupButtonListener());
    }

    private class ConnectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginUI.getUsernameField().getText();
            String password = new String(loginUI.getPasswordField().getPassword());

            if (jsonDataManager.authenticateUser(username,password)) {
                // Display a success message
                JOptionPane.showMessageDialog(loginUI.getFrame(), "Connection success!");
                // Set the current user using a Singleton
                CurrentUserSingleton.getInstance().setCurrentUser(new User(username));
                // Close LoginUI
                loginUI.getFrame().dispose();
                // Open the BankingPlatformUI when the login is successful
                openBankingPlatformUI();
            } else {
                // Display an error message for incorrect login
                JOptionPane.showMessageDialog(loginUI.getFrame(), "Error: Wrong username or password...");
            }
        }
    }

    private class SignupButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                // Create a CreateAccountController instance and pass the CreateAccountUI and as parameters
                new CreateAccountController(new CreateAccountUI(), jsonDataManager);
            });

            loginUI.getFrame().dispose();
        }
    }

    private void openBankingPlatformUI() {
        SwingUtilities.invokeLater(() -> {
            // Create a BankingPlatformController instance and pass the BankingPlatformUI as parameters
            new BankingPlatformController(new BankingPlatformUI());
        });
    }
}
