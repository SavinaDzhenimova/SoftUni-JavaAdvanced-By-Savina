package Exam_2023_21_October;

import java.util.Scanner;

public class p02_FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] fishingArea = new char[size][size];
        fillMatrix(scanner, fishingArea);
        int[] fisherPosition = fisherPosition(fishingArea);
        int fisherRow = fisherPosition[0];
        int fisherCol = fisherPosition[1];
        fishingArea[fisherRow][fisherCol] = '-';

        String command = scanner.nextLine();
        int tonsOfFish = 0;
        boolean caughtInWhirlpool = false;
        while (!command.equals("collect the nets")) {
            switch (command) {
                case "up":
                    if (fisherRow - 1 >= 0) {
                        fisherRow--;
                    } else {
                        fisherRow = size - 1;
                    }
                    break;
                case "down":
                    if (fisherRow + 1 < size) {
                        fisherRow++;
                    } else {
                        fisherRow = 0;
                    }
                    break;
                case "left":
                    if (fisherCol - 1 >= 0) {
                        fisherCol--;
                    } else {
                        fisherCol = size - 1;
                    }
                    break;
                case "right":
                    if (fisherCol + 1 < size) {
                        fisherCol++;
                    } else {
                        fisherCol = 0;
                    }
                    break;
            }

            if (Character.isDigit(fishingArea[fisherRow][fisherCol])) {
                int fish = Integer.parseInt(String.valueOf(fishingArea[fisherRow][fisherCol]));
                tonsOfFish += fish;
                fishingArea[fisherRow][fisherCol] = '-';
            } else if (fishingArea[fisherRow][fisherCol] == 'W') {
                caughtInWhirlpool = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (caughtInWhirlpool) {
            System.out.printf("You fell into a whirlpool! " +
                            "The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n",
                    fisherRow, fisherCol);
        } else {
            if (tonsOfFish >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                                "You need %d tons of fish more.%n",
                        20 - tonsOfFish);
            }

            if (tonsOfFish > 0) {
                System.out.printf("Amount of fish caught: %d tons.%n", tonsOfFish);
            }

            fishingArea[fisherRow][fisherCol] = 'S';
            for (char[] row : fishingArea) {
                System.out.println(row);
            }
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] fisherPosition(char[][] matrix) {
        int[] fisherPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    fisherPosition[0] = r;
                    fisherPosition[1] = c;
                }
            }
        }

        return fisherPosition;
    }
}