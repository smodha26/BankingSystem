import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            //TODO : Note : implement a logic that only allows float in the "IF" (no special caracter or letters)

            //TextField must not be empty, and it must only have float
            if(!bankingPlatformUI.getAmountField().getText().trim().isEmpty()){
                // Get the amount from textField and parse it into Float for the calcul
                amount = Float.parseFloat(bankingPlatformUI.getAmountField().getText());

                //Verify if user has enough amount in balance to withdraw the requested amount
                if(individual.getBalance()-amount>=0){
                    // Modify new Balance by calling the current individual (singleton)
                    individual.setBalance(individual.getBalance()-amount);
                    bankingPlatformUI.setCurrentBalanceLabel(String.valueOf(individual.getBalance()));
                    JOptionPane.showMessageDialog(bankingPlatformUI, "Successful transaction");
                }
                else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: Current balance is insufficient");
            }
            else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: field cannot be empty");
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO : Note : implement a logic that only allows float in the "IF" (no special caracter or letters)

            //TextField must not be empty, and it must only have float
            if(!bankingPlatformUI.getAmountField().getText().trim().isEmpty()){
                // Get the amount from textField and parse it into Float for the calcul
                amount = Float.parseFloat(bankingPlatformUI.getAmountField().getText());

                // Modify new Balance by calling the current individual (singleton)
                individual.setBalance(individual.getBalance()+amount);
                bankingPlatformUI.setCurrentBalanceLabel(String.valueOf(individual.getBalance()));
                JOptionPane.showMessageDialog(bankingPlatformUI, "Successful transaction");
            }
            else JOptionPane.showMessageDialog(bankingPlatformUI, "Error: field cannot be empty");
        }
    }
}
