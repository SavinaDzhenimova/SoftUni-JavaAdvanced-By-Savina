package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p06_StringMatrixRotation {
    public static List<String> wordsList = new ArrayList<>();
    public static int maxWordLength;
    public static int wordsCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int degrees = calculateDegrees(input);
        char[][] matrix = fillMatrix(scanner);

        if (degrees == 90) {
            rotate90DegreesAndPrint();
        } else if (degrees == 180) {
            rotate180DegreesAndPrint();
        } else if (degrees == 270) {
            rotate270DegreesAndPrint();
        } else if (degrees == 0) {
            printMatrix(matrix);
        }
    }

    public static int calculateDegrees(String input) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                startIndex = i + 1;
            }

            if (currentChar == ')') {
                endIndex = i;
            }
        }

        int degrees = Integer.parseInt(input.substring(startIndex, endIndex));
        if (degrees > 360) {
            degrees %= 360;
        }

        return degrees;
    }

    public static char[][] fillMatrix(Scanner scanner) {
        String word = scanner.nextLine();

        while (!word.equals("END")) {
            wordsList.add(word);
            if (maxWordLength < word.length()) {
                maxWordLength = word.length();
            }

            word = scanner.nextLine();
        }
        wordsCount = wordsList.size();

        char[][] matrix = new char[wordsCount][maxWordLength];

        for (int r = 0; r < matrix.length; r++) {
            char[] line = wordsList.get(r).toCharArray();
            matrix[r] = line;
        }

        return matrix;
    }

    public static void rotate90DegreesAndPrint() {
        char[][] matrix90Degrees = new char[maxWordLength][wordsCount];

        for (int c = 0; c < wordsCount; c++) {
            char[] line = wordsList.get(wordsCount - 1 - c).toCharArray();

            for (int j = 0; j < line.length; j++) {
                for (int r = 0; r < maxWordLength; r++) {
                    if (r < line.length) {
                        matrix90Degrees[r][c] = line[j];
                    } else {
                        matrix90Degrees[r][c] = ' ';
                    }
                    j++;
                }
            }
        }

        printMatrix(matrix90Degrees);
    }

    public static void rotate180DegreesAndPrint() {
        char[][] matrix180Degrees = new char[wordsCount][maxWordLength];

        for (int r = 0; r < wordsCount; r++) {
            char[] line = wordsList.get(wordsCount - 1 - r).toCharArray();

            for (int j = 0; j < line.length; j++) {
                for (int c = maxWordLength - 1; c >= 0; c--) {
                    if (j < line.length) {
                        matrix180Degrees[r][c] = line[j];
                    } else {
                        matrix180Degrees[r][c] = ' ';
                    }
                    j++;
                }
            }
        }

        printMatrix(matrix180Degrees);
    }

    public static void rotate270DegreesAndPrint() {
        char[][] matrix270Degrees = new char[maxWordLength][wordsCount];

        for (int c = wordsCount - 1; c >= 0; c--) {
            char[] line = wordsList.get(c).toCharArray();

            for (int j = 0; j < line.length; j++) {
                for (int r = maxWordLength - 1; r >= 0; r--) {
                    if (j < line.length) {
                        matrix270Degrees[r][c] = line[j];
                    } else {
                        matrix270Degrees[r][c] = ' ';
                    }
                    j++;
                }
            }
        }

        printMatrix(matrix270Degrees);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] rows : matrix) {
            StringBuilder line = new StringBuilder();

            for (int i = 0; i < rows.length; i++) {
                line.append(rows[i]);
            }
            System.out.println(line);
        }
    }
}