package Exam_2019_26_October;

import java.util.Scanner;

public class p02_BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder result = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        fillMatrix(scanner, field);
        int[] playerPosition = playerPosition(field);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        field[playerRow][playerCol] = '-';

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    } else {
                        if (result.length() != 0) {
                            result.deleteCharAt(result.length() - 1);
                            command = scanner.nextLine();
                            continue;
                        }
                    }
                    break;
                case "down":
                    if (playerRow + 1 < size) {
                        playerRow++;
                    } else {
                        if (result.length() != 0) {
                            result.deleteCharAt(result.length() - 1);
                            command = scanner.nextLine();
                            continue;
                        }
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    } else {
                        if (result.length() != 0) {
                            result.deleteCharAt(result.length() - 1);
                            command = scanner.nextLine();
                            continue;
                        }
                    }
                    break;
                case "right":
                    if (playerCol + 1 < size) {
                        playerCol++;
                    } else {
                        if (result.length() != 0) {
                            result.deleteCharAt(result.length() - 1);
                            command = scanner.nextLine();
                            continue;
                        }
                    }
                    break;
            }

            if (Character.isLetter(field[playerRow][playerCol])) {
                char symbol = field[playerRow][playerCol];
                result.append(symbol);
                field[playerRow][playerCol] = '-';
            }

            command = scanner.nextLine();
        }

        field[playerRow][playerCol] = 'P';
        System.out.println(result);
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
                if (matrix[r][c] == 'P') {
                    playerPosition[0] = r;
                    playerPosition[1] = c;
                }
            }
        }

        return playerPosition;
    }
}