package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        for (double num : input) {
            numbers.putIfAbsent(num, 0);
            numbers.put(num, numbers.get(num) + 1);
        }

        numbers.entrySet().stream().forEach(n -> System.out.printf("%.1f -> %d%n", n.getKey(), n.getValue()));
    }
}