package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsNumber; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    stack.push(String.valueOf(text));

                    String textToAppend = tokens[1];
                    text.append(textToAppend);
                    break;
                case "2":
                    stack.push(String.valueOf(text));

                    int count = Integer.parseInt(tokens[1]);
                    int startIndex = text.length() - count;
                    text.delete(startIndex, startIndex + count);

                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        text = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}