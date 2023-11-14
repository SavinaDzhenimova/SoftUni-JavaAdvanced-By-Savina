package Exam_2019_17_December;

import java.util.Scanner;

public class p02_PresentDelivery {
    public static int presentsCount;
    public static int goodKidsCount;
    public static int kidsWithPresents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] neighbourhood = new char[size][size];
        fillMatrix(scanner, neighbourhood);
        int[] santaPosition = santaPosition(neighbourhood);
        int santaRow = santaPosition[0];
        int santaCol = santaPosition[1];
        neighbourhood[santaRow][santaCol] = '-';

        String command = scanner.nextLine();
        goodKidsCount = getGoodKidsCount(neighbourhood);
        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    if (santaRow - 1 >= 0) {
                        santaRow--;
                    }
                    break;
                case "down":
                    if (santaRow + 1 < size) {
                        santaRow++;
                    }
                    break;
                case "left":
                    if (santaCol - 1 >= 0) {
                        santaCol--;
                    }
                    break;
                case "right":
                    if (santaCol + 1 < size) {
                        santaCol++;
                    }
                    break;
            }

            if (neighbourhood[santaRow][santaCol] == 'V') {
                presentsCount--;
                goodKidsCount--;
                kidsWithPresents++;
                neighbourhood[santaRow][santaCol] = '-';
            } else if (neighbourhood[santaRow][santaCol] == 'X') {
                neighbourhood[santaRow][santaCol] = '-';
            } else if (neighbourhood[santaRow][santaCol] == 'C') {
                neighbourhood[santaRow][santaCol] = '-';
                givePresents(neighbourhood, santaRow, santaCol);
            }

            if (presentsCount == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }

            command = scanner.nextLine();
        }

        neighbourhood[santaRow][santaCol] = 'S';
        printMatrix(neighbourhood);
        if (goodKidsCount == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", kidsWithPresents);
        } else {
            System.out.printf("No presents for %d nice kid/s.", goodKidsCount);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] santaPosition(char[][] matrix) {
        int[] santaPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    santaPosition[0] = r;
                    santaPosition[1] = c;
                }
            }
        }

        return santaPosition;
    }

    public static int getGoodKidsCount(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                if (cell == 'V') {
                    goodKidsCount++;
                }
            }
        }
        return goodKidsCount;
    }

    public static void givePresents(char[][] matrix, int row, int col) {
        char up = matrix[row - 1][col];
        char down = matrix[row + 1][col];
        char left = matrix[row][col - 1];
        char right = matrix[row][col + 1];

        char[] cells = new char[4];
        cells[0] = up;
        cells[1] = down;
        cells[2] = left;
        cells[3] = right;

        for (char cell : cells) {
            if ((cell == 'V') || (cell == 'X')) {
                if (cell == 'V') {
                    goodKidsCount--;
                }

                kidsWithPresents++;
                presentsCount--;

                if (presentsCount <= 0) {
                    break;
                }
            }
        }

        matrix[row - 1][col] = '-';
        matrix[row + 1][col] = '-';
        matrix[row][col - 1] = '-';
        matrix[row][col + 1] = '-';
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}