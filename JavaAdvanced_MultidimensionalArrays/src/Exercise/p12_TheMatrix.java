package Exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p12_TheMatrix {
    public static void main(String[] args) {
        readInput();
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        char[][] table = new char[r][c];
        String[] line;
        for(int i=0;i<r;i++) {
            line = scanner.nextLine().split("\\s+");
            for(int j=0;j<c;j++) {
                table[i][j] = line[j].charAt(0);
            }
        }

        char fillChar = scanner.nextLine().charAt(0);
        str = scanner.nextLine().split("\\s+");
        int startRow  = Integer.parseInt(str[0]);
        int startCol  = Integer.parseInt(str[1]);
        matrixBFS(table,fillChar,startRow,startCol);
        printTable(table);
    }

    public static void matrixBFS (char[][] table,char fillChar,int startRow,int startCol) {
        char startChar = table[startRow][startCol];
        MyPair startPair = new MyPair(startRow,startCol);
        Queue<MyPair> queue = new LinkedList<>();
        queue.add(startPair);
        while (!queue.isEmpty()) {

            MyPair cur = queue.remove();
            table[cur.x][cur.y] = fillChar;
            if (cur.x + 1 < table.length && table[cur.x + 1][cur.y] == startChar) {
                table[cur.x + 1][cur.y] = fillChar;
                queue.add(new MyPair(cur.x + 1, cur.y));
            }

            if (cur.y + 1 < table[0].length && table[cur.x][cur.y + 1] == startChar) {
                table[cur.x][cur.y + 1] = fillChar;
                queue.add(new MyPair(cur.x, cur.y + 1));
            }

            if (cur.x - 1 >= 0 && table[cur.x - 1][cur.y] == startChar) {
                table[cur.x - 1][cur.y] = fillChar;
                queue.add(new MyPair(cur.x - 1, cur.y));
            }

            if (cur.y - 1 >= 0 && table[cur.x][cur.y - 1] == startChar) {
                table[cur.x][cur.y - 1] = fillChar;
                queue.add(new MyPair(cur.x, cur.y - 1));

            }
        }
    }

    public static void printTable(char[][] table) {
        for (char[] row : table) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%c", row[j]);
            }
            System.out.println();
        }
    }

    static class MyPair {
        int x;
        int y;
        public MyPair(int x,int y) {
            this.x=x;
            this.y=y;
        }

        public String toString() {
            return String.format("[%d,%d]",x,y);
        }
    }
}