package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BankingPlatformUI extends JFrame {
    private JLabel balanceLabel;
    private JLabel currentBalanceLabel;
    private JLabel amountLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton depositButton;
    private User user = CurrentUserSingleton.getInstance().getCurrentUser();
    private JTable transactionHistoryTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    private void addColumns(DefaultTableModel tableModel){
        tableModel.addColumn("Time");
        tableModel.addColumn("Transaction Type");
        tableModel.addColumn("Amount");
    }

    public BankingPlatformUI() {
        setTitle("User : " + user.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        balanceLabel = new JLabel("Current Balance:");
        amountLabel = new JLabel("Enter Amount:");
        currentBalanceLabel = new JLabel("0.00 $");
        amountField = new JTextField(20);

        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");

        //Transaction History
        tableModel = new DefaultTableModel();
        addColumns(tableModel);

        transactionHistoryTable = new JTable(tableModel);
        scrollPane = new JScrollPane(transactionHistoryTable);

        //Panel for the UI components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Current Balance Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(balanceLabel, gbc);

        // Enter Amount Label
        gbc.gridy = 1;
        panel.add(amountLabel, gbc);

        // Current Balance Value Label
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(currentBalanceLabel, gbc);

        // Amount Field
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(amountField, gbc);

        // Create a separate panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);

        // Add the button panel
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buttonPanel, gbc);

        // Transaction History Table
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        add(panel);

        setVisible(true);
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getWithdrawButton() {
        return withdrawButton;
    }

    public JButton getDepositButton() {
        return depositButton;
    }
    public DefaultTableModel getTableModel(){ return tableModel; }

    public void setCurrentBalanceLabel(String string){
        currentBalanceLabel.setText(string + " $");
    }
}
