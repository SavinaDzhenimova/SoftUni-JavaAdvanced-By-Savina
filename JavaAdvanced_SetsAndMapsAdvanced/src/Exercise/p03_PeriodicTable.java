package Exercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());
        TreeSet<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < linesCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Collections.addAll(periodicTable, input);
        }

        periodicTable.stream().forEach(e -> System.out.print(e + " "));
    }
}