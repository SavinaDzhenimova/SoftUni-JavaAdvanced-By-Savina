package Exam_2020_19_August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liliesArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] rosesArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        for (int lily : liliesArr) {
            liliesStack.push(lily);
        }
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for (int rose : rosesArr) {
            rosesQueue.offer(rose);
        }

        int wreaths = 0;
        int smallerSums = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lily = liliesStack.peek();
            int rose = rosesQueue.peek();
            int sum = lily + rose;

            if (sum == 15) {
                wreaths++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (sum > 15) {
                lily -= 2;
                liliesStack.pop();
                liliesStack.push(lily);
            } else {
                smallerSums += sum;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }

        wreaths += smallerSums / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }
    }
}