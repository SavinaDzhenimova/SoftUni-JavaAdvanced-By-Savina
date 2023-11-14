package Exam_2021_23_October;

import java.util.Scanner;

public class p02_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        fillMatrix(field, scanner);
        int[] mousePosition = mousePosition(field);
        int mouseRow = mousePosition[0];
        int mouseCol = mousePosition[1];
        int eatenCheese = 0;
        boolean outOfField = false;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (mouseRow - 1 >= 0) {
                        mouseRow--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "down":
                    if (mouseRow + 1 < size) {
                        mouseRow++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "left":
                    if (mouseCol - 1 >= 0) {
                        mouseCol--;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
                case "right":
                    if (mouseCol + 1 < size) {
                        mouseCol++;
                    } else {
                        outOfField = true;
                        break;
                    }
                    break;
            }

            if (outOfField) {
                break;
            }

            if (field[mouseRow][mouseCol] == 'c') {
                eatenCheese++;
                field[mouseRow][mouseCol] = '-';
            } else if (field[mouseRow][mouseCol] == 'B') {
                field[mouseRow][mouseCol] = '-';

                switch (command) {
                    case "up":
                        mouseRow--;
                        break;
                    case "down":
                        mouseRow++;
                    case "left":
                        mouseCol--;
                        break;
                    case "right":
                        mouseCol++;
                        break;
                }

                if (field[mouseRow][mouseCol] == 'c') {
                    eatenCheese++;
                    field[mouseRow][mouseCol] = '-';
                }
            }

            command = scanner.nextLine();
        }

        if (outOfField) {
            System.out.println("Where is the mouse?");
        } else {
            field[mouseRow][mouseCol] = 'M';
        }

        if (eatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        }

        for (char[] row : field) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
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
                    matrix[r][c] = '-';
                }
            }
        }

        return mousePosition;
    }
}