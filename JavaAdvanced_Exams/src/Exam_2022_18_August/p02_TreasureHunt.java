package Exam_2022_18_August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] field = new char[rows][cols];
        fillMatrix(scanner, field);
        int[] playersPositions = playersPosition(field);
        int playerRow = playersPositions[0];
        int playerCol = playersPositions[1];

        String command = scanner.nextLine();
        List<String> moves = new ArrayList<>();
        boolean treasureIsFound = false;
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0 && field[playerRow - 1][playerCol] != 'T') {
                        playerRow--;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < rows && field[playerRow + 1][playerCol] != 'T') {
                        playerRow++;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0 && field[playerRow][playerCol - 1] != 'T') {
                        playerCol--;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < cols && field[playerRow][playerCol + 1] != 'T') {
                        playerCol++;
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
            }

            if (field[playerRow][playerCol] == 'X') {
                moves.add(command);
                System.out.println("I've found the treasure!");
                System.out.print("The right path is ");
                System.out.println(String.join(", ", moves));
                treasureIsFound = true;
                break;
            } else if (field[playerRow][playerCol] == '-') {
                moves.add(command);
            }

            command = scanner.nextLine();
        }

        if (!treasureIsFound) {
            System.out.println("The map is fake!");
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] playersPosition(char[][] matrix) {
        int[] playerPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'Y') {
                    playerPosition[0] = r;
                    playerPosition[1] = c;
                }
            }
        }

        return playerPosition;
    }
}