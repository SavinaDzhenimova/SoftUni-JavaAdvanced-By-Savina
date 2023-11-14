package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            if (currentChar == '(') {
                indexes.push(index);
            } else if (currentChar == ')') {
                System.out.println(input.substring(indexes.pop(), index + 1));
            }
        }
    }
}