import java.util.Scanner;
public class scratchTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a;

        System.out.println("This condition stands before while loop: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("This condition is inside while loop: ");
            scanner.next();
        }
        System.out.println("This condition is after while loop");

        a = scanner.nextDouble();

        System.out.println(a);

    }
}

