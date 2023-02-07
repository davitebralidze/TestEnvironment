import java.util.Scanner;

public class stringRevert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a string");
        String input = scanner.nextLine();
        StringBuilder reversedString = new StringBuilder();


        char[] dividedString = input.toCharArray();

        for (int i = dividedString.length - 1; i >= 0; i--) {
            reversedString.append(dividedString[i]);
        }

        System.out.println("Reversed version of your text is : " +reversedString);

    }
}

