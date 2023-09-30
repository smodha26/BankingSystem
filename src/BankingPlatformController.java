import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingPlatformController {
    private BankingPlatformUI bankingPlatformUI;

    public BankingPlatformController(BankingPlatformUI bankingPlatformUI) {
        this.bankingPlatformUI = bankingPlatformUI;

        // Attach action listeners to withdraw and deposit buttons
        bankingPlatformUI.getWithdrawButton().addActionListener(new WithdrawButtonListener());
        bankingPlatformUI.getDepositButton().addActionListener(new DepositButtonListener());
    }

    private class WithdrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO : Verify if user has enough amount in balance to withdraw the requested amount
            //TODO :If yes, change current balance and send success message
            //TODO : Note : implement a logic that only allows float

            //TODO : if not, send an error message
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO : Note : implement a logic that only allows float


        }
    }
}
