import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginUI loginUI;

    public LoginController(LoginUI loginUI) {
        this.loginUI = loginUI;
        loginUI.getConnectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginUI.getUsernameField().getText();
                String password = new String(loginUI.getPasswordField().getPassword());

                // Replace this logic with your authentication logic
                JOptionPane.showMessageDialog(loginUI.getFrame(), "Do something");

            }
        });
    }
}
