package com.mybank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonDataManager {
    private String file;

    public JsonDataManager(String file){
        this.file = file;
    }

    public String getFile(){
        return file;
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
                    if (jsonUsername.equals(username)) {
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

    public boolean doesUsernameExist(String username){
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

    public void createAccount(String username, String password) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(this.file);
            JsonNode root = objectMapper.readTree(jsonFile);

            // Create a new user object
            ObjectNode newUserNode = objectMapper.createObjectNode();
            newUserNode.put("username", username);
            newUserNode.put("password", password);

            // Append the new user node to the root
            ArrayNode userArray = (ArrayNode) root;
            userArray.add(newUserNode);

            // Write the updated JSON data back to the file with pretty printing
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(jsonFile, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
