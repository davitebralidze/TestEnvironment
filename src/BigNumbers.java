import java.math.BigDecimal;
import java.util.Scanner;

public class BigNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a value for a");
        BigDecimal a = scanner.nextBigDecimal();
        System.out.println("Enter a value for b");
        BigDecimal b = scanner.nextBigDecimal();


        // when a is bigger than b, compareTo method returns 1
        if (a.compareTo(b) > 0) {
            System.out.println("A is greater than B");
            // when a is less than b, compareTo method returns -1
        } else if (a.compareTo(b) < 0) {
            System.out.println("A is less than B");
            // when a is equal than b, compareTo method returns 0
        } else if (a.compareTo(b) == 0) {
            System.out.println("A and B are equal");
        }

        if (a.intValue() % 2 == 0) {
            System.out.println("A is even");
        } else {
            System.out.println("A is odd");
        }

        if (b.intValue() % 2 == 0) {
            System.out.println("B is even");
        } else {
            System.out.println("B is odd");
        }

        if (a.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("A is less then 0");
        } else if (a.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("A is equal to zero");
        } else if (a.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("A is greater than 0");
        }

    }


}

