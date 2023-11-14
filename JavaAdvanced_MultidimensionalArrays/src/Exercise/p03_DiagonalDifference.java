package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, dimensions);
        int primaryDiagonalSum = findPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = findSecondaryDiagonalSum(matrix);

        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(difference);
    }

    public static int[][] readMatrix(Scanner scanner, int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        return matrix;
    }

    public static int findPrimaryDiagonalSum(int[][] matrix) {
        int primaryDiagonalSum = 0;
        int c = 0;
        for (int[] rows : matrix) {
            primaryDiagonalSum += rows[c];
            c++;
        }

        return primaryDiagonalSum;
    }

    public static int findSecondaryDiagonalSum(int[][] matrix) {
        int secondaryDiagonalSum = 0;
        int c = matrix.length - 1;
        for (int[] rows : matrix) {
            secondaryDiagonalSum += rows[c];
            c--;
        }

        return secondaryDiagonalSum;
    }
}