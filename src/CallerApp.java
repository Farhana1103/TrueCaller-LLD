import contacts.Contact;
import contacts.ContactManager;
import services.SpamDetection;
import users.UserManager;
import users.UserPlan;

public class CallerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Caller App!");

        // Initialize application services
        UserManager userManager = new UserManager();
        ContactManager contactManager = new ContactManager();
        SpamDetection spamDetectionService = new SpamDetection(contactManager);

        // User registration and contact management
        userManager.registerUser("John Doe", "john@example.com", "password123", UserPlan.FREE);
        contactManager.addContact("John Doe", "1234567890");
        contactManager.importContacts("path/to/contacts.csv");

        // Blocking, unblocking, and reporting spam
        contactManager.blockContact("1234567890", "0987654321");
        contactManager.unblockContact("1234567890", "0987654321");
        contactManager.reportSpam("9876543210");

        // Spam detection
        if (spamDetectionService.isSpam("9876543210")) {
            System.out.println("Warning: Suspected spam call from 9876543210");
        }

        // Caller identification
        Contact contact = contactManager.searchContactByNumber("1234567890", "0987654321");
        String callerInfo = (contact != null) 
            ? contact.getName() + " - " + contact.getNumber()
            : "Unknown Caller: 0987654321";
        System.out.println("Caller Info: " + callerInfo);

        // Upgrade user plan
        userManager.upgradeToPremium("John Doe");

        // Handle location access
        boolean locationAccess = userManager.requestLocationAccess("John Doe", "9876543210");
        if (locationAccess) {
            System.out.println("Location access granted for John Doe.");
        } else {
            System.out.println("Location access denied. Free plan limitation.");
        }

        // Search for contacts
        Contact foundByName = contactManager.searchContactByName("John Doe");
        if (foundByName != null) {
            System.out.println("Found contact by name: " + foundByName);
        } else {
            System.out.println("Contact not found by name.");
        }

        Contact foundByNumber = contactManager.searchContactByNumber("1234567890", "0987654321");
        if (foundByNumber != null) {
            System.out.println("Found contact by number: " + foundByNumber);
        } else {
            System.out.println("Contact not found by number.");
        }

        // Add business
        contactManager.addBusiness("Tech Solutions", "9876543210", "www.techsolutions.com", "info@techsolutions.com");

        // Register with global directory
        userManager.registerWithGlobalDirectory("John Doe");

        // Search in global directory
        System.out.println("Global Directory Search Result: " + contactManager.searchGlobalDirectory("Tech Solutions"));

        System.out.println("Spam Detection Service Initialized.");
        System.out.println("Application is now running.");
    }
}
