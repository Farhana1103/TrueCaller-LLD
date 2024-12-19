package services;

import java.util.HashSet;
import java.util.Set;

public class GlobalDirectory {
    private Set<String> registeredUsers = new HashSet<>();

    public void register(String name, String number) {
        registeredUsers.add(name);
        System.out.println(name + " has been registered in the global directory.");
    }

    public boolean isUserRegistered(String name) {
        return registeredUsers.contains(name); 
    }
}
