package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p07_Crossfire {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        matrix = new int[dimensions[0]][dimensions[1]];
        fillMatrix(matrix);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int[] command = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = command[0];
            int col = command[1];
            int radius = command[2];

            int start = Math.max(0, row - radius);
            int end = Math.min(matrix.length - 1, row + radius);

            for (int i = start; i <= end; i++) {
                if (isValid(i, col) && i != row) {
                    removeElement(i, col);
                }
            }

            end = Math.max(0, col - radius);
            for (int i = col + radius; i >= end; i--) {
                if (isValid(row, i)) {
                    removeElement(row, i);
                }
            }

            input = scanner.nextLine();
        }

        printMatrix();
    }

    public static void fillMatrix(int[][] matrix) {
        int num = 1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = num;
                num++;
            }
        }
    }

    private static void removeElement(int row, int col) {
        int rowSize = matrix[row].length - 1;

        if (rowSize > 0) {
            int elementToRemove = matrix[row][col];

            int index = 0;
            int[] arr = new int[rowSize];
            for (int i = 0; i < matrix[row].length; i++) {
                int currentNum = matrix[row][i];

                if (currentNum != elementToRemove) {
                    arr[index++] = currentNum;
                }
            }

            matrix[row] = arr;

        } else {
            int[][] newMatrix = new int[matrix.length - 1][];

            boolean finished = false;

            int rowMatrix = 0; // row of iteration of older matrix
            int newMatrixRow = 0; // row of iteration of new matrix

            int elementToRemove = matrix[row][col];
            while (!finished) {
                int matrixRowSize = matrix[rowMatrix].length;

                if (matrixRowSize > 1 || matrix[rowMatrix][col] != elementToRemove) {
                    newMatrix[newMatrixRow] = matrix[rowMatrix];
                    newMatrixRow++;
                }

                rowMatrix++;

                if (rowMatrix >= matrix.length) {
                    finished = true;
                }
            }

            matrix = newMatrix;
        }
    }

    private static boolean isValid(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    public static void printMatrix() {
        for (int[] row : matrix) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}