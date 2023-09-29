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

                //We verify if the information is correct
                if(usernameExists && bank.getLoginHashMap().get(username).equals(password)){
                    JOptionPane.showMessageDialog(loginUI.getFrame(), "Connection success!");
                }

                else JOptionPane.showMessageDialog(loginUI.getFrame(), "Error : Wrong username or password...");

            }
        });
    }
}
