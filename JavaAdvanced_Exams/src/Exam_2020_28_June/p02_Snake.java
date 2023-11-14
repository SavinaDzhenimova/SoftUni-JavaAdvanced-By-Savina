package Exam_2020_28_June;

import java.util.Scanner;

public class p02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        fillMatrix(scanner, field);
        int[] snakePosition = snakePosition(field);
        int snakeRow = snakePosition[0];
        int snakeCol = snakePosition[1];
        field[snakeRow][snakeCol] = '.';
        int foodQuantity = 0;
        boolean outOfField = false;

        String command = scanner.nextLine();
        while (!command.isEmpty()) {
            switch (command) {
                case "up":
                    if (snakeRow - 1 >= 0) {
                        snakeRow--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 < size) {
                        snakeRow++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "left":
                    if (snakeCol - 1 >= 0) {
                        snakeCol--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 < size) {
                        snakeCol++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
            }

            if (outOfField) {
                System.out.println("Game over!");
                break;
            }

            if (field[snakeRow][snakeCol] == '*') {
                foodQuantity++;

                if (foodQuantity >= 10) {
                    System.out.println("You won! You fed the snake.");
                    break;
                }
            } else if (field[snakeRow][snakeCol] == 'B') {
                field[snakeRow][snakeCol] = '.';
                snakeRow = burrowPosition(field)[0];
                snakeCol = burrowPosition(field)[1];
            }
            field[snakeRow][snakeCol] = '.';

            command = scanner.nextLine();
        }

        System.out.println("Food eaten: " + foodQuantity);
        if (!outOfField) {
            field[snakeRow][snakeCol] = 'S';
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

    public static int[] snakePosition(char[][] matrix) {
        int[] snakePosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    snakePosition = new int[] { r, c };
                }
            }
        }

        return snakePosition;
    }

    public static int[] burrowPosition(char[][] matrix) {
        int[] burrowPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    burrowPosition = new int[] { r, c };
                }
            }
        }

        return burrowPosition;
    }
}