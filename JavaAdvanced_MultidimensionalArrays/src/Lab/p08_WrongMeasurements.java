package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int[] wrongValueCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueCoordinates[0]][wrongValueCoordinates[1]];

        int[][] resultMatrix = new int[matrix.length][];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = new int[matrix[r].length];
            resultMatrix[r] = arr;
        }

        for (int r = 0; r < matrix.length; r++) {
            int upNum = 0;
            int downNum = 0;
            int leftNum = 0;
            int rightNum = 0;

            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];

                if (currentNum == wrongValue) {
                    if (r - 1 >= 0) {
                        upNum = matrix[r - 1][c];

                        if (upNum == wrongValue) {
                            upNum = 0;
                        }
                    }

                    if (r + 1 <= matrix.length - 1) {
                        downNum = matrix[r + 1][c];

                        if (downNum == wrongValue) {
                            downNum = 0;
                        }
                    }

                    if (c - 1 >= 0) {
                        leftNum = matrix[r][c - 1];

                        if (leftNum == wrongValue) {
                            leftNum = 0;
                        }
                    }

                    if (c + 1 <= matrix[r].length - 1) {
                        rightNum = matrix[r][c + 1];

                        if (rightNum == wrongValue) {
                            rightNum = 0;
                        }
                    }

                    int sumToReplace = upNum + downNum + leftNum + rightNum;
                    resultMatrix[r][c] = sumToReplace;
                } else {
                    resultMatrix[r][c] = matrix[r][c];
                }
            }
        }

        printMatrix(resultMatrix);
    }

    public static int[][] readMatrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}