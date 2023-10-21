import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginUI loginUI;
    private Bank bank;

    public LoginController(LoginUI loginUI, Bank bank) {
        this.loginUI = loginUI;
        this.bank = bank;

        // Attach the ActionListener to the connectButton
        loginUI.getConnectButton().addActionListener(new ConnectButtonListener());
    }

    private class ConnectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginUI.getUsernameField().getText();
            String password = new String(loginUI.getPasswordField().getPassword());

            boolean usernameExists = bank.getLoginHashMap().containsKey(username);
            boolean loginSuccess = usernameExists && bank.getLoginHashMap().get(username).equals(password);

            if (loginSuccess) {
                // Display a success message
                JOptionPane.showMessageDialog(loginUI.getFrame(), "Connection success!");

                // Set the current user using a Singleton
                CurrentUserSingleton.getInstance().setCurrentUser(bank.getTestIndividual());

                //Close LoginUI
                loginUI.getFrame().dispose();

                // Open the BankingPlatformUI when the login is successful
                openBankingPlatformUI();
            } else {
                // Display an error message for incorrect login
                JOptionPane.showMessageDialog(loginUI.getFrame(), "Error: Wrong username or password...");
            }
        }
    }

    private void openBankingPlatformUI() {
        SwingUtilities.invokeLater(() -> {
            // Create a BankingPlatformController instance and pass the BankingPlatformUI as parameters
            new BankingPlatformController(new BankingPlatformUI());
        });
    }
}
