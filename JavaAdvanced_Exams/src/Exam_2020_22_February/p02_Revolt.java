package Exam_2020_22_February;

import java.util.Scanner;

public class p02_Revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        fillMatrix(scanner, field);
        int[] playerPosition = playerPosition(field);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        field[playerRow][playerCol] = '-';
        boolean isWinner = false;

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0 && field[playerRow - 1][playerCol] != 'T') {
                        playerRow--;
                        break;
                    }

                    if (playerRow - 1 < 0 && field[size - 1][playerCol] != 'T') {
                        playerRow = size - 1;
                        break;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < size && field[playerRow - 1][playerCol] != 'T') {
                        playerRow++;
                        break;
                    }

                    if (playerRow + 1 >= size && field[0][playerCol] != 'T') {
                        playerRow = 0;
                        break;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0 && field[playerRow][playerCol - 1] != 'T') {
                        playerCol--;
                        break;
                    }

                    if (playerCol - 1 < 0 && field[playerRow][size - 1] != 'T') {
                        playerCol = size - 1;
                        break;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < size && field[playerRow][playerCol + 1] != 'T') {
                        playerCol++;
                        break;
                    }

                    if (playerCol + 1 >= size && field[playerRow][0] != 'T') {
                        playerCol = 0;
                        break;
                    }
                    break;
            }

            if (field[playerRow][playerCol] == 'F') {
                System.out.println("Player won!");
                isWinner = true;
                break;
            } else if (field[playerRow][playerCol] == 'B') {
                switch (command) {
                    case "up":
                        if (playerRow - 1 >= 0) {
                            playerRow--;
                        } else {
                            playerRow = size - 1;
                        }
                        break;
                    case "down":
                        if (playerRow + 1 < size) {
                            playerRow++;
                        } else {
                            playerRow = 0;
                        }
                        break;
                    case "left":
                        if (playerCol - 1 >= 0) {
                            playerCol--;
                        } else {
                            playerCol = size - 1;
                        }
                        break;
                    case "right":
                        if (playerCol + 1 < size) {
                            playerCol++;
                        } else {
                            playerCol = 0;
                        }
                        break;
                }

                if (field[playerRow][playerCol] == 'F') {
                    System.out.println("Player won!");
                    isWinner = true;
                    break;
                }
            }
        }

        field[playerRow][playerCol] = 'f';
        if (!isWinner) {
            System.out.println("Player lost!");
        }
        for (char[] row : field) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] playerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'f') {
                    playerPosition[0] = r;
                    playerPosition[1] = r;
                }
            }
        }

        return playerPosition;
    }
}