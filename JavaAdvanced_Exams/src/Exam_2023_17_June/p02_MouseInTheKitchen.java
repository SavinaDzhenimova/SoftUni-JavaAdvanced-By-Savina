package Exam_2023_17_June;

import java.util.Arrays;
import java.util.Scanner;

public class p02_MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] field = new char[rows][cols];
        fillMatrix(scanner, field, rows);
        int[] mousePosition = mousePosition(field);
        int mouseRow = mousePosition[0];
        int mouseCol = mousePosition[1];
        field[mouseRow][mouseCol] = '*';
        int totalCheese = totalCheese(field);
        boolean isOutOfField = false;

        String command = scanner.nextLine();
        while (!command.equals("danger")) {
            switch (command) {
                case "up":
                    if (mouseRow - 1 >= 0 && field[mouseRow - 1][mouseCol] != '@') {
                        mouseRow--;
                        break;
                    }

                    if (mouseRow - 1 < 0) {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "down":
                    if (mouseRow + 1 < rows && field[mouseRow + 1][mouseCol] != '@') {
                        mouseRow++;
                        break;
                    }

                    if (mouseRow + 1 >= rows) {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "left":
                    if (mouseCol - 1 >= 0 && field[mouseRow][mouseCol - 1] != '@') {
                        mouseCol--;
                        break;
                    }

                    if (mouseCol - 1 < 0) {
                        isOutOfField = true;
                        break;
                    }
                    break;
                case "right":
                    if (mouseCol + 1 < cols && field[mouseRow][mouseCol + 1] != '@') {
                        mouseCol++;
                        break;
                    }

                    if (mouseCol + 1 >= cols) {
                        isOutOfField = true;
                        break;
                    }
                    break;
            }

            if (isOutOfField) {
                System.out.println("No more cheese for tonight!");
                break;
            }

            if (field[mouseRow][mouseCol] == 'C') {
                field[mouseRow][mouseCol] = '*';
                totalCheese--;

                if (totalCheese == 0) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (field[mouseRow][mouseCol] == 'T') {
                System.out.println("Mouse is trapped!");
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("danger")) {
            System.out.println("Mouse will come back later!");
        }
        field[mouseRow][mouseCol] = 'M';
        for (char[] row : field) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix, int rows) {
        for (int r = 0; r < rows; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] mousePosition(char[][] matrix) {
        int[] mousePosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    mousePosition = new int[] { r, c };
                }
            }
        }

        return mousePosition;
    }

    public static int totalCheese(char[][] matrix) {
        int totalCheese = 0;

        for (char[] row : matrix) {
            for (char el : row) {
                if (el == 'C') {
                    totalCheese++;
                }
            }
        }

        return totalCheese;
    }
}