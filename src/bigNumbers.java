import java.math.BigDecimal;
import java.util.Scanner;

public class bigNumbers {

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
            // when a is equal to b, compare to method returns 0
        } else if (a.compareTo(b) == 0) {
            System.out.println("A and B are equal");
        }

    }


}

