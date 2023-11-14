package p04_GenericSwapMethodIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> stringBox = new Box<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            stringBox.add(input);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        stringBox.swap(indexes[0], indexes[1]);

        System.out.println(stringBox);
    }
}