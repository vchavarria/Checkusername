package checkusername;

import java.util.Arrays;

public class UserValidations {

	public static boolean isValid(String name) {
		String nameWithoutSpaces = name.trim();
		if (nameWithoutSpaces.length() >= 6)
			return true;
		else
			throw new IllegalArgumentException();
	}

	public static boolean userNameIsTaken(String[] userNames, String name) {
		if (Arrays.stream(userNames).anyMatch(name::equals))
			return true;
		else
			return false;
	}

	public static boolean DoesNotContainRestrictedWords(String[] restrictedWords, String name) {
		if (Arrays.stream(restrictedWords).noneMatch(name::contains))
			return true;
		else
			return false;
	}

	public static Result checkUserName(String name, String[] existingUsers, String[] restrictedWords) {

		Result result = new Result();

		boolean isValid = isValid(name);
		boolean doesNotContainRestrictedWords = DoesNotContainRestrictedWords(restrictedWords, name);
		boolean userNameIsTaken = userNameIsTaken(existingUsers, name);
		result.isValid = isValid && doesNotContainRestrictedWords && !userNameIsTaken;

		if (userNameIsTaken)
			result.names = generateAlternateNames(name, existingUsers);
		else
			result.names = new String[] {};

		return result;

	}

	public static String[] generateAlternateNames(String userName, String[] existingUsers) {
		String[] alternateNames = new String[14];

		for (int i = 0, nameConsecutive = 1; i <= 13; nameConsecutive++) {
			String newName = userName + nameConsecutive;
			if (!userNameIsTaken(existingUsers, newName)) {
				alternateNames[i] = newName;
				i++;
			}
		}
		return alternateNames;

	}

}
