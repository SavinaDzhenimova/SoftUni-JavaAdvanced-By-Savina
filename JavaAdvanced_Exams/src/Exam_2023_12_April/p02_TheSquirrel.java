package Exam_2023_12_April;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        List<String> commands = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        fillMatrix(field, scanner);
        int[] squirrelPosition = squirrelPosition(field);
        int squirrelRow = squirrelPosition[0];
        int squirrelCol = squirrelPosition[1];
        field[squirrelRow][squirrelCol] = '*';
        int collectedHazelnuts = 0;
        boolean outOfField = false;

        while (!commands.isEmpty()) {
            String command = commands.get(0);

            switch (command) {
                case "up":
                    if (squirrelRow - 1 >= 0) {
                        squirrelRow--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "down":
                    if (squirrelRow + 1 < size) {
                        squirrelRow++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "left":
                    if (squirrelCol - 1 >= 0) {
                        squirrelCol--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "right":
                    if (squirrelCol + 1 < size) {
                        squirrelCol++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
            }

            if (outOfField) {
                System.out.println("The squirrel is out of the field.");
                break;
            }

            if (field[squirrelRow][squirrelCol] == 'h') {
                field[squirrelRow][squirrelCol] = '*';
                collectedHazelnuts++;

                if (collectedHazelnuts == 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    break;
                }
            } else if (field[squirrelRow][squirrelCol] == 't') {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            }

            commands.remove(0);
        }

        if (collectedHazelnuts < 3 && commands.isEmpty()) {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d%n", collectedHazelnuts);
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] squirrelPosition(char[][] matrix) {
        int[] squirrelPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 's') {
                    squirrelPosition = new int[]{ r, c };
                }
            }
        }
        return squirrelPosition;
    }
}