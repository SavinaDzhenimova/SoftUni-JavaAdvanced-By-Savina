package Exam_2023_18_February;

import java.util.Arrays;
import java.util.Scanner;

public class p02_BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] field = new char[rows][cols];
        fillMatrix(field, scanner);
        int[] manPosition = manPosition(field);
        int manRow = manPosition[0];
        int manCol = manPosition[1];
        field[manRow][manCol] = '-';
        int touchedPlayers = 0;
        int movesCount = 0;

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (manRow - 1 >= 0 && field[manRow - 1][manCol] != 'O') {
                        manRow--;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "down":
                    if (manRow + 1 < rows && field[manRow + 1][manCol] != 'O') {
                        manRow++;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "left":
                    if (manCol - 1 >= 0 && field[manRow][manCol - 1] != 'O') {
                        manCol--;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "right":
                    if (manCol + 1 < cols && field[manRow][manCol + 1] != 'O') {
                        manCol++;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
            }

            if (field[manRow][manCol] == 'P') {
                field[manRow][manCol] = '-';
                touchedPlayers++;
                movesCount++;

                if (touchedPlayers == 3) {
                    break;
                }
            } else if (field[manRow][manCol] == '-') {
                movesCount++;
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", touchedPlayers, movesCount);
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            char[] arr = line.toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] manPosition(char[][] matrix) {
        int[] manPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    manPosition = new int[]{ r, c };
                }
            }
        }

        return manPosition;
    }
}