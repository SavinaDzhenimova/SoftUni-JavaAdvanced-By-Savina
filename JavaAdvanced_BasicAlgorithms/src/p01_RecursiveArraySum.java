import java.util.Arrays;
import java.util.Scanner;

public class p01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sum(numbers, numbers.length));
    }

    public static int sum(int[] numbers, int index) {
        if (index <= 0) {
            return 0;
        }
        return (sum(numbers, index - 1) + numbers[index - 1]);
    }
}