package services;

import contacts.ContactManager;
import contacts.Contact;

public class CallerIdentification {
    private ContactManager contactManager;

    public CallerIdentification(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    public String identifyCaller(String number) {
        Contact contact = contactManager.searchContactByNumber(number);
        if (contact != null) {
            return contact.getName() + " - " + contact.getNumber();
        }
        return "Unknown Caller: " + number;
    }
}
