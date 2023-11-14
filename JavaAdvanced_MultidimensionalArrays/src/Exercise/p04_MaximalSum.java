package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p04_MaximalSum {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(scanner, rows, cols);
        int[][] maxMatrix = new int[3][3];

        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {

                int[][] miniMatrix = find3x3matrix(matrix, r, c);
                int sum = findMiniMatrixSum(miniMatrix);

                if (max < sum) {
                    max = sum;
                    maxMatrix = miniMatrix;
                }
            }
        }

        System.out.println("Sum = " + max);
        printMaxMatrix(maxMatrix);
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        return matrix;
    }

    public static int[][] find3x3matrix(int[][] matrix, int r, int c) {
        int r0c0 = matrix[r][c];
        int r0c1 = matrix[r][c + 1];
        int r0c2 = matrix[r][c + 2];
        int r1c0 = matrix[r + 1][c];
        int r1c1 = matrix[r + 1][c + 1];
        int r1c2 = matrix[r + 1][c + 2];
        int r2c0 = matrix[r + 2][c];
        int r2c1 = matrix[r + 2][c + 1];
        int r2c2 = matrix[r + 2][c + 2];

        return new int[][]{
            {r0c0, r0c1, r0c2},
            {r1c0, r1c1, r1c2},
            {r2c0, r2c1, r2c2}
        };
    }

    public static int findMiniMatrixSum(int[][] miniMatrix) {
        int sum = 0;

        for (int[] row : miniMatrix) {
            for (int el : row) {
                sum += el;
            }
        }

        return sum;
    }

    public static void printMaxMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int el : rows) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
