package Exam_2021_26_June;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        List<String> commands = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        fillMatrix(scanner, field);
        int[] pythonPosition = pythonPosition(field);
        int pythonRow = pythonPosition[0];
        int pythonCol = pythonPosition[1];
        int pythonLength = 1;
        int foodCount = foodCount(field);

        while (!commands.isEmpty()) {
            String command = commands.get(0);

            switch (command) {
                case "up":
                    if (pythonRow - 1 >= 0) {
                        pythonRow--;
                    } else {
                        pythonRow = size - 1;
                    }
                    break;
                case "down":
                    if (pythonRow + 1 < size) {
                        pythonRow++;
                    } else {
                        pythonRow = 0;
                    }
                    break;
                case "left":
                    if (pythonCol - 1 >= 0) {
                        pythonCol--;
                    } else {
                        pythonCol = size - 1;
                    }
                    break;
                case "right":
                    if (pythonCol + 1 < size) {
                        pythonCol++;
                    } else {
                        pythonCol = 0;
                    }
                    break;
            }

            if (field[pythonRow][pythonCol] == 'f') {
                foodCount--;
                pythonLength++;

                if (foodCount == 0) {
                    System.out.printf("You win! Final python length is %d%n", pythonLength);
                    break;
                }
            } else if (field[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                break;
            }

            commands.remove(0);
        }

        if (commands.isEmpty() && foodCount > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] pythonPosition(char[][] matrix) {
        int[] pythonPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 's') {
                    pythonPosition = new int[]{ r, c };
                }
            }
        }

        return pythonPosition;
    }

    public static int foodCount(char[][] matrix) {
        int foodCount = 0;

        for (char[] row : matrix) {
            for (char el : row) {
                if (el == 'f') {
                    foodCount++;
                }
            }
        }

        return foodCount;
    }
}