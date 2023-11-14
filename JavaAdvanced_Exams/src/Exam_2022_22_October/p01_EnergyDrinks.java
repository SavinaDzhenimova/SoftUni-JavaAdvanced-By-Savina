package Exam_2022_22_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] caffeineInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] energyDrinksInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        for (int c : caffeineInput) {
            caffeineStack.push(c);
        }
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();
        for (int e : energyDrinksInput) {
            energyDrinksQueue.offer(e);
        }

        int maxCaffeine = 300;
        int takenCaffeine = 0;
        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
            int caffeine = caffeineStack.pop();
            int energyDrink = energyDrinksQueue.poll();
            int result = caffeine * energyDrink;

            if (takenCaffeine + result <= maxCaffeine) {
                takenCaffeine += result;
            } else {
                energyDrinksQueue.offer(energyDrink);
                if (takenCaffeine - 30 >= 0) {
                    takenCaffeine -= 30;
                }
            }
        }

        if (!energyDrinksQueue.isEmpty()) {
            System.out.println("Drinks left: " + energyDrinksQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", takenCaffeine);
    }
}