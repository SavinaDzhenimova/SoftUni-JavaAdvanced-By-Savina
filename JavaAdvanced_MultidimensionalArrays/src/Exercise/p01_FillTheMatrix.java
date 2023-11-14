package Exercise;

import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int matrixDimensions = Integer.parseInt(input[0]);
        String wayOfFilling = input[1];

        int[][] matrix = new int[matrixDimensions][matrixDimensions];

        switch (wayOfFilling) {
            case "A":
                fillMatrixA(matrix, matrixDimensions);
                break;
            case "B":
                fillMatrixB(matrix, matrixDimensions);
                break;
        }

        printMatrix(matrix);
    }

    public static void fillMatrixA(int[][] matrix, int dimensions) {
        int num = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = num;
                num++;
            }
        }
    }

    public static void fillMatrixB(int[][] matrix, int dimensions) {
        int num = 1;
        for (int c = 0; c < dimensions; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = num;
                    num++;
                }
            } else {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    matrix[r][c] = num;
                    num++;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int el : rows) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}