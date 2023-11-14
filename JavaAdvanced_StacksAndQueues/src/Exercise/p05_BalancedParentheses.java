package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = isBalanced(input) ? "YES" : "NO";

        System.out.println(result);
    }

    public static boolean isBalanced(String input) {
        ArrayDeque<String> openingBrackets = new ArrayDeque<>();

        if (input.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            switch (currentBracket) {
                case '}':
                    if (!openingBrackets.pop().equals("{")) {
                        return false;
                    }
                    break;
                case ']':
                    if (!openingBrackets.pop().equals("[")) {
                        return false;
                    }
                    break;
                case ')':
                    if (!openingBrackets.pop().equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openingBrackets.push(String.valueOf(currentBracket));
                    break;
            }

        }

        return openingBrackets.isEmpty();
    }
}