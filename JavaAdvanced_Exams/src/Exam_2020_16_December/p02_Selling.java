package Exam_2020_16_December;

import java.util.Scanner;

public class p02_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = new char[size][size];
        fillMatrix(scanner, bakery);
        int[] sellerPosition = sellerPosition(bakery);
        int sellerRow = sellerPosition[0];
        int sellerCol = sellerPosition[1];
        bakery[sellerRow][sellerCol] = '-';

        String command = scanner.nextLine();
        int collectedMoney = 0;
        boolean outOfBakery = false;
        while (collectedMoney < 50) {
            switch (command) {
                case "up":
                    if (sellerRow - 1 >= 0) {
                        sellerRow--;
                    } else {
                        outOfBakery = true;
                        break;
                    }
                    break;
                case "down":
                    if (sellerRow + 1 < size) {
                        sellerRow++;
                    } else {
                        outOfBakery = true;
                        break;
                    }
                    break;
                case "left":
                    if (sellerCol - 1 >= 0) {
                        sellerCol--;
                    } else {
                        outOfBakery = true;
                        break;
                    }
                    break;
                case "right":
                    if (sellerCol + 1 < size) {
                        sellerCol++;
                    } else {
                        outOfBakery = true;
                        break;
                    }
                    break;
            }

            if (outOfBakery) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            if (Character.isDigit(bakery[sellerRow][sellerCol])) {
                int client = Integer.parseInt(String.valueOf(bakery[sellerRow][sellerCol]));
                collectedMoney += client;
                bakery[sellerRow][sellerCol] = '-';

                if (collectedMoney >= 50) {
                    break;
                }
            } else if (bakery[sellerRow][sellerCol] == 'O') {
                bakery[sellerRow][sellerCol] = '-';
                int[] pillarPosition = pillarPosition(bakery);
                sellerRow = pillarPosition[0];
                sellerCol = pillarPosition[1];

                if (Character.isDigit(bakery[sellerRow][sellerCol])) {
                    int client = Integer.parseInt(String.valueOf(bakery[sellerRow][sellerCol]));
                    collectedMoney += client;
                    bakery[sellerRow][sellerCol] = '-';

                    if (collectedMoney >= 50) {
                        break;
                    }
                }
                bakery[sellerRow][sellerCol] = '-';
            }

            command = scanner.nextLine();
        }

        if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            bakery[sellerRow][sellerCol] = 'S';
        }
        System.out.println("Money: " + collectedMoney);
        for (char[] row : bakery) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] sellerPosition(char[][] matrix) {
        int[] sellerPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    sellerPosition[0] = r;
                    sellerPosition[1] = c;
                }
            }
        }

        return sellerPosition;
    }

    public static int[] pillarPosition(char[][] matrix) {
        int[] pillarPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'O') {
                    pillarPosition[0] = r;
                    pillarPosition[1] = c;
                }
            }
        }

        return pillarPosition;
    }
}