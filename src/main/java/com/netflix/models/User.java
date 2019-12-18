package com.netflix.models;

import com.netflix.database.Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public class User implements Serializable {
    private UserMode mode;
    private UUID id;
    private String username;
    private String password;

    private Map<String, Media> list;

    public User() {
        this.id = UUID.randomUUID();
        this.mode = UserMode.ANONYM;
    }
    public User(String username, String password, UserMode mode) {
        this.id = UUID.randomUUID();
        this.mode = mode;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public static boolean userExists(String username) {
        Database db = new Database("./db");
        try {
            db.get(username);
        } catch (FileNotFoundException e) {
            System.out.println("User no exist");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void save() {

    }

    /**
     * Needed?
     */
    public void load() {

    }

    public void logout(){
        // Save values
        this.save();

        // Reset default values and set mode to anon
        this.id = UUID.randomUUID();
        this.mode = UserMode.ANONYM;
        this.username = null;
        this.password = null;
        this.list = null;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public static User login(String username, String password){
        // Check if username exist
        if (!User.userExists(username)) throw new RuntimeException("User don't exists");

        // Check if password match
        Database db = new Database("./db");

        User user = new User();

        try {
            user = (User)db.get(username);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!user.checkPassword(password)) throw new RuntimeException("wrong password");

        // Elevate user
        return user;
    }

    public void register(String username, String password) {
        // Check if user already exists
        if (this.userExists(username)) {
            System.out.println("User already exists");
        }

        // Create user

        // Elevate permissions
    }

    public Map<String, Media> getList(){
        return this.list;
    }

    public void addToList(String key, Media media) {
        this.list.put(key, media);
    }

    public void removeFromList(String key) {
        this.list.remove(key);
    }
}
