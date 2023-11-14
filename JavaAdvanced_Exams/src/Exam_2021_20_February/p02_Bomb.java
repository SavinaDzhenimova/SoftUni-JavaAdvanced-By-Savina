package Exam_2021_20_February;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        List<String> commands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        fillMatrix(scanner, field);
        int[] sapperPosition = sapperPosition(field);
        int sapperRow = sapperPosition[0];
        int sapperCol = sapperPosition[1];
        int totalBombs = totalBombs(field);

        while (!commands.isEmpty()) {
            String command = commands.get(0);

            switch (command) {
                case "up":
                    if (sapperRow - 1 >= 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow + 1 < size) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol - 1 >= 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol + 1 < size) {
                        sapperCol++;
                    }
                    break;
            }

            if (field[sapperRow][sapperCol] == 'B') {
                totalBombs--;
                field[sapperRow][sapperCol] = '+';
                System.out.println("You found a bomb!");

                if (totalBombs == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    break;
                }
            } else if (field[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", totalBombs);
                break;
            }

            commands.remove(0);
        }

        if (commands.isEmpty() && totalBombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", totalBombs, sapperRow, sapperCol);
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = arr;
        }
    }

    public static int[] sapperPosition(char[][] matrix) {
        int[] sapperPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; (c < matrix[r].length); c++) {
                if (matrix[r][c] == 's') {
                    sapperPosition = new int[] { r, c };
                }
            }
        }

        return sapperPosition;
    }

    public static int totalBombs(char[][] matrix) {
        int totalBombs = 0;

        for (char[] row : matrix) {
            for (char el : row)
                if (el == 'B') {
                    totalBombs++;
                }
        }

        return totalBombs;
    }
}