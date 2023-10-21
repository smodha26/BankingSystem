package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankingPlatformController {
    private BankingPlatformUI bankingPlatformUI;
    private Individual individual = CurrentUserSingleton.getInstance().getCurrentUser();
    private float amount;

    public BankingPlatformController(BankingPlatformUI bankingPlatformUI) {
        this.bankingPlatformUI = bankingPlatformUI;

        // Attach action listeners to withdraw and deposit buttons
        bankingPlatformUI.getWithdrawButton().addActionListener(new WithdrawButtonListener());
        bankingPlatformUI.getDepositButton().addActionListener(new DepositButtonListener());
    }

    private class WithdrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TextField must not be empty, and it must only have float number
            String input = bankingPlatformUI.getAmountField().getText().trim();

            if(!input.isEmpty()){
                // Get the amount from textField and parse it into Float for the calcul
                amount = Float.parseFloat(bankingPlatformUI.getAmountField().getText());
                boolean sufficientAmount = individual.getBalance()-amount>=0;

                try{
                    //Verify if the number entered is not negative
                    if(amount >= 0){
                        //Verify if user has enough amount in balance to withdraw the requested amount
                        if(sufficientAmount){
                            withdrawBalance();
                            putDataIntoTransactionHistory("Withdraw",amount);
                        }
                        else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: Current balance is insufficient");
                    }
                    else if(amount < 0){
                        JOptionPane.showMessageDialog(bankingPlatformUI, "Error: Please enter a non-negative amount");
                    }
                    else throw new NumberFormatException("Error: Invalid input, please enter a valid number.");
                }catch(NumberFormatException exception){
                    JOptionPane.showMessageDialog(bankingPlatformUI, exception.getMessage());
                }
            }
            else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: field cannot be empty");
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TextField must not be empty, and it must only have float number
            String input = bankingPlatformUI.getAmountField().getText().trim();

            if(!input.isEmpty()){
                // Get the amount from textField and parse it into Float for the calcul
                amount = Float.parseFloat(bankingPlatformUI.getAmountField().getText());

                try{
                    //Verify if the number entered is not negative
                    if(amount >= 0){
                        depositBalance();
                        putDataIntoTransactionHistory("Deposit",amount);
                    }
                    else if(amount < 0){
                        JOptionPane.showMessageDialog(bankingPlatformUI, "Error: Please enter a non-negative amount");
                    }
                    else throw new NumberFormatException("Error: Invalid input, please enter a valid number.");
                }catch(NumberFormatException exception){
                    JOptionPane.showMessageDialog(bankingPlatformUI, exception.getMessage());
                }
            }
            else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: field cannot be empty");
        }
    }

    private void withdrawBalance(){
        // Modify new Balance by calling the current individual (singleton)
        individual.setBalance(individual.getBalance()-amount);
        bankingPlatformUI.setCurrentBalanceLabel(String.valueOf(individual.getBalance()));
        JOptionPane.showMessageDialog(bankingPlatformUI, "Successful transaction");
    }

    private void depositBalance(){
        // Modify new Balance by calling the current individual (singleton)
        individual.setBalance(individual.getBalance()+amount);
        bankingPlatformUI.setCurrentBalanceLabel(String.valueOf(individual.getBalance()));
        JOptionPane.showMessageDialog(bankingPlatformUI, "Successful transaction");
    }

    private void putDataIntoTransactionHistory(String transactionType, float amount){
        DateTimeFormatter realTime = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm");
        Object[] rowData = {LocalDateTime.now().format(realTime), transactionType, amount};
        bankingPlatformUI.getTableModel().addRow(rowData);
        bankingPlatformUI.getTableModel().fireTableDataChanged();
    }
}
