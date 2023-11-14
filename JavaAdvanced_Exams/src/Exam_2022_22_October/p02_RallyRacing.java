package Exam_2022_22_October;

import java.util.Scanner;

public class p02_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        char[][] raceRoute = new char[size][size];
        fillMatrix(raceRoute, scanner);
        int[] carPosition = new int[] { 0, 0 };
        int carRow = carPosition[0];
        int carCol = carPosition[1];

        String command = scanner.nextLine();
        int passedKilometers = 0;
        boolean isWinner = false;
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    carRow--;
                    break;
                case "down":
                    carRow++;
                    break;
                case "left":
                    carCol--;
                    break;
                case "right":
                    carCol++;
                    break;
            }

            if (raceRoute[carRow][carCol] == '.') {
                passedKilometers += 10;
            } else if (raceRoute[carRow][carCol] == 'T') {
                raceRoute[carRow][carCol] = '.';
                carPosition = otherTunnelSide(raceRoute);
                carRow = carPosition[0];
                carCol = carPosition[1];
                raceRoute[carRow][carCol] = '.';
                passedKilometers += 30;
            } else if (raceRoute[carRow][carCol] == 'F') {
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                passedKilometers += 10;
                isWinner = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (!isWinner) {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", passedKilometers);
        raceRoute[carRow][carCol] = 'C';
        for (char[] row : raceRoute) {
            System.out.println(row);
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] line = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = line;
        }
    }

    public static int[] otherTunnelSide(char[][] matrix) {
        int[] otherTunnelPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'T') {
                    otherTunnelPosition = new int[] { r, c };
                }
            }
        }
         return otherTunnelPosition;
    }
}