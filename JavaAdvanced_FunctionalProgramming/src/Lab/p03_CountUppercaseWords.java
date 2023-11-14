package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isUppercase = w -> Character.isUpperCase(w.charAt(0));
        List<String> uppercaseWords = Arrays.stream(text).filter(isUppercase).collect(Collectors.toList());

        System.out.println(uppercaseWords.size());

        Consumer<String> outputConsumer = System.out::println;
        uppercaseWords.forEach(outputConsumer);
    }
}