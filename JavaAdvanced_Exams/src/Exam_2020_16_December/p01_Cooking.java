package Exam_2020_16_December;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (int liquid : liquidsArr) {
            liquidsQueue.offer(liquid);
        }
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int ingredient : ingredientsArr) {
            ingredientsStack.push(ingredient);
        }

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            if (sum >= 25 && sum <= 100) {
                if (sum == 25) {
                    bread++;
                } else if (sum == 50) {
                    cake++;
                } else if (sum == 75) {
                    pastry++;
                } else if (sum == 100) {
                    fruitPie++;
                } else {
                    ingredient += 3;
                    ingredientsStack.push(ingredient);
                }
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }

        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}