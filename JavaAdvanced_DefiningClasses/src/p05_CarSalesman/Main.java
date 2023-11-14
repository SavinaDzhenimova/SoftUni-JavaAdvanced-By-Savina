package p05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            int displacement;
            String efficiency;

            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                if (Character.isLetter(tokens[2].charAt(0))) {
                    efficiency = tokens[2];

                    engine = new Engine(model, power, efficiency);
                } else {
                    displacement = Integer.parseInt(tokens[2]);

                    engine = new Engine(model, power, displacement);
                }
            } else if (tokens.length == 4) {
                displacement = Integer.parseInt(tokens[2]);
                efficiency = tokens[3];

                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine engine = engines.get(engineModel);
            int weight;
            String color;

            Car car = null;
            if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    weight = Integer.parseInt(tokens[2]);

                    car = new Car(model, engine, weight);
                } else {
                    color = tokens[2];

                    car = new Car(model, engine, color);
                }
            } else if (tokens.length == 4) {
                weight = Integer.parseInt(tokens[2]);
                color = tokens[3];

                car = new Car(model, engine, weight, color);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.printf("%s:%n", car.getModel());
            System.out.printf("%s:%n", car.getEngine().getModel());
            System.out.printf("Power: %d%n", car.getEngine().getPower());
            if (car.getEngine().getDisplacement() == 0) {
                System.out.println("Displacement: n/a");
            } else {
                System.out.printf("Displacement: %d%n", car.getEngine().getDisplacement());
            }
            if (car.getEngine().getEfficiency() == null) {
                System.out.println("Efficiency: n/a");
            } else {
                System.out.printf("Efficiency: %s%n", car.getEngine().getEfficiency());
            }
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.printf("Weight: %d%n", car.getWeight());
            }
            if (car.getColor() == null) {
                System.out.println("Color: n/a");
            } else {
                System.out.printf("Color: %s%n", car.getColor());
            }
        }
    }
}