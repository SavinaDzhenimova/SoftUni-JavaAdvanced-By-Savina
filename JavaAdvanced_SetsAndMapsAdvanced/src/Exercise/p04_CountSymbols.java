package Exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] symbols = scanner.nextLine().toCharArray();
        TreeMap<Character, Integer> occurrences = new TreeMap<>();

        for (char symbol : symbols) {
            occurrences.putIfAbsent(symbol, 0);
            occurrences.put(symbol, occurrences.get(symbol) + 1);
        }

        occurrences.entrySet().
                stream().
                forEach(e -> System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}