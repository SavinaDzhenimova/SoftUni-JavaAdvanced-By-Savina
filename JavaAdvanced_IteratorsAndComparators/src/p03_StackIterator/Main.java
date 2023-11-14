package p03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("Pop")) {
                try {
                    stackIterator.pop();
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (tokens[0].equals("Push")) {
                Arrays.stream(command.split("[\\s,]+"))
                        .skip(1)
                        .map(Integer::parseInt)
                        .forEach(stackIterator::push);
            }

            command = scanner.nextLine();
        }

        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);
    }
}