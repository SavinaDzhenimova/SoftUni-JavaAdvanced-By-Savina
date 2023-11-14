package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_RecursiveFibonacciWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(0L);
        stack.push(1L);

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }

        System.out.println(stack.pop());
    }
}