package p03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostForOneKilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostForOneKilometer);
            cars.put(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            String model = tokens[1];
            int amountOfKilometers = Integer.parseInt(tokens[2]);

            if (cars.containsKey(model)) {
                cars.get(model).driveCar(amountOfKilometers);
            }

            command = scanner.nextLine();
        }

        cars.forEach((key, value) -> System.out.println(value));
    }
}