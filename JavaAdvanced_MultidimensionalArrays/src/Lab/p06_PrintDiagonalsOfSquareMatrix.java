package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        for (int r = 0; r < matrix.length; r++) {
            System.out.print(matrix[r][r] + " ");
        }

        System.out.println();

        int lastRowIndex = matrix.length - 1;
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(matrix[lastRowIndex - r][r] + " ");
        }
    }
}