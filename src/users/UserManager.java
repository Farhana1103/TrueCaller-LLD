package users;

import services.GlobalDirectory;

public class UserManager {
    private GlobalDirectory globalDirectory = new GlobalDirectory();

    public void registerUser(String name, String email, String password, UserPlan plan) {
        System.out.println("User registered: " + name + " with plan " + plan);
        globalDirectory.register(name, email);
    }

    public void upgradeToPremium(String name) {
        System.out.println(name + " has been upgraded to PREMIUM.");
    }

    public void upgradeToBusiness(String name, String website, String email, String businessDetails) {
        System.out.println(name + " has been upgraded to BUSINESS.");
        System.out.println("Business Details: Website: " + website + ", Email: " + email + ", Info: " + businessDetails);
    }

    public boolean requestLocationAccess(String name, String number) {
        return true; // Location access is available for premium and business users
    }

    public void registerWithGlobalDirectory(String name) {
        if (!globalDirectory.isUserRegistered(name)) {
            globalDirectory.register(name, "Registered");
        }
    }
}
