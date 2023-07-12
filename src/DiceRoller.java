//Imported utilities
import java.util.Random;
import java.util.Scanner;

public class DiceRoller {

    public static void main(String[] args) {

        //Creating needed variables and strings
        Random random = new Random();
        int chosenNum1;
        int chosenNum2;
        int rolledNum1 = 0;
        int rolledNum2 = 0;
        int tries = 0;

        // Picking first number from the method
        chosenNum1 = getChosenDiceNum("Enter first number: ");

        // Picking second number from the method
        chosenNum2 = getChosenDiceNum("Enter second number: ");

        //Just for interface
        System.out.println();

        // Rolling and showing random pairs
        while ((((rolledNum1 != chosenNum1) || (rolledNum2 != chosenNum2))) && ((rolledNum1 != chosenNum2) || (rolledNum2 != chosenNum1))) {
            rolledNum1 = random.nextInt(6) + 1;
            rolledNum2 = random.nextInt(6) + 1;
            tries++;
            System.out.println("You rolled: " + rolledNum1 + " and " + rolledNum2);
        }

        // Printing the desired pair and how many tries it took
        System.out.println("\nIt took you " + tries + " tries to roll pair of " + chosenNum1 + " and " + chosenNum2);

    }

    // Creating method for inserting and restricting number
    private static int getChosenDiceNum(String title) {

        System.out.println(title);

        int chosenNum = 0;

        while (true) {
            try {
                chosenNum = new Scanner(System.in).nextInt();
            } catch (Exception ignored) {
            }
            if (chosenNum < 1 || chosenNum > 6) {
                System.out.println("Dice does not have such number\nEnter valid number: ");
            } else break;
        }
        return chosenNum;
    }
}


