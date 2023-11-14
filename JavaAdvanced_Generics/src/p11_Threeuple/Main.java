package p11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s+");
        String firstName = input1[0] + " " + input1[1];
        String address = input1[2];
        String town = input1[3];
        Threeuple<String, String, String> firstFormat = new Threeuple<>(firstName, address, town);

        String[] input2 = scanner.nextLine().split("\\s+");
        String name = input2[0];
        int litersOfBeer = Integer.parseInt(input2[1]);
        boolean drunkOrNot = input2[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondFormat = new Threeuple<>(name, litersOfBeer, drunkOrNot);

        String[] input3 = scanner.nextLine().split("\\s+");
        String personName = input3[0];
        double accountBalance = Double.parseDouble(input3[1]);
        String bankName = input3[2];
        Threeuple<String, Double, String> thirdFormat = new Threeuple<>(personName, accountBalance, bankName);

        System.out.println(firstFormat);
        System.out.println(secondFormat);
        System.out.println(thirdFormat);
    }
}