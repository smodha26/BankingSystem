import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private Individual testIndividual;
    private ArrayList<Individual> individualList;
    private HashMap<String,String> loginHashMap = new HashMap<>();

    public Bank(){
        //Create the test individual to see if the login logic works
        testIndividual = new Individual("test","test");
        //Create the List that will act like a quick database
        individualList = new ArrayList<>();
        //Add the test individual to the list
        individualList.add(testIndividual);
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

    public ArrayList<Individual> getIndividualList() {
        return individualList;
    }
}
