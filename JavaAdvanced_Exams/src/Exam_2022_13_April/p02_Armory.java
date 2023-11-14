package Exam_2022_13_April;

import java.util.Scanner;

public class p02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] armory = new char[size][size];
        fillMatrix(armory, scanner);
        int[] armyPosition = armyPosition(armory);
        int armyRow = armyPosition[0];
        int armyCol = armyPosition[1];
        int boughtSwords = 0;
        boolean outOfArmory = false;

        while (boughtSwords < 65) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (armyRow - 1 >= 0) {
                        armyRow--;
                    } else {
                        System.out.println("I do not need more swords!");
                        outOfArmory = true;
                        break;
                    }
                    break;
                case "down":
                    if (armyRow + 1 < size) {
                        armyRow++;
                    } else {
                        System.out.println("I do not need more swords!");
                        outOfArmory = true;
                        break;
                    }
                    break;
                case "left":
                    if (armyCol - 1 >= 0) {
                        armyCol--;
                    } else {
                        System.out.println("I do not need more swords!");
                        outOfArmory = true;
                        break;
                    }
                    break;
                case "right":
                    if (armyCol + 1 < size) {
                        armyCol++;
                    } else {
                        System.out.println("I do not need more swords!");
                        outOfArmory = true;
                        break;
                    }
                    break;
            }

            if (outOfArmory) {
                break;
            }

            if (armory[armyRow][armyCol] == 'M') {
                armory[armyRow][armyCol] = '-';
                armyRow = mirrorPosition(armory)[0];
                armyCol = mirrorPosition(armory)[1];
                armory[armyRow][armyCol] = '-';
            } else if (Character.isDigit(armory[armyRow][armyCol])) {
                boughtSwords += Integer.parseInt(String.valueOf(armory[armyRow][armyCol]));
                armory[armyRow][armyCol] = '-';
            }
        }

        if (boughtSwords > 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        if (!outOfArmory) {
            armory[armyRow][armyCol] = 'A';
        }
        System.out.printf("The king paid %d gold coins.%n", boughtSwords);
        for (char[] arr : armory) {
            System.out.println(arr);
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] armyPosition(char[][] matrix) {
        int[] armyPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'A') {
                    armyPosition = new int[] {r, c};
                    matrix[r][c] = '-';
                }
            }
        }

        return armyPosition;
    }

    public static int[] mirrorPosition(char[][] matrix) {
        int[] mirrorPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    mirrorPosition = new int[] {r, c};
                }
            }
        }

        return mirrorPosition;
    }
}