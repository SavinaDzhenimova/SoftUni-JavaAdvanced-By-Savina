package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09_LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbers);
        Collections.reverse(numbers);

        if (numbers.size() > 3) {
            System.out.printf("%d %d %d", numbers.get(0), numbers.get(1), numbers.get(2));
        } else {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        }
    }
}