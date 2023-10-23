package com.mybank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountController {
    private JsonDataManager jsonDataManager;
    private CreateAccountUI createAccountUI;

    public CreateAccountController(CreateAccountUI createAccountUI, JsonDataManager jsonDataManager){
        this.createAccountUI = createAccountUI;
        this.jsonDataManager = jsonDataManager;

        createAccountUI.getSignupButton().addActionListener(new SignupButtonListener());
    }

    private void openLoginUI() {
        SwingUtilities.invokeLater(() -> {
            // Create a BankingPlatformController instance and pass the BankingPlatformUI as parameters
            new LoginController(new LoginUI(), jsonDataManager.getFile());
        });
    }

    private class SignupButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isUsernameFieldEmpty = createAccountUI.getUsernameField().getText().isEmpty();
            boolean isPasswordFieldEmpty = createAccountUI.getPasswordField().getText().isEmpty();

            String username = createAccountUI.getUsernameField().getText();
            String password = createAccountUI.getPasswordField().getText();

            if(isUsernameFieldEmpty){
                JOptionPane.showMessageDialog(createAccountUI.getFrame(), "Error: Username cannot be empty");
            }
            else if(isPasswordFieldEmpty){
                JOptionPane.showMessageDialog(createAccountUI.getFrame(), "Error: Password cannot be empty");
            }
            else {
                if(!jsonDataManager.doesUsernameExist(username)){
                    JOptionPane.showMessageDialog(createAccountUI.getFrame(), "Account created !");

                    jsonDataManager.createAccount(username,password);

                    openLoginUI();
                    createAccountUI.getFrame().dispose();

                }
                else JOptionPane.showMessageDialog(createAccountUI.getFrame(), "Error: Username is taken");
            }
        }
    }


}
