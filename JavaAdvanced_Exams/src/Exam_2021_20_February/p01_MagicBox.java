package Exam_2021_20_February;

import java.util.*;

public class p01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        for (int first : firstArr) {
            firstBoxQueue.offer(first);
        }
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        for (int second : secondArr) {
            secondBoxStack.push(second);
        }
        int totalSum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.peek();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                totalSum += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondItem);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", totalSum);
        }
    }
}