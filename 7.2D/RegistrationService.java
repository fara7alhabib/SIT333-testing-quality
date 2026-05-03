package web.service;

/**
 * Business logic to handle registration functions.
 */
public class RegistrationService {

    public static boolean register(String fName, String lName, String email, String dob) {

        System.out.println("First name: " + fName);
        System.out.println("Last name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("DoB (yyyy-mm-dd): " + dob);

        if (fName == null || fName.trim().isEmpty()) {
            return false;
        }

        if (lName == null || lName.trim().isEmpty()) {
            return false;
        }

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        if (dob == null || dob.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}