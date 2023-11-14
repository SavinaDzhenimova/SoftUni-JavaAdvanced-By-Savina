package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        StringBuilder[][] matrix = new StringBuilder[rows][cols];

        fillMatrix(matrix, rows, cols);

        printMatrix(matrix);
    }

    public static void fillMatrix(StringBuilder[][] matrix, int rows, int cols) {
        char symbol = 'a';
        for (int r = 0; r < rows; r++) {
            char middleSymbol = 'a';
            middleSymbol += r;

            for (int c = 0; c < cols; c++) {
                StringBuilder line = new StringBuilder();
                line.append(symbol);
                line.append(middleSymbol);
                line.append(symbol);

                matrix[r][c] = line;
                middleSymbol++;
            }
            symbol++;
        }
    }

    public static void printMatrix(StringBuilder[][] matrix) {
        for (StringBuilder[] rows : matrix) {
            for (StringBuilder el : rows) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}