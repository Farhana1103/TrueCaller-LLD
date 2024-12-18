package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String number) {
        contacts.add(new Contact(name, number));
        System.out.println("Contact added: " + name + " - " + number);
    }

    public void importContacts(String filePath) {
        System.out.println("Contacts imported from: " + filePath);
    }

    public void blockContact(String number) {
        System.out.println("Contact blocked: " + number);
    }

    public void unblockContact(String number) {
        System.out.println("Contact unblocked: " + number);
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

    public Contact searchContactByNumber(String number) {
        for (Contact contact : contacts) {
            if (contact.getNumber().equals(number)) {
                return contact;
            }
        }
        System.out.println("Contact not found: " + number);
        return null;
    }

    public void addBusiness(String name, String number, String website, String email) {
        System.out.println("Business added: " + name + " - " + number + " - " + website + " - " + email);
    }

    public String searchGlobalDirectory(String name) {
        return "Global Directory result for: " + name;
    }
}
