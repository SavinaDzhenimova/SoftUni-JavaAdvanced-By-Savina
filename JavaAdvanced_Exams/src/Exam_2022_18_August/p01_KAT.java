package Exam_2022_18_August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] licencePlatesInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carsInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> licencePlatesQueue = new ArrayDeque<>();
        for (int lp : licencePlatesInput) {
            licencePlatesQueue.offer(lp);
        }
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        for (int c : carsInput) {
            carsStack.push(c);
        }

        int registeredCars = 0;
        int days = 0;
        while (!licencePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            int licencePlates = licencePlatesQueue.poll() / 2;
            int cars = carsStack.pop();

            if (licencePlates == cars) {
                registeredCars += cars;
            } else if (licencePlates > cars) {
                registeredCars += cars;
                licencePlates -= cars;
                licencePlatesQueue.offer(licencePlates * 2);
            } else {
                registeredCars += licencePlates;
                cars -= licencePlates;
                carsStack.offer(cars);
            }
            days++;
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (licencePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (licencePlatesQueue.isEmpty()) {
            int sum = 0;
            for (int car : carsStack) {
                sum += car;
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        } else if (carsStack.isEmpty()) {
            int sum = 0;
            for (int lp : licencePlatesQueue) {
                sum += lp;
            }
            System.out.printf("%d license plates remain!%n", sum);
        }
    }
}