package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LoginService {

    private static final String VALID_USERNAME = "farah";
    private static final String VALID_PASSWORD = "farah_pass";
    private static final String VALID_DOB = "2003-07-13";

    public static boolean login(String username, String password, String dob) {

        if (username == null || username.trim().isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        if (!isValidDob(dob)) return false;

        return VALID_USERNAME.equals(username.trim())
                && VALID_PASSWORD.equals(password)
                && VALID_DOB.equals(dob);
    }

    private static boolean isValidDob(String dob) {
        if (dob == null || dob.trim().isEmpty()) return false;

        try {
            LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);

            if (date.isAfter(LocalDate.now())) return false;
            if (date.getYear() < 1900) return false;

            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }
}