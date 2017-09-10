package CheckUserNameTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import checkusername.Result;
import checkusername.UserValidations;

public class IsValidTests {
	boolean expected;
	String name;
	boolean actual;
	String[] existingUsers = { "johnjohn", "arieljones", "john3456" };
	String[] restrictedWords = { "cannabis", "abuse", "crack", "dam", "drunk", "grass" };

	@Test
	public void HappyPath() {
		expected = true;

		name = "1234567";
		Result result = UserValidations.checkUserName(name, existingUsers, restrictedWords);
		actual = result.isValid;

		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void InvalidUserName() {

		name = "12345";
		UserValidations.checkUserName(name, existingUsers, restrictedWords);

	}

	@Test
	public void UserNameContainsRestrictedWords() {
		expected = false;

		name = "johndamn";
		Result result = UserValidations.checkUserName(name, existingUsers, restrictedWords);
		actual = result.isValid;

		assertEquals(expected, actual);
	}

	@Test
	public void UserNameTaken() {
		expected = false;

		name = "arieljones";
		Result result = UserValidations.checkUserName(name, existingUsers, restrictedWords);
		actual = result.isValid;

		assertEquals(expected, actual);
	}
}