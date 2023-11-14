package Lab;

import java.util.*;

public class p07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = readMatrix(scanner);

        for (int r = 0; r < chessboard.length ; r++) {
            for (int c = 0; c < chessboard[r].length; c++) {
                if (chessboard[r][c] == 'q') {
                    boolean isColValid = checkVertical(chessboard, r, c);
                    boolean isRowValid = checkHorizontal(chessboard, r, c);
                    boolean isMainDiagonalUpAndLeft = checkMainDiagonalUpLeft(chessboard, r, c);
                    boolean isMainDiagonalDownAndRight = checkMainDiagonalDownAndRight(chessboard, r, c);
                    boolean isMainSecondaryValidUpAndRight = checkMainDiagonalUpAndRight(chessboard, r, c);
                    boolean isMainDiagonalDownAndLeft = checkMainDiagonalDownAndLeft(chessboard, r, c);
                    if (isColValid && isRowValid && isMainDiagonalUpAndLeft && isMainDiagonalDownAndRight
                            && isMainDiagonalDownAndLeft && isMainSecondaryValidUpAndRight) {
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }
    }

    public static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];

        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();
        }

        return matrix;
    }

    public static boolean checkVertical(char[][] matrix,int row, int col) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][col] == 'q' && r != row) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkHorizontal(char[][] matrix, int row, int col) {
        for (int c = 0; c < matrix[row].length; c++) {
            if (matrix[row][c] == 'q' && c != col) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkMainDiagonalDownAndLeft(char[][] matrix, int row, int col) {
        row++;
        col--;
        while(row < 8 && col >= 0){
            if(matrix[row++][col--] == 'q'){
                return false;
            }
        }

        return true;
    }

    private static boolean checkMainDiagonalUpAndRight(char[][] matrix, int row, int col) {
        row--;
        col++;
        while(row >= 0 && col < 8){
            if(matrix[row--][col++] == 'q'){
                return false;
            }
        }

        return true;
    }

    private static boolean checkMainDiagonalDownAndRight(char[][] matrix, int row, int col) {
        row++;
        col++;
        while(row  < 8  && col < 8 ){
            if(matrix[row++][col++] == 'q')
                return false;
        }

        return true;
    }

    private static boolean checkMainDiagonalUpLeft(char[][] matrix, int row, int col) {
        row--;
        col--;
        while(row >= 0 && col >= 0){
            if(matrix[row--][col--] == 'q')
                return false;
        }

        return true;
    }
}