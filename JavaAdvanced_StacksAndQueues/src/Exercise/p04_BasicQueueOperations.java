package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(input[0]);
        int numberOfElementsToPop = Integer.parseInt(input[1]);
        int numberToCheckIfIsPresent = Integer.parseInt(input[2]);

        String[] line = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            numbers.offer(Integer.parseInt(line[i]));
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            numbers.poll();
        }

        if (numbers.isEmpty()) {
            System.out.println(0);
        } else {
            if (numbers.contains(numberToCheckIfIsPresent)) {
                System.out.println("true");
            } else {
                int min = numbers.poll();
                while (!numbers.isEmpty()) {
                    if (min > numbers.peek()) {
                        min = numbers.peek();
                    }
                    numbers.poll();
                }

                System.out.println(min);
            }
        }
    }
}