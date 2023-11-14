package Exam_2022_25_June;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_StickyFingers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        List<String> commands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        fillMatrix(scanner, field);
        int[] robberPosition = robberPosition(field);
        int robberRow = robberPosition[0];
        int robberCol = robberPosition[1];
        field[robberRow][robberCol] = '+';

        int money = 0;
        boolean isCaught = false;
        while (!commands.isEmpty()) {
            String command = commands.get(0);

            switch (command) {
                case "up":
                    if (robberRow - 1 >= 0) {
                        robberRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (robberRow + 1 < size) {
                        robberRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (robberCol - 1 >= 0) {
                        robberCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (robberCol + 1 < size) {
                        robberCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            if (field[robberRow][robberCol] == '$') {
                money += robberRow * robberCol;
                field[robberRow][robberCol] = '+';
                System.out.printf("You successfully stole %d$.%n", robberRow * robberCol);
            } else if (field[robberRow][robberCol] == 'P') {
                field[robberRow][robberCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
                isCaught = true;
                break;
            }

            commands.remove(0);
        }

        if (!isCaught) {
            field[robberRow][robberCol] = 'D';
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", money);
        }
        for (char[] row : field) {
            for (char el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            char[] row = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = row;
        }
    }

    public static int[] robberPosition(char[][] matrix) {
        int[] robberPosition = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'D') {
                    robberPosition[0] = r;
                    robberPosition[1] = c;
                }
            }
        }

        return robberPosition;
    }
}