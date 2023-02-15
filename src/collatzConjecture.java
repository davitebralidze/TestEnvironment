import java.util.Scanner;

public class collatzConjecture {

    public static void main(String[] args) {


        Scanner scr = new Scanner(System.in);
        long startNum;

        System.out.println("This program will print Collatz Conjecture");
        System.out.println("Please enter a positive integer: ");

        do {
            while (!scr.hasNextLong()) {
                System.out.println("Please enter a positive integer: ");
                scr.next();
            }
            startNum = scr.nextInt();

            if (startNum < 1) {
                System.out.println("Please enter a positive integer: ");
            }

        } while (startNum < 1);

        while (true) {
            if (startNum % 2 != 0) {
                startNum = startNum * 3 + 1;
                System.out.println(startNum);
            } else if (startNum % 2 == 0) {
                startNum = startNum / 2;
                System.out.println(startNum);
            }
        }
    }


}
