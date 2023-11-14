package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            if (command[0].equals("1")) {
                int numToPush = Integer.parseInt(command[1]);
                numbers.push(numToPush);
                if (max <= numToPush) {
                    max = numToPush;
                    maxStack.push(max);
                }

            } else if (command[0].equals("2")) {
                int poppedItem = numbers.pop();
                if (poppedItem == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }

            } else if (command[0].equals("3")) {
                System.out.println(max);
            }
        }
    }
}