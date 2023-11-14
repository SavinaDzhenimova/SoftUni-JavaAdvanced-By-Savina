package Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int num = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> children = new PriorityQueue<>();

        for (String child : input) {
            children.offer(child);
        }

        int cycle = 1;
        while (children.size() > 1) {
            for (int i = 1; i < num; i++) {
                children.offer(children.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + children.poll());
    }

    public static boolean isPrime(int val) {
        if (val < 2)
            return false;

        for (int i = 2, max = (int)Math.sqrt(val); i <= max; i++)
            if (val % i == 0)
                return false;

        return true;
    }
}