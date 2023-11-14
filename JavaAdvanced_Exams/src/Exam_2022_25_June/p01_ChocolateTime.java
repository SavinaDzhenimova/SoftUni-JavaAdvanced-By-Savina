package Exam_2022_25_June;

import java.util.*;

public class p01_ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milkQuantityInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double[] cacaoPowderInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (double lp : milkQuantityInput) {
            milkQueue.offer(lp);
        }
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        for (double c : cacaoPowderInput) {
            cacaoStack.push(c);
        }
        int milkChocolate = 0;
        int darkChocolate = 0;
        int bakingChocolate = 0;

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            double result = cacao / (cacao + milk) * 100;

            if (result >= 30 && result <= 100) {
                if (result == 30) {
                    milkChocolate++;
                } else if (result == 50) {
                    darkChocolate++;
                } else if (result == 100) {
                    bakingChocolate++;
                } else {
                    milk += 10;
                    milkQueue.offer(milk);
                }

            } else {
                milk += 10;
                milkQueue.offer(milk);
            }
        }

        if (milkChocolate > 0 && darkChocolate > 0 && bakingChocolate > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (bakingChocolate > 0) {
            System.out.printf("# Baking Chocolate --> %d%n", bakingChocolate);
        }
        if (darkChocolate > 0) {
            System.out.printf("# Dark Chocolate --> %d%n", darkChocolate);
        }
        if (milkChocolate > 0) {
            System.out.printf("# Milk Chocolate --> %d%n", milkChocolate);
        }
    }
}