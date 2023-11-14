package Exam_2023_12_April;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] timeInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] tasksInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> times = new ArrayDeque<>();
        for (int t : timeInput) {
            times.offer(t);
        }
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        for (int t : tasksInput) {
            tasks.push(t);
        }

        int darthVaderDucky = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;

        while (!times.isEmpty() || !tasks.isEmpty()) {
            int time = times.poll();
            int task = tasks.pop();
            int result = time * task;

            if (result >= 0 && result <= 60) {
                darthVaderDucky++;
            } else if (result >= 61 && result <= 120) {
                thorDucky++;
            } else if (result >= 121 && result <= 180) {
                bigBlueRubberDucky++;
            } else if (result >= 181 && result <= 240) {
                smallYellowRubberDucky++;
            } else {
                task -= 2;
                tasks.push(task);
                times.offer(time);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", darthVaderDucky);
        System.out.printf("Thor Ducky: %d%n", thorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", bigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", smallYellowRubberDucky);
    }
}