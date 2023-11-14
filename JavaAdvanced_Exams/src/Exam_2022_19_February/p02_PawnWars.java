package Exam_2022_19_February;

import java.util.Scanner;

public class p02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];
        fillMatrix(chessboard, scanner);
        int[] blackPosition = findBlackPosition(chessboard);
        int[] whitePosition = findWhitePosition(chessboard);

        while (whitePosition[0] != 0 && blackPosition[0] != chessboard.length - 1) {
            if (Math.abs(blackPosition[1] - whitePosition[1]) == 1 &&
                    Math.abs(blackPosition[0] - whitePosition[0]) == 1) {
                System.out.printf("Game over! White capture on %s.%n", getCoordinates(blackPosition));
                break;
            }
            whitePosition[0]--;

            if (Math.abs(blackPosition[1] - whitePosition[1]) == 1 &&
                    Math.abs(blackPosition[0] - whitePosition[0]) == 1) {
                System.out.printf("Game over! Black capture on %s.%n", getCoordinates(whitePosition));
                break;
            }
            blackPosition[0]++;
        }

        if (whitePosition[0] == 0) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", getCoordinates(whitePosition));
        } else if (blackPosition[0] == chessboard.length - 1) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", getCoordinates(blackPosition));
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] findBlackPosition(char[][] matrix) {
        int[] blackPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'b') {
                    blackPosition[0] = r;
                    blackPosition[1] = c;
                }
            }
        }

        return blackPosition;
    }

    public static int[] findWhitePosition(char[][] matrix) {
        int[] whitePosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'w') {
                    whitePosition[0] = r;
                    whitePosition[1] = c;
                }
            }
        }

        return whitePosition;
    }

    public static String getCoordinates(int[] position) {
        int row = position[0];
        int col = position[1];
        char symbol = 0;

        switch (row) {
            case 0:
                row = 8;
                break;
            case 1:
                row = 7;
                break;
            case 2:
                row = 6;
                break;
            case 3:
                row = 5;
                break;
            case 4:
                break;
            case 5:
                row = 3;
                break;
            case 6:
                row = 2;
                break;
            case 7:
                row = 1;
                break;
        }

        switch (col) {
            case 0:
                symbol = 'a';
                break;
            case 1:
                symbol = 'b';
                break;
            case 2:
                symbol = 'c';
                break;
            case 3:
                symbol = 'd';
                break;
            case 4:
                symbol = 'e';
                break;
            case 5:
                symbol = 'f';
                break;
            case 6:
                symbol = 'g';
                break;
            case 7:
                symbol = 'h';
                break;
        }

        return symbol + String.valueOf(row);
    }
}