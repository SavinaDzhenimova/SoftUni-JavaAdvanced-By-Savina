package Exam_2022_14_December;

import java.util.Scanner;

public class p02_NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] battlefield = new char[size][size];
        fillMatrix(battlefield, scanner);
        int[] submarinePosition = submarinePosition(battlefield);
        int submarineRow = submarinePosition[0];
        int submarineCol = submarinePosition[1];
        battlefield[submarineRow][submarineCol] = '-';

        String command = scanner.nextLine();
        int mines = 0;
        int cruisers = 0;
        while (!command.isEmpty()) {
            switch (command) {
                case "up":
                    if (submarineRow - 1 >= 0) {
                        submarineRow--;
                    }
                    break;
                case "down":
                    if (submarineRow + 1 < size) {
                        submarineRow++;
                    }
                    break;
                case "left":
                    if (submarineCol - 1 >= 0) {
                        submarineCol--;
                    }
                    break;
                case "right":
                    if (submarineCol + 1 < size) {
                        submarineCol++;
                    }
                    break;
            }

            if (battlefield[submarineRow][submarineCol] == '*') {
                battlefield[submarineRow][submarineCol] = '-';
                mines++;

                if (mines == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",
                            submarineRow, submarineCol);
                    break;
                }
            } else if (battlefield[submarineRow][submarineCol] == 'C') {
                battlefield[submarineRow][submarineCol] = '-';
                cruisers++;

                if (cruisers == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }

        battlefield[submarineRow][submarineCol] = 'S';
        for (char[] row : battlefield) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] submarinePosition(char[][] matrix) {
        int[] submarinePosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    submarinePosition = new int[]{ r, c };
                }
            }
        }

        return submarinePosition;
    }
}