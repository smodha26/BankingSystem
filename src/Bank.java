import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private Individual testIndividual;
    private HashMap<String,String> loginHashMap = new HashMap<>();

    public Bank(){
        //Create the test individual to see if the login logic works since we don't have a DataBase
        testIndividual = new Individual("Bob","test");

        //Add the individual username and password to the hashmap to verify login
        loginHashMap.put(testIndividual.getUsername(), testIndividual.getPassword());
    }

    public void depositBalance(float amount, Individual individual){
        individual.setBalance(individual.getBalance() + amount);
    }

    public void withdrawBalance(float amount, Individual individual){
        individual.setBalance(individual.getBalance() - amount);
    }

    public Individual getTestIndividual() {
        return testIndividual;
    }

    public HashMap<String, String> getLoginHashMap() {
        return loginHashMap;
    }
}
