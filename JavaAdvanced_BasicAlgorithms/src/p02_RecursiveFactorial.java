import java.util.Scanner;

public class p02_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(num));
    }

    public static long factorial(long num) {
        if (num >= 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }
}