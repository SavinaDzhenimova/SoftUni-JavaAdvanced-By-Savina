package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class p05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(",\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String, Integer>> filter = createFilter(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        people.entrySet().stream()
                .filter(filter)
                .forEach(printer);
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            return e -> System.out.println(e.getValue());
        }

        return e -> System.out.println(e.getKey() + " - " + e.getValue());
    }

    private static Predicate<Map.Entry<String, Integer>> createFilter(String condition, int age) {
        if (condition.equals("younger")) {
            return e -> e.getValue() <= age;
        }

        return e -> e.getValue() >= age;
    }
}