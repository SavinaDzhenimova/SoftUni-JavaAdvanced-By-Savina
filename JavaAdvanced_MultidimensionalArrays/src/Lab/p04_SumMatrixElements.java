package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[r] = arr;
        }

        int totalSum = 0;
        for (int r = 0; r < matrix.length; r++) {
            int arrSum = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                arrSum += matrix[r][c];
            }

            totalSum += arrSum;
        }

        System.out.println(matrixDimensions[0]);
        System.out.println(matrixDimensions[1]);
        System.out.println(totalSum);
    }
}