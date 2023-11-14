package Exam_2023_21_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] fuelArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] additionalFuelArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> neededFuel = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        for (int fuel : fuelArr) {
            fuelStack.push(fuel);
        }
        ArrayDeque<Integer> additionalFuelQueue = new ArrayDeque<>();
        for (int fuel : additionalFuelArr) {
            additionalFuelQueue.offer(fuel);
        }

        int altitude = 0;
        while (!fuelStack.isEmpty() && !additionalFuelQueue.isEmpty()) {
            int fuel = fuelStack.peek();
            int additionalFuel = additionalFuelQueue.peek();
            int result = fuel - additionalFuel;
            altitude++;

            if (result >= neededFuel.get(0)) {
                fuelStack.pop();
                additionalFuelQueue.poll();
                neededFuel.remove(0);

                System.out.printf("John has reached: Altitude %d%n", altitude);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", altitude);
                altitude--;
                break;
            }
        }

        if (!neededFuel.isEmpty() && altitude > 0) {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i <= altitude; i++) {
                if (i == altitude) {
                    System.out.printf("Altitude %d", i);
                } else {
                    System.out.printf("Altitude %d, ", i);
                }
            }
        } else if (!neededFuel.isEmpty() && altitude == 0) {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        } else if (neededFuel.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}