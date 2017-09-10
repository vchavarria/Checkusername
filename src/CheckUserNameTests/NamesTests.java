package CheckUserNameTests;

import org.junit.Assert;
import org.junit.Test;

import checkusername.Result;
import checkusername.UserValidations;

public class NamesTests {

	String name;
	String[] actual;
	String[] existingUsers = { "johnjohn", "arieljones", "john3456" };
	String[] restrictedWords = { "cannabis", "abuse", "crack", "dam", "drunk", "grass" };

	@Test
	public void UserIsTaken() {
		String[] expected = { "johnjohn1", "johnjohn2", "johnjohn3", "johnjohn4", "johnjohn5", "johnjohn6", "johnjohn7",
				"johnjohn8", "johnjohn9", "johnjohn10", "johnjohn11", "johnjohn12", "johnjohn13", "johnjohn14" };

		name = "johnjohn";
		Result result = UserValidations.checkUserName(name, existingUsers, restrictedWords);
		actual = result.names;

		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void UserIsNotTaken() {
		String[] expected = {};

		name = "123456";
		Result result = UserValidations.checkUserName(name, existingUsers, restrictedWords);
		actual = result.names;

		Assert.assertArrayEquals(expected, actual);
	}
}
