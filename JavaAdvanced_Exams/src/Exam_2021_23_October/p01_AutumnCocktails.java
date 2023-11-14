package Exam_2021_23_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class p01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freshnessArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (int i : ingredientsArr) {
            ingredientsQueue.offer(i);
        }
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (int f : freshnessArr) {
            freshnessStack.push(f);
        }

        TreeMap<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredients = ingredientsQueue.poll();
            if (ingredients == 0) {
                continue;
            }
            int freshness = freshnessStack.pop();
            int result = ingredients * freshness;

            if (result >= 150 && result <= 400) {
                if (result == 150) {
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                } else if (result == 250) {
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                } else if (result == 300) {
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                } else if (result == 400) {
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                } else {
                    ingredients += 5;
                    ingredientsQueue.offer(ingredients);
                }

            } else {
                ingredients += 5;
                ingredientsQueue.offer(ingredients);
            }
        }

        if (cocktails.get("Pear Sour") >= 1 && cocktails.get("The Harvest") >= 1 &&
                cocktails.get("Apple Hinny") >= 1 && cocktails.get("High Fashion") >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            System.out.println("Ingredients left: " + ingredientsQueue.stream().reduce(0, Integer::sum));
        }

        cocktails.forEach((cocktail, count) -> {
            if (count > 0) {
                System.out.printf(" # %s --> %d%n", cocktail, count);
            }
        });
    }
}