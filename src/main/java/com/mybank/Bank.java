package com.mybank;

import java.util.HashMap;

public class Bank {

    private User testUser;
    private HashMap<String,String> loginHashMap = new HashMap<>();

    public Bank(){
        //Create the test individual to see if the login logic works since we don't have a DataBase
        testUser = new User("Bob","test");

        //Add the individual username and password to the hashmap to verify login
        loginHashMap.put(testUser.getUsername(), testUser.getPassword());
    }

    public User getTestIndividual() {
        return testUser;
    }

    public HashMap<String, String> getLoginHashMap() {
        return loginHashMap;
    }
}
