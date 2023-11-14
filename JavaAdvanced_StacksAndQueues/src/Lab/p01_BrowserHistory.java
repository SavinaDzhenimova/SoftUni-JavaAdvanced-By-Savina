package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.size() > 1) {
                    history.pop();
                    System.out.println(history.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                history.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}