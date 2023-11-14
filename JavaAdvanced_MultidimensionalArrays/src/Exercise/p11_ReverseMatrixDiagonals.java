package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        for (int col = cols - 1; col >= 0; col--) {
            int printRow = rows;
            for (int printCol = col; printCol <= cols - 1 && printRow > 0; printCol++) {
                System.out.print(matrix[printRow - 1][printCol] + " ");
                printRow--;
            }
            System.out.println();
        }


        if(rows >= 2) {
            for (int row = rows - 2; row >= 0; row--) {
                int printRow = row;
                for (int col = 0; col <= row && col < cols; col++) {
                    System.out.print(matrix[printRow][col] + " ");
                    printRow--;
                }
                System.out.println();
            }
        }
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
    }
}