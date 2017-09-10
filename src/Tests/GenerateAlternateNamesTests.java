package Tests;

import org.junit.Assert;
import org.junit.Test;

import checkusername.UserValidations;

public class GenerateAlternateNamesTests {
	String userName;
	String[] actual;

	@Test
	public void NoOtherExistingUser() {
		String[] expected = { "johnjohn1", "johnjohn2", "johnjohn3", "johnjohn4", "johnjohn5", "johnjohn6", "johnjohn7",
				"johnjohn8", "johnjohn9", "johnjohn10", "johnjohn11", "johnjohn12", "johnjohn13", "johnjohn14" };

		userName = "johnjohn";
		String[] existingUsers = {};
		actual = UserValidations.generateAlternateNames(userName, existingUsers);

		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void AlternateUserExists() {
		String[] expected = { "johnjohn2", "johnjohn3", "johnjohn4", "johnjohn5", "johnjohn6", "johnjohn7", "johnjohn8",
				"johnjohn9", "johnjohn10", "johnjohn11", "johnjohn12", "johnjohn13", "johnjohn14", "johnjohn15" };

		userName = "johnjohn";
		String[] existingUsers = { "johnjohn", "johnjohn1" };
		actual = UserValidations.generateAlternateNames(userName, existingUsers);

		Assert.assertArrayEquals(expected, actual);
	}

}
