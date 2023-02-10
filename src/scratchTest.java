import java.util.Scanner;

public class scratchTest {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        System.out.println("Enter the height of the tree: ");
        while (!scr.hasNextInt()) {
            System.out.println("The height of the tree must be an integer. Please enter again: ");
            scr.next();
        }
        int nFloors = scr.nextInt();


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

            for (int i = 0; i < preciseFloorSpaceAmount; i++) {
                towerFloor.append(" ");
            }

            towerFloor.append("\n");

            tower.append(towerFloor);

        } return tower;
    }
}






