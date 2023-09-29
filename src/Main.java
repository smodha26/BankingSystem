import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginController(new LoginUI(),bank);
            }
        });
    }
}
