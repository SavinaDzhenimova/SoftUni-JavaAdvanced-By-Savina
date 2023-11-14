package Exam_2021_14_April;

import java.util.Scanner;

public class p02_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] pastryShop = new char[size][size];
        fillMatrix(scanner, pastryShop);
        int[] playerPosition = playerPosition(pastryShop);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        pastryShop[playerRow][playerCol] = '-';
        int collectedMoney = 0;
        boolean outOfPastryShop = false;

        String command = scanner.nextLine();
        while (!command.isEmpty()) {
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    } else {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        outOfPastryShop = true;
                        break;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < size) {
                        playerRow++;
                    } else {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        outOfPastryShop = true;
                        break;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    } else {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        outOfPastryShop = true;
                        break;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < size) {
                        playerCol++;
                    } else {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        outOfPastryShop = true;
                        break;
                    }
                    break;
            }

            if (outOfPastryShop) {
                break;
            }

            if (Character.isDigit(pastryShop[playerRow][playerCol])) {
                int money = Integer.parseInt(String.valueOf(pastryShop[playerRow][playerCol]));
                collectedMoney += money;
                pastryShop[playerRow][playerCol] = '-';

                if (collectedMoney >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    pastryShop[playerRow][playerCol] = 'S';
                    break;
                }
            } else if (pastryShop[playerRow][playerCol] == 'P') {
                pastryShop[playerRow][playerCol] = '-';
                playerRow = pillarPosition(pastryShop)[0];
                playerCol = pillarPosition(pastryShop)[1];
                pastryShop[playerRow][playerCol] = '-';
            }

            command = scanner.nextLine();
        }

        System.out.println("Money: " + collectedMoney);
        for (char[] row : pastryShop) {
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
                if (matrix[r][c] == 'S') {
                    playerPosition = new int[] { r, c };
                }
            }
        }

        return playerPosition;
    }

    public static int[] pillarPosition(char[][] matrix) {
        int[] pillarPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    pillarPosition = new int[] { r, c };
                }
            }
        }

        return pillarPosition;
    }
}