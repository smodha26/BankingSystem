package com.mybank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

public class JsonDataManager {
    private String file;

    public JsonDataManager(String file){
        this.file = file;
    }

    private boolean doesUsernameExist(String username){
        try {
            // Read the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(this.file);
            JsonNode root = objectMapper.readTree(jsonFile);

            if (root.isArray()) {
                for (JsonNode userNode : root) {
                    //Return true if user exists
                    String jsonUsername = userNode.get("username").asText();
                    if (jsonUsername.equals(username.toLowerCase())) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //test
    public static void main(String[] args) {
        JsonDataManager jsonDataManager = new JsonDataManager("src/main/java/com/mybank/user_accounts.json");
        System.out.println(jsonDataManager.doesUsernameExist("BoB123"));
    }
}
