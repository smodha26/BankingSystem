import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginUI loginUI;
    private Bank bank;

    public LoginController(LoginUI loginUI, Bank bank) {
        this.loginUI = loginUI;
        this.bank=bank;
        loginUI.getConnectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginUI.getUsernameField().getText();
                String password = new String(loginUI.getPasswordField().getPassword());

                boolean usernameExists = bank.getLoginHashMap().containsKey(username);
                boolean loginSuccess = usernameExists && bank.getLoginHashMap().get(username).equals(password);

                //We verify if the information is correct
                if(loginSuccess){
                    JOptionPane.showMessageDialog(loginUI.getFrame(), "Connection success!");

                    //Set the singleton for the current user
                    CurrentUserSingleton.getInstance().setCurrentUser(bank.getTestIndividual());

                    // Open the BankingPlatformUI when the login is successful
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new BankingPlatformUI();
                        }
                    });
                }

                else JOptionPane.showMessageDialog(loginUI.getFrame(), "Error : Wrong username or password...");

            }
        });
    }
}
