package main.java;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginController(new LoginUI(),new Bank());
            }
        });
    }
}
