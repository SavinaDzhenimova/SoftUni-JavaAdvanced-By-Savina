package Lab;

        import java.util.ArrayDeque;
        import java.util.Scanner;

public class p03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();

        if (decimalNum == 0) {
            System.out.println(0);
        } else {
            while (decimalNum > 0) {
                int remainder = decimalNum % 2;
                binaryNum.push(remainder);
                decimalNum /= 2;
            }

            for (Integer num : binaryNum) {
                System.out.print(num);
            }
        }
    }
}