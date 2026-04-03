package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Farah Alhabib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "223803449";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Farah Alhabib";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
	
	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login("abc", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}

	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}

	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testSuccessCorrectUsernameAndCorrectPassword()
	{
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertEquals("123456", status.getErrorMsg());
	}

	@Test
	public void testFailEmptyValidationCode()
	{
		boolean result = LoginForm.validateCode(null);
		Assert.assertFalse(result);
	}

	@Test
	public void testFailWrongValidationCode()
	{
		boolean result = LoginForm.validateCode("abcd");
		Assert.assertFalse(result);
	}

	@Test
	public void testSuccessCorrectValidationCode()
	{
		boolean result = LoginForm.validateCode("123456");
		Assert.assertTrue(result);
	}
	@Test
	public void testSuccessCorrectLoginWithOutput()
	{
	    LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");

	    System.out.println("Student: Farah Alhabib (223803449)");
	    System.out.println("Test: Correct login");
	    System.out.println("Result: " + status.getErrorMsg());

	    Assert.assertTrue(status.isLoginSuccess());
	    Assert.assertEquals("123456", status.getErrorMsg());
	}
}