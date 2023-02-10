import java.util.ArrayList;

public class sudokuSolver {

    public static void main(String[] args) {

        int[][] sudokuBoard = {
                {8, 4, 9, 5, 2, 1, 7, 3, 6},
                {2, 5, 7, 8, 6, 3, 9, 1, 4},
                {1, 6, 3, 7, 4, 9, 2, 5, 8},
                {3, 2, 5, 1, 9, 6, 4, 8, 7},
                {4, 9, 8, 3, 5, 7, 6, 2, 1},
                {7, 1, 6, 4, 8, 2, 3, 9, 5},
                {9, 8, 4, 2, 7, 5, 1, 6, 3},
                {6, 7, 1, 9, 3, 8, 5, 4, 2},
                {5, 3, 2, 6, 1, 4, 8, 7, 9},
        };




        //height validation
        if (sudokuBoard.length != 9) {
            System.out.println("The 9x9 size format of the board is not met!" +
                    "\nPlease provide valid format of the board!");
            System.exit(0);
        }

        //width validation
        for (int row = 0; row < sudokuBoard.length; row++) {
            if (sudokuBoard[row].length != 9) {
                System.out.println("The 9x9 size format of the board is not met!" +
                        "\nPlease provide valid format of the board!");
                System.exit(0);
            }
        }

        //inserted numbers validation
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (sudokuBoard[row][column] > 9 || sudokuBoard[row][column] < 1) {
                    System.out.println("One of the entered numbers is more than 9, or less than 1!");
                    System.exit(0);
                }
            }
        }

        //decision maker
        if (rowCheck(sudokuBoard) && columnCheck(sudokuBoard) && boxCheck(sudokuBoard)) {
            System.out.println("You filled sudoku board correctly!");
        } else {
            System.out.println("You did not fill sudoku board correctly!");
        }
    }


    //checking duplicated numbers in row
    public static boolean rowCheck(int[][] sudokuBoard) {

        for (int row = 0; row < sudokuBoard.length; row++) {
            for (int chosenPosition = 0; chosenPosition < sudokuBoard.length; chosenPosition++) {
                for (int toCompare = chosenPosition + 1; toCompare < sudokuBoard.length; toCompare++) {
                    if (sudokuBoard[row][chosenPosition] == sudokuBoard[row][toCompare]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //checking duplicated numbers in column
    public static boolean columnCheck(int[][] sudokuBoard) {

        for (int column = 0; column < sudokuBoard.length; column++) {
            for (int chosenPosition = 0; chosenPosition < sudokuBoard.length; chosenPosition++) {
                for (int toCompare = chosenPosition + 1; toCompare < sudokuBoard.length; toCompare++) {
                    if (sudokuBoard[chosenPosition][column] == sudokuBoard[toCompare][column]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //checking duplicated numbers in 3x3 boxes
    // Turning 3x3 2D arrays to 9 element single dimension array and searching for duplicates
    public static boolean boxCheck(int[][] sudokuBoard) {

        ArrayList<Integer> clusterNum = new ArrayList<Integer>();

        for (int boxRow = 0; boxRow < 9; boxRow = boxRow + 3) {
            for (int boxColumn = 0; boxColumn < 9; boxColumn = boxColumn + 3) {
                for (int row = boxRow; row < boxRow + 3; row++) {
                    for (int column = boxColumn; column < boxColumn + 3; column++) {
                        clusterNum.add(sudokuBoard[row][column]);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    for (int k = i + 1; k < 9; k++) {
                        if (clusterNum.get(i) == clusterNum.get(k)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}