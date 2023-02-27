/*
 y = "a" "z" "b"  , where z is mathematical symbol, a and b are variables and y is the result of the mathematical operation
 Entering "=" symbol will end the execution of the program
 In case of taking out the root out of number, "b" is the degree and "a" is the number from which we are taking the root
*/

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigDecimal;

public class scratchTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BigDecimal a;
        BigDecimal b;
        BigDecimal y = BigDecimal.ZERO;
        String z;
        String[] mathSign = new String[]{"+", "-", "*", "/", "^", "v"};

        System.out.println("Enter first number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid format\nEnter valid form of number: ");
            scanner.next();
        } a = scanner.nextBigDecimal();

        System.out.println("Enter mathematical sign: ");
        z = scanner.next();
        while (Arrays.stream(mathSign).noneMatch(z::equals)) {
            System.out.println("Enter valid format of mathematical sign: ");
            z = scanner.next();
        }

        System.out.println("Enter second number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid format\nEnter valid form of number: ");
            scanner.next();
        } b = scanner.nextBigDecimal();

        switch (z) {
            case "+" -> y = a.add(b);
            case "-" -> y = a.subtract(b);
            case "*" -> y = a.multiply(b);
            case "/" -> {
                if (b.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("Dividing by zero gives complex infinity");
                    System.exit(0);
                } else y = a.divide(b, 200, RoundingMode.HALF_UP).stripTrailingZeros();
            }





            case "^" -> y = a.pow(b.intValue());


            case "v" -> {
                if (a.compareTo(BigDecimal.ZERO) < 0 && b.intValue() % 2 == 0) {
                    System.out.println("You cannot take the even degree root out of negative number");
                    System.exit(0);
                } else if (a.compareTo(BigDecimal.ZERO) < 0 && b.intValue() % 2 != 0) {
                    a = a.negate();
                    y = a.pow(1 / b.intValue());
                    y = y.negate();
                } else y = a.pow(1 / b.intValue());
            }
        }









        System.out.println("The result is " + y + "\n");

        while (true) {

            a = y;

            System.out.println("Additional operation mathematical sign: ");
            z = scanner.next();
            if (z.equals("=")) {
                System.out.println("Thank you for using our product!");
                System.exit(0);
            }
            while (Arrays.stream(mathSign).noneMatch(z::equals)) {
                System.out.println("Enter valid format of mathematical sign: ");
                z = scanner.next();
            }

            System.out.println("Additional operation number: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid format\nEnter valid form of number: ");
                scanner.next();
            } b = scanner.nextBigDecimal();

            switch (z) {
                case "+" -> y = a.add(b);
                case "-" -> y = a.subtract(b);
                case "*" -> y = a.multiply(b);
                case "/" -> {
                    if (b.compareTo(BigDecimal.ZERO) == 0) {
                        System.out.println("Dividing by zero gives complex infinity");
                        System.exit(0);
                    } else y = a.divide(b, 200, RoundingMode.HALF_UP).stripTrailingZeros();
                }






                case "^" -> y = a.pow(b.intValue());


                case "v" -> {
                    if (a.compareTo(BigDecimal.ZERO) < 0 && b.intValue() % 2 == 0) {
                        System.out.println("You cannot take the even degree root out of negative number");
                        System.exit(0);
                    } else if (a.compareTo(BigDecimal.ZERO) < 0 && b.intValue() % 2 != 0) {
                        a = a.negate();
                        y = a.pow(1 / b.intValue());
                        y = y.negate();
                    } else y = a.pow(1 / b.intValue());
                }
            }








            System.out.println("The result of additional operation is " + y + "\n");
        }
    }
}