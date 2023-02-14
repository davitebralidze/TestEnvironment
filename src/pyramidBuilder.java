import java.util.Scanner;

public class pyramidBuilder {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        int nFloors;

        System.out.println("Enter the height of the tree: ");


        do {
            while (!scr.hasNextInt()) {
                System.out.println("The height of the tree must be a positive integer. Please enter again: ");
                scr.next();
            }
            nFloors = scr.nextInt();

            if (nFloors < 1) {
                System.out.println("The height of the tree must be a positive integer. Please enter again: ");
            }
        } while (nFloors < 1);

        System.out.println(towerBuilder(nFloors));

    }

    public static StringBuilder towerBuilder(int nFloors) {

        StringBuilder tower = new StringBuilder();

        for (int preciseFloor = 1; preciseFloor <= nFloors; preciseFloor++) {

            StringBuilder towerFloor = new StringBuilder();
            int lastLine = 1 + (nFloors - 1) * 2;
            int spaceMax = (lastLine - 1) / 2;
            int preciseFloorSignAmount = 1 + (preciseFloor - 1) * 2;
            int preciseFloorSpaceAmount = spaceMax + (preciseFloor - 1) * (-1);


            for (int i = 0; i < preciseFloorSpaceAmount; i++) {
                towerFloor.append(" ");
            }

            for (int k = 0; k < preciseFloorSignAmount; k++) {
                towerFloor.append("*");
            }

            towerFloor.append("\n");

            tower.append(towerFloor);

        }
        return tower;
    }
}
