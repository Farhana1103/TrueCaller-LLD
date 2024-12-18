package services;

import contacts.ContactManager;

public class SpamDetection {
    private ContactManager contactManager;

    // Constructor accepting ContactManager as a parameter
    public SpamDetection(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    public ContactManager getContactManager() {
        return contactManager;
    }

    public boolean isSpam(String number) {
        // Example logic: Check if the contact is reported as spam in the ContactManager
        System.out.println("Checking if number is spam: " + number);
        return number.startsWith("987"); // Replace with actual spam detection logic
    }
}
