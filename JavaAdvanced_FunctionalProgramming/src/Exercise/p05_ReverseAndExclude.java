package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisibleByNum = n -> n % divisor == 0;
        numbers.removeIf(isDivisibleByNum);
        Collections.reverse(numbers);

        numbers.forEach(n -> System.out.print(n + " "));
    }
}