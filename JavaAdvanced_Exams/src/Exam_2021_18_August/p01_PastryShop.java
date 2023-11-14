package Exam_2021_18_August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (int first : liquidsArr) {
            liquidsQueue.offer(first);
        }
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int second : ingredientsArr) {
            ingredientsStack.push(second);
        }
        LinkedHashMap<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            if (sum >= 25 && sum <= 100) {
                if (sum == 25) {
                    food.put("Biscuit", food.get("Biscuit") + 1);
                } else if (sum == 50) {
                    food.put("Cake", food.get("Cake") + 1);
                } else if (sum == 75) {
                    food.put("Pastry", food.get("Pastry") + 1);
                } else if (sum == 100) {
                    food.put("Pie", food.get("Pie") + 1);
                } else {
                    ingredient += 3;
                    ingredientsStack.push(ingredient);
                }

            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }

        if (food.get("Biscuit") > 0 && food.get("Cake") > 0 && food.get("Pastry") > 0 && food.get("Pie") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientsStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        food.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}