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

                boolean usernameExists = bank.getBankHashmap().containsKey(username);

                //We verify if the information is correct
                if(usernameExists && bank.getBankHashmap().get(username).equals(password)){
                    JOptionPane.showMessageDialog(loginUI.getFrame(), "Goodjob!");
                }
                else JOptionPane.showMessageDialog(loginUI.getFrame(), "try again");

            }
        });
    }
}
