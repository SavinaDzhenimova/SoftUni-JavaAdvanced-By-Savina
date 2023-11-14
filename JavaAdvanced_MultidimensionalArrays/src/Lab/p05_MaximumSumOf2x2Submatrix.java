package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxCurrent = 0;
        int maxRight = 0;
        int maxBelow = 0;
        int maxRightBelow = 0;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int current = matrix[r][c];
                int right = matrix[r][c + 1];
                int below = matrix[r + 1][c];
                int rightBelow = matrix[r + 1][c + 1];

                int matrix2x2Sum = current + right + below + rightBelow;

                if (maxSum < matrix2x2Sum) {
                    maxSum = matrix2x2Sum;

                    maxCurrent = current;
                    maxRight = right;
                    maxBelow = below;
                    maxRightBelow = rightBelow;
                }
            }
        }

        int[][] maxMatrix = new int[][] {
                {maxCurrent, maxRight},
                {maxBelow, maxRightBelow}
        };

        for (int[] row : maxMatrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}