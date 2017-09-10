package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import checkusername.UserValidations;

public class UserNameIsTakenTests {

	boolean expected;
	boolean actual;
	String name;
	String userNames[] = { "johnjohn", "arieljones", "john3456", "johnjohn1" };

	@Test
	public void NewOne() {
		expected = false;
		name = "oscaroscar";
		actual = UserValidations.userNameIsTaken(userNames, name);
		assertEquals(expected, actual);
	}

	@Test
	public void ExactMatch() {
		expected = true;
		name = "arieljones";
		actual = UserValidations.userNameIsTaken(userNames, name);
		assertEquals(expected, actual);
	}

	@Test
	public void NameIsContainedInAnExistingOne() {
		expected = false;
		name = "john345";
		actual = UserValidations.userNameIsTaken(userNames, name);
		assertEquals(expected, actual);
	}

	@Test
	public void NameComparisonEquals() {
		expected = false;
		name = "johnjohn2";
		actual = UserValidations.userNameIsTaken(userNames, name);
		assertEquals(expected, actual);
	}
}
