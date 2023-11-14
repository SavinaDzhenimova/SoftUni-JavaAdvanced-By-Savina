package Exam_2023_9_August;

import java.util.Arrays;
import java.util.Scanner;

public class p02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] neighbourhood = new char[rows][cols];
        fillMatrix(neighbourhood, scanner);
        int[] boyPosition = boyPosition(neighbourhood);
        int boyRow = boyPosition[0];
        int boyCol = boyPosition[1];
        int[] startPosition = new int[] {boyRow, boyCol};
        boolean cancelledOrder = false;

        String command = scanner.nextLine();
        while (!command.isEmpty()) {
            switch (command) {
                case "up":
                    if (boyRow - 1 >= 0 && neighbourhood[boyRow - 1][boyCol] != '*') {
                        boyRow--;
                        break;
                    }

                    if (boyRow - 1 < 0) {
                        cancelledOrder = true;
                        break;
                    }
                    break;
                case "down":
                    if (boyRow + 1 < rows && neighbourhood[boyRow + 1][boyCol] != '*') {
                        boyRow++;
                        break;
                    }

                    if (boyRow + 1 >= rows) {
                        cancelledOrder = true;
                        break;
                    }
                    break;
                case "left":
                    if (boyCol - 1 >= 0 && neighbourhood[boyRow][boyCol - 1] != '*') {
                        boyCol--;
                        break;
                    }

                    if (boyCol - 1 < 0) {
                        cancelledOrder = true;
                        break;
                    }
                    break;
                case "right":
                    if (boyCol + 1 < cols && neighbourhood[boyRow][boyCol + 1] != '*') {
                        boyCol++;
                        break;
                    }

                    if (boyCol + 1 >= cols) {
                        cancelledOrder = true;
                        break;
                    }
                    break;
            }

            if (cancelledOrder) {
                System.out.println("The delivery is late. Order is canceled.");
                neighbourhood[startPosition[0]][startPosition[1]] = ' ';
                break;
            }

            if (neighbourhood[boyRow][boyCol] == 'P') {
                neighbourhood[boyRow][boyCol] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (neighbourhood[boyRow][boyCol] == '-') {
                 neighbourhood[boyRow][boyCol] = '.';
            } else if (neighbourhood[boyRow][boyCol] == 'A') {
                neighbourhood[boyRow][boyCol] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }

            command = scanner.nextLine();
        }

        for (char[] row : neighbourhood) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] boyPosition(char[][] matrix) {
        int[] boyPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    boyPosition = new int[]{ r, c };
                }
            }
        }

        return boyPosition;
    }
}