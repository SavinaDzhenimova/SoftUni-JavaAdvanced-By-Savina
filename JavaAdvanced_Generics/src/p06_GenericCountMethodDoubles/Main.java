package p06_GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> stringBox = new Box<>();
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            stringBox.add(input);
        }

        double element = Double.parseDouble(scanner.nextLine());
        System.out.println(stringBox.getGreaterElementsCount(element));
    }
}