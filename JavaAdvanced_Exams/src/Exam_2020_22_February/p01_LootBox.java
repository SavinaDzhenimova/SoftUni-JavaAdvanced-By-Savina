package Exam_2020_22_February;

import java.util.*;

public class p01_LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstBoxArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondBoxArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        for (int item : firstBoxArr) {
            firstBoxQueue.offer(item);
        }
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        for (int item : secondBoxArr) {
            secondBoxStack.push(item);
        }
        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.peek();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondItem);
            }
        }

        int claimedItemsSum = 0;
        for (int item : claimedItems) {
            claimedItemsSum += item;
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItemsSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", claimedItemsSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", claimedItemsSum);
        }
    }
}