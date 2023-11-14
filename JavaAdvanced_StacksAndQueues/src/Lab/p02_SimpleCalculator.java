package Lab;

import java.util.*;

public class p02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> expression = new ArrayDeque<>();

        expression.addAll(Arrays.asList(input));

        int sum = Integer.parseInt(expression.pop());
        while (!expression.isEmpty()) {
            String operator = expression.pop();

            if (operator.equals("+")) {
                sum += Integer.parseInt(expression.pop());
            } else if (operator.equals("-")) {
                sum -= Integer.parseInt(expression.pop());
            }
        }

        System.out.println(sum);
    }
}