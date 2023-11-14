package Exam_2020_19_August;

import java.util.Scanner;

public class p02_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];
        fillMatrix(scanner, territory);
        int[] beePosition = beePosition(territory);
        int beeRow = beePosition[0];
        int beeCol = beePosition[1];
        territory[beeRow][beeCol] = '.';

        int pollinatedFlowers = 0;
        boolean outOfTerritory = false;
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    if (beeRow - 1 >= 0) {
                        beeRow--;
                    } else {
                        outOfTerritory = true;
                        break;
                    }
                    break;
                case "down":
                    if (beeRow + 1 < size) {
                        beeRow++;
                    } else {
                        outOfTerritory = true;
                        break;
                    }
                    break;
                case "left":
                    if (beeCol - 1 >= 0) {
                        beeCol--;
                    } else {
                        outOfTerritory = true;
                        break;
                    }
                    break;
                case "right":
                    if (beeCol + 1 < size) {
                        beeCol++;
                    } else {
                        outOfTerritory = true;
                        break;
                    }
                    break;
            }

            if (outOfTerritory) {
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                territory[beeRow][beeCol] = '.';
                pollinatedFlowers++;
            } else if (territory[beeRow][beeCol] == 'O') {
                territory[beeRow][beeCol] = '.';
                switch (command) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                }

                if (territory[beeRow][beeCol] == 'f') {
                    territory[beeRow][beeCol] = '.';
                    pollinatedFlowers++;
                }
            }

            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        if (!outOfTerritory) {
            territory[beeRow][beeCol] = 'B';
        }

        for (char[] row : territory) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] beePosition(char[][] matrix) {
        int[] beePosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    beePosition[0] = r;
                    beePosition[1] = c;
                }
            }
        }

        return beePosition;
    }
}