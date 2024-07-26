import java.security.SecureRandom;
import java.util.Scanner;
class RandomPasswordGenerator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include lower case letters? (y/n): ");
        boolean includeLowerCase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include upper case letters? (y/n): ");
        boolean includeUpperCase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeLowerCase, includeUpperCase, includeNumbers, includeSpecialCharacters);

        System.out.println("Generated password: " + password);
    }

    private static String generatePassword(int length, boolean includeLowerCase, boolean includeUpperCase, boolean includeNumbers, boolean includeSpecialCharacters) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each selected character set is included
        if (includeLowerCase) {
            password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        }
        if (includeUpperCase) {
            password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        }
        if (includeNumbers) {
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        if (includeSpecialCharacters) {
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

        // Fill the rest of the password length with random characters from all selected character sets
        String characters = "";
        if (includeLowerCase) {
            characters += LOWER_CASE;
        }
        if (includeUpperCase) {
            characters += UPPER_CASE;
        }
        if (includeNumbers) {
            characters += NUMBERS;
        }
        if (includeSpecialCharacters) {
            characters += SPECIAL_CHARACTERS;
        }

        for (int i = password.length(); i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Shuffle the password to ensure randomness
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }
        return new String(passwordArray);
    }
}