import java.util.HashMap;

public class Bank {
     private HashMap<String, String> bankHashmap;

     public Bank(){
         bankHashmap = new HashMap<>();
         //I inserted a data just to verify the logic of the login
         bankHashmap.put("test","test");
     }

     public HashMap<String, String> getBankHashmap() {
         return bankHashmap;
     }

}
