package Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class p02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] length = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetLength = length[0];
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        int secondSetLength = length[1];
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            firstSet.add(num);
        }

        for (int i = 0; i < secondSetLength; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            secondSet.add(num);
        }

        while (!firstSet.isEmpty()) {
            int el = firstSet.iterator().next();
            firstSet.remove(el);

            if (secondSet.contains(el)) {
                System.out.print(el + " ");
            }
        }
    }
}