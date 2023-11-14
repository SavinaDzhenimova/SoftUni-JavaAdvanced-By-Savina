package p02_CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            Car car = null;
            if (tokens.length == 1) {
                car = new Car(brand);
            } else if (tokens.length == 3) {
                car = new Car(brand, tokens[1], Integer.parseInt(tokens[2]));
            }

            System.out.println(car);
        }
    }
}