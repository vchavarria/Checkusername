package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import checkusername.UserValidations;

public class IsValidTests {

	boolean expected;
	boolean actual;
	String name;

	@Test
	public void Exact6Chars() {
		expected = true;
		name = "123456";
		actual = UserValidations.isValid(name);
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void LessThan6Chars() {
		name = "12345";
		UserValidations.isValid(name);
	}

	@Test
	public void MoreThan6Chars() {
		expected = true;
		name = "1234567";
		actual = UserValidations.isValid(name);
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void EmptyChars() {
		name = "";
		UserValidations.isValid(name);
	}

	@Test(expected = IllegalArgumentException.class)
	public void SpaceChars() {
		name = "      ";
		UserValidations.isValid(name);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Space10Chars() {
		name = "          ";
		UserValidations.isValid(name);
	}
}