package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        for (String child : input) {
            children.offer(child);
        }

        while (children.size() > 1) {
            for (int i = 1; i < num; i++) {
                children.offer(children.poll());
            }
            System.out.println("Removed " + children.poll());
        }

        System.out.println("Last is " + children.poll());
    }
}