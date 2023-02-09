import java.util.Scanner;

public class nearestSqrNmbr {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your choice of the integer: ");
        int input = scanner.nextInt();

        int nearestSqrNmbr = (int) Math.pow(Math.round(Math.sqrt(input)), 2);
        System.out.println(nearestSqrNmbr);

    }


}
