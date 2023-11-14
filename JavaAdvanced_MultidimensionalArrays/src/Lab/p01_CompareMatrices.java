package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = fillMatrix(scanner);
        int[][] secondMatrix = fillMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        if (areEqual) {
            for (int r = 0; r < firstMatrix.length; r++) {
                int[] firstArr = firstMatrix[r];
                int[] secondArr = secondMatrix[r];

                areEqual = firstArr.length == secondArr.length;

                if (areEqual) {
                    for (int i = 0; i < firstArr.length; i++) {
                        if (firstArr[i] != secondArr[i]) {
                            areEqual = false;
                        }
                    }
                }
            }
        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] matrixDimensions = getArray(scanner);

        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int row = 0; row < matrixDimensions[0]; row++) {
            int[] array = getArray(scanner);

            matrix[row] = array;
        }

        return matrix;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}