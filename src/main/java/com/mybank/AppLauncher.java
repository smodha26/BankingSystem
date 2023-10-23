package com.mybank;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            String jsonDatabaseFilePath = "src/main/java/com/mybank/user_accounts.json";
            public void run() {
                new LoginController(new LoginUI(), jsonDatabaseFilePath);
            }
        });
    }
}
