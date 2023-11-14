package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p05_MatrixShuffling {
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        String[][] matrix = readMatrix(scanner, rows, cols);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");

            if (! input.startsWith("swap") || command.length != 5) {
                System.out.println("Invalid input!");
            } else {
                int firstCellRow = Integer.parseInt(command[1]);
                int firstCellCol = Integer.parseInt(command[2]);
                int secondCellRow = Integer.parseInt(command[3]);
                int secondCellCol = Integer.parseInt(command[4]);

                if (isOutOfRange(firstCellRow, firstCellCol, secondCellRow, secondCellCol)) {
                    System.out.println("Invalid input!");
                } else {
                    exchangeCells(matrix, firstCellRow, firstCellCol, secondCellRow, secondCellCol);
                    printMaxMatrix(matrix);
                }
            }

            input = scanner.nextLine();
        }
    }

    public static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[r] = arr;
        }

        return matrix;
    }

    private static boolean isOutOfRange(int r1, int c1, int r2, int c2) {
        if (r1 < 0 || r1 >= rows) {
            return true;
        } else if (r2 < 0 || r2 >= rows) {
            return true;
        } else if (c1 < 0 || c1 >= cols) {
            return true;
        } else if (c2 < 0 || c2 >= cols) {
            return true;
        }

        return false;
    }

    public static void exchangeCells(String[][] matrix,int r1, int c1, int r2, int c2) {
        String cell = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = cell;
    }

    public static void printMaxMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String el : rows) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}