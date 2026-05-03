package web.service;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceTest {

    // Normal case
    @Test
    public void testValidRegistration() {
        boolean result = RegistrationService.register("Farah", "Ali", "farah@gmail.com", "2000-01-01");
        Assert.assertTrue(result);
    }

    // Empty first name
    @Test
    public void testEmptyFirstName() {
        boolean result = RegistrationService.register("", "Ali", "farah@gmail.com", "2000-01-01");
        Assert.assertFalse(result);
    }

    // Invalid email
    @Test
    public void testInvalidEmail() {
        boolean result = RegistrationService.register("Farah", "Ali", "farahgmail.com", "2000-01-01");
        Assert.assertFalse(result);
    }

    // Empty DOB
    @Test
    public void testEmptyDOB() {
        boolean result = RegistrationService.register("Farah", "Ali", "farah@gmail.com", "");
        Assert.assertFalse(result);
    }
}