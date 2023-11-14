package Exam_2021_15_December;

import java.util.Scanner;

public class p02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        fillMatrix(scanner, field);
        int[] playerPosition = playerPosition(field);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        int[] helenPosition = helenPosition(field);
        boolean isWinner = false;

        while (energy > 0) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            int spawnRow = Integer.parseInt(commands[1]);
            int spawnCol = Integer.parseInt(commands[2]);
            field[spawnRow][spawnCol] = 'S';

            switch (command) {
                case "up":
                    energy--;
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    } else {
                        continue;
                    }
                    break;
                case "down":
                    energy--;
                    if (playerRow + 1 < size) {
                        playerRow++;
                    } else {
                        continue;
                    }
                    break;
                case "left":
                    energy--;
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    } else {
                        continue;
                    }
                    break;
                case "right":
                    energy--;
                    if (playerCol + 1 < size) {
                        playerCol++;
                    } else {
                        continue;
                    }
                    break;
            }

            if (field[playerRow][playerCol] == 'S') {
                field[playerRow][playerCol] = '-';
                energy -= 2;
            } else if (field[playerRow][playerCol] == field[helenPosition[0]][helenPosition[1]]) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                field[playerRow][playerCol] = '-';
                isWinner = true;
                break;
            }
        }

        if (energy <= 0 && !isWinner) {
            System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
            field[playerRow][playerCol] = 'X';
        }

        for (char[] row : field) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] playerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    playerPosition = new int[] { r, c };
                    matrix[playerPosition[0]][playerPosition[1]] = '-';
                }
            }
        }

        return playerPosition;
    }

    public static int[] helenPosition(char[][] matrix) {
        int[] helenPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'H') {
                    helenPosition = new int[] { r, c };
                }
            }
        }

        return helenPosition;
    }
}