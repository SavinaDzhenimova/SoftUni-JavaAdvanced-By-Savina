package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, int[]> parsingInput = s -> Arrays.stream(s.split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = parsingInput.apply(input);

        Function<int[], Integer> count = n -> n.length;
        Function<int[], Integer> sum = n -> Arrays.stream(n).sum();

        System.out.println("Count = " + count.apply(numbers));
        System.out.println("Sum = " + sum.apply(numbers));
    }
}