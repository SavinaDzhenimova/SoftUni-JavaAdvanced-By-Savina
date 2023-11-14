package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class p04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToDouble(Double::parseDouble).toArray();

        System.out.println("Prices with VAT:");
        UnaryOperator<Double> priceWithVAT = p -> p * 1.2;
        Arrays.stream(prices).forEach(p -> System.out.printf("%.2f%n", priceWithVAT.apply(p)));
    }
}