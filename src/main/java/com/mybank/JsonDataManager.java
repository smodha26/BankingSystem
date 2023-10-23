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

    public boolean authenticateUser(String username, String password){
        try {
            // Read the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(this.file);
            JsonNode root = objectMapper.readTree(jsonFile);

            if (root.isArray()) {
                for (JsonNode userNode : root) {
                    String jsonUsername = userNode.get("username").asText();
                    if (jsonUsername.equals(username.toLowerCase())) {
                        // Username matches, now check the password
                        String jsonPassword = userNode.get("password").asText();
                        if (jsonPassword.equals(password)) {
                            // Password matches, return true for successful authentication
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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
        System.out.println(jsonDataManager.authenticateUser("bob","test"));
    }
}
