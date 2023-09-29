import javax.swing.*;
import java.awt.*;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton connectButton;

    public LoginUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2));


        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        connectButton = new JButton("Connect");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
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

    public JFrame getFrame() {
        return frame;
    }
}
