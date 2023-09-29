import javax.swing.*;
import java.awt.*;

public class BankingPlatformUI extends JFrame {
    public BankingPlatformUI() {
        setTitle("Bank Platform for "); //+ individual.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel balanceLabel = new JLabel("Current Balance:");
        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField(10);

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(balanceLabel, gbc);

        gbc.gridy = 1;
        panel.add(amountLabel, gbc);

        gbc.gridy = 2;
        panel.add(withdrawButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("$0.00"), gbc);

        gbc.gridy = 1;
        panel.add(amountField, gbc);

        gbc.gridy = 2;
        panel.add(depositButton, gbc);

        add(panel);

        setVisible(true);
    }
}