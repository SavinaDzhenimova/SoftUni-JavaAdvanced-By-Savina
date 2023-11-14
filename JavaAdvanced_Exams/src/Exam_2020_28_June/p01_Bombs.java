package Exam_2020_28_June;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class p01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] effectsArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] casingsArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        for (int effect : effectsArr) {
            effectsQueue.offer(effect);
        }
        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();
        for (int casing : casingsArr) {
            casingsStack.push(casing);
        }
        TreeMap<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int bombEffect = effectsQueue.poll();
            int bombCasing = casingsStack.pop();
            int sum = bombEffect + bombCasing;

            if (sum == 40) {
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
            } else if (sum == 120) {
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
            } else {
                while (bombCasing > 0) {
                    bombCasing -= 5;
                    sum = bombEffect + bombCasing;

                    if (sum == 40) {
                        bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                        break;
                    } else if (sum == 60) {
                        bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                        break;
                    } else if (sum == 120) {
                        bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                        break;
                    }
                }
            }

            if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                break;
            }
        }

        if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + effectsQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (casingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + casingsStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        bombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}