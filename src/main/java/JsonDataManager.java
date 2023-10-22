package main.java;

import java.util.HashMap;

public class JsonDataManager {

    private Individual testIndividual;
    private HashMap<String,String> loginHashMap = new HashMap<>();

    public JsonDataManager(){
        //Create the test individual to see if the login logic works since we don't have a DataBase
        testIndividual = new Individual("Bob","test");

        //Add the individual username and password to the hashmap to verify login
        loginHashMap.put(testIndividual.getUsername(), testIndividual.getPassword());
    }

    public Individual getTestIndividual() {
        return testIndividual;
    }

    public HashMap<String, String> getLoginHashMap() {
        return loginHashMap;
    }
}
