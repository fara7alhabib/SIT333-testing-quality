package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("farah", "farah_pass", "2003-07-13"));
    }

    @Test
    public void testWrongUsername() {
        Assert.assertFalse(LoginService.login("wrong", "farah_pass", "2003-07-13"));
    }

    @Test
    public void testWrongPassword() {
        Assert.assertFalse(LoginService.login("farah", "wrong", "2003-07-13"));
    }

    @Test
    public void testWrongDob() {
        Assert.assertFalse(LoginService.login("farah", "farah_pass", "2000-01-01"));
    }

    @Test
    public void testEmptyFields() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }
}