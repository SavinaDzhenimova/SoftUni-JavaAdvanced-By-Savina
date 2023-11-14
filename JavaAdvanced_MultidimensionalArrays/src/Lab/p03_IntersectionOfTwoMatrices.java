package Lab;

import java.util.Scanner;

public class p03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillMatrix(scanner, rows, cols);
        char[][] secondMatrix = fillMatrix(scanner, rows, cols);

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                char outputSymbol = '*';
                if (firstMatrix[r][c] == secondMatrix[r][c]) {
                    outputSymbol = firstMatrix[r][c];
                }

                System.out.print(outputSymbol);
            }

            System.out.println();
        }
    }

    public static char[][] fillMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }

        return matrix;
    }
}