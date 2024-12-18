package services;

import java.util.HashSet;
import java.util.Set;

public class GlobalDirectory {
    // A Set to store the names of registered users
    private Set<String> registeredUsers = new HashSet<>();

    // Method to register a user
    public void register(String name, String number) {
        // Add the user's name to the registered users set
        registeredUsers.add(name);
        System.out.println(name + " has been registered in the global directory.");
    }

    // Method to check if a user is already registered
    public boolean isUserRegistered(String name) {
        return registeredUsers.contains(name); // Check if the user is already in the registered set
    }
}
