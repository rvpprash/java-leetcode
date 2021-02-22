import java.lang.*;
import java.util.*;

class TwoDimArray {
    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Enter the no of rows");
        int rowNos = scan.nextInt();
        System.out.println("Enter the no of columns");
        int colNos = scan.nextInt();

        int[][] matrix = new int[rowNos][colNos];
        getArrayInput(rowNos, colNos, matrix);
        printElements(rowNos, colNos, matrix);
        boolean identicalColumnsPresent = checkIfIdenticalColumn(rowNos, colNos, matrix);
        boolean identicalDiagonal = checkIfDiagonallySame(rowNos, colNos, matrix);
        boolean identicalRowPresent = checkIfIdenticalRow(rowNos, colNos, matrix);

        System.out.println("Identical columns " + identicalColumnsPresent);
        System.out.println("Identical diagonal " + identicalDiagonal);
        System.out.println("Identical rows " + identicalRowPresent);

    }

    static void getArrayInput(int rows, int cols, int[][] arr) {
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the numbers for row " + i);
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
    }

    static void printElements(int rows, int cols, int[][] arr) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkIfDiagonallySame(int rows, int cols, int[][] arr) {
        int i;
        boolean checkFlag = false;
        for (i = 0; i < rows; i++) {
            if (arr[i][i] != arr[0][0]) {
                return checkFlag;
            }
        }
        checkFlag = true;
        return checkFlag;
    }

    static boolean checkIfIdenticalColumn(int rows, int cols, int[][] arr) {
        boolean isIdenticalFlag;
        int count = 0;
        int j = 0;
        while (j < cols) {
            int i = 0;
            int first = arr[i][j];
            while (i < rows) {
                if (arr[i][j] != first) {
                    break;
                }
                i++;
                if (i == rows) {
                    count++;
                }
            }
            j++;
        }
        System.out.println("No of identical columns: " + count);
        isIdenticalFlag = (count > 0) ? true : false;
        return isIdenticalFlag;
    }

    static boolean checkIfIdenticalRow(int rows, int cols, int[][] arr) {
        boolean isIdenticalFlag;
        int count = 0;
        int i = 0;
        while (i < rows) {
            int j = 0;
            int first = arr[i][j];
            while (j < cols) {
                if (arr[i][j] != first) {
                    break;
                } else {
                    j++;
                    if (j == cols) {
                        count++;
                    }
                }
            }
            i++;
        }
        System.out.println("No of identical rows: " + count);
        isIdenticalFlag = (count > 0) ? true : false;
        return isIdenticalFlag;
    }
}
