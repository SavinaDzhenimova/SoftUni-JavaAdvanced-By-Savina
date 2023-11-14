package p10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s+");
        String firstName = input1[0] + " " + input1[1];
        String address = input1[2];
        Tuple<String, String> firstFormat = new Tuple<>(firstName, address);

        String[] input2 = scanner.nextLine().split("\\s+");
        String name = input2[0];
        int litersOfBeer = Integer.parseInt(input2[1]);
        Tuple<String, Integer> secondFormat = new Tuple<>(name, litersOfBeer);

        String[] input3 = scanner.nextLine().split("\\s+");
        int integerValue = Integer.parseInt(input3[0]);
        double doubleValue = Double.parseDouble(input3[1]);
        Tuple<Integer, Double> thirdFormat = new Tuple<>(integerValue, doubleValue);

        System.out.println(firstFormat);
        System.out.println(secondFormat);
        System.out.println(thirdFormat);
    }
}