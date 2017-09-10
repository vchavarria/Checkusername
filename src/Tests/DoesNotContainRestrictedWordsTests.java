package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import checkusername.UserValidations;

public class DoesNotContainRestrictedWordsTests {
	boolean expected;
	boolean actual;
	String name;
	String restrictedWords[] = { "cannabis", "abuse", "crack", "damn", "drunk", "grass" };

	@Test
	public void NonRestrictedWord() {
		expected = true;
		name = "validuser";
		actual = UserValidations.DoesNotContainRestrictedWords(restrictedWords, name);
		assertEquals(expected, actual);
	}

	@Test
	public void ContainsResctricted() {
		expected = false;
		name = "crackuser";
		actual = UserValidations.DoesNotContainRestrictedWords(restrictedWords, name);
		assertEquals(expected, actual);
	}

}
