package Exam_2021_18_August;

import java.util.Scanner;

public class p02_FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];
        fillMatrix(scanner, field);
        int[] playerPosition = playerPosition(field);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        boolean isWinner = false;

        for (int c = 0; c < commandsCount; c++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        if (field[playerRow - 1][playerCol] != 'T') {
                            playerRow--;
                        }
                    } else {
                        playerRow = size - 1;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < size) {
                        if (field[playerRow + 1][playerCol] != 'T') {
                            playerRow++;
                        }
                    } else {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        if (field[playerRow][playerCol - 1] != 'T') {
                            playerCol--;
                        }
                    } else {
                        playerCol = size - 1;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < size) {
                        if (field[playerRow][playerCol + 1] != 'T') {
                            playerCol++;
                        }
                    } else {
                        playerCol = 0;
                    }
                    break;
            }

            if (field[playerRow][playerCol] == 'B') {
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
                            playerCol--;
                        } else {
                            playerCol = 0;
                        }
                        break;
                }

            } else if (field[playerRow][playerCol] == 'F') {
                System.out.println("Well done, the player won first place!");
                isWinner = true;
                break;
            }
        }

        if (!isWinner) {
            System.out.println("Oh no, the player got lost on the track!");
        }

        field[playerRow][playerCol] = 'P';
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
                    matrix[playerPosition[0]][playerPosition[1]] = '.';
                }
            }
        }

        return playerPosition;
    }
}