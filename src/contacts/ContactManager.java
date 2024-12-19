package contacts;

import java.util.*;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();
    private Map<String, Set<String>> blockedContacts = new HashMap<>();

    public void addContact(String name, String number) {
        contacts.add(new Contact(name, number));
        System.out.println("Contact added: " + name + " - " + number);
    }

    public void blockContact(String blockedBy, String blockedTo) {
        blockedContacts.computeIfAbsent(blockedBy, k -> new HashSet<>()).add(blockedTo);
        System.out.println("Contact blocked: " + blockedTo + " by " + blockedBy);
    }

    public void unblockContact(String unblockedBy, String unblockedTo) {
        if (blockedContacts.containsKey(unblockedBy)) {
            Set<String> blockedSet = blockedContacts.get(unblockedBy);
            if (blockedSet.remove(unblockedTo)) {
                System.out.println("Contact unblocked: " + unblockedTo + " by " + unblockedBy);
            } else {
                System.out.println("Contact not found in blocked list: " + unblockedTo);
            }

            // Remove entry if no blocked contacts remain for the user
            if (blockedSet.isEmpty()) {
                blockedContacts.remove(unblockedBy);
            }
        } else {
            System.out.println("No blocked contacts found for user: " + unblockedBy);
        }
    }

    public Contact searchContactByNumber(String user, String number) {
        // Check if the user has blocked the number
        if (blockedContacts.containsKey(user) && blockedContacts.get(user).contains(number)) {
            System.out.println("Access denied. You have blocked this number: " + number);
            return null;
        }

        // Check if the number has blocked the user (mutual blocking)
        if (blockedContacts.containsKey(number) && blockedContacts.get(number).contains(user)) {
            System.out.println("Access denied. This number has blocked you: " + number);
            return null;
        }

        // Search for the contact
        for (Contact contact : contacts) {
            if (contact.getNumber().equals(number)) {
                System.out.println("Contact found: " + contact.getName() + " - " + contact.getNumber());
                return contact;
            }
        }

        System.out.println("Contact not found: " + number);
        return null;
    }

    public void importContacts(String filePath) {
        System.out.println("Contacts imported from: " + filePath);
    }

    public void reportSpam(String number) {
        System.out.println("Spam reported: " + number);
    }

    public Contact searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        System.out.println("Contact not found: " + name);
        return null;
    }

    public void addBusiness(String name, String number, String website, String email) {
        System.out.println("Business added: " + name + " - " + number + " - " + website + " - " + email);
    }

    public String searchGlobalDirectory(String name) {
        return "Global Directory result for: " + name;
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        // Adding contacts
        manager.addContact("Alice", "1111");
        manager.addContact("Bob", "2222");
        manager.addContact("Charlie", "3333");

        // Blocking contacts
        manager.blockContact("1111", "2222"); // Alice blocks Bob
        manager.blockContact("2222", "3333"); // Bob blocks Charlie

        // Searching contacts
        manager.searchContactByNumber("1111", "2222"); // Should deny access since Alice blocked Bob
        manager.searchContactByNumber("2222", "3333"); // Should deny access since Bob blocked Charlie
        manager.searchContactByNumber("1111", "3333"); // Should allow access

        // Unblocking contacts
        manager.unblockContact("1111", "2222");
        manager.searchContactByNumber("1111", "2222"); // Should allow access after unblocking
    }
}
