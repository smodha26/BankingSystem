package com.mybank;

public class User {

    private String username;

    private float balance = 0;

    public User(String username){
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
