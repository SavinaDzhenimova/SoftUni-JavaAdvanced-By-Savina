package p04_Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Lake lake = new Lake(numbers);

        Iterator<Integer> iterator = lake.iterator();
        boolean isNotLast;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            isNotLast = iterator.hasNext();
            if (isNotLast) {
                System.out.print(element + ", ");
            } else {
                System.out.print(element);
            }
        }
    }
}