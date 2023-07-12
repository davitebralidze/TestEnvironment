import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {

        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String RED = "\u001B[31m";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the password: ");
        try {
            int passwordLength = scanner.nextInt();
            System.out.println("Your password is " + CYAN + passwordGenerator(passwordLength));
        } catch (Exception WrongArgumentPassedException) {
            System.out.println(RED + "The length of the password must be an integer that is between the range of 4 and 30");
        }

    }

    public static String passwordGenerator(int passwordLength) {
        if (passwordLength < 4 || passwordLength > 30) {
                throw new IllegalArgumentException();
            }

        Random random = new Random();
        StringBuilder generatedPassword = new StringBuilder();
        char[] charactersToBeUsed = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
                '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+'};
        int randIndex = charactersToBeUsed.length - 1;
        for (int i = 0; i < passwordLength; i++) {
            generatedPassword.append(charactersToBeUsed[random.nextInt(randIndex)]);
        }

        boolean doesPasswordContainUpperCase = false;
        boolean doesPasswordContainLowerCase = false;
        boolean doesPasswordContainNumber = false;
        boolean doesPasswordContainSymbol = false;
        char[] upperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] lowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+'};

        for (int i = 0; i < generatedPassword.length(); i++) {
            for (int j = 0; j < upperCase.length; j++) {
                if (upperCase[j] == generatedPassword.charAt(i)) {
                    doesPasswordContainUpperCase = true;
                    break;
                }
            }
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            for (int j = 0; j < lowerCase.length; j++) {
                if (lowerCase[j] == generatedPassword.charAt(i)) {
                    doesPasswordContainLowerCase = true;
                    break;
                }
            }
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == generatedPassword.charAt(i)) {
                    doesPasswordContainNumber = true;
                    break;
                }
            }
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j] == generatedPassword.charAt(i)) {
                    doesPasswordContainSymbol = true;
                    break;
                }
            }
        }

        if (doesPasswordContainLowerCase && doesPasswordContainUpperCase && doesPasswordContainNumber && doesPasswordContainSymbol) {
            return generatedPassword.toString();
        } else {
            return passwordGenerator(passwordLength);
        }
    }

}
