import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginUI loginUI = new LoginUI();
                new LoginController(loginUI,bank);
            }
        });
    }
}
