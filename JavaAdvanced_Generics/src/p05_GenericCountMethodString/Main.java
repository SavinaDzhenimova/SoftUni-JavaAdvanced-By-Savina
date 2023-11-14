package p05_GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> stringBox = new Box<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            stringBox.add(input);
        }

        String element = scanner.nextLine();
        System.out.println(stringBox.getGreaterElementsCount(element));
    }
}