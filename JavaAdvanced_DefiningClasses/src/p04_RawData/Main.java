package p04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Car>> fragileCargo = new LinkedHashMap<>();
        LinkedHashMap<String, List<Car>> flamableCargo = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tyre1Pressure = Double.parseDouble(tokens[5]);
            int tyre1Age = Integer.parseInt(tokens[6]);
            double tyre2Pressure = Double.parseDouble(tokens[7]);
            int tyre2Age = Integer.parseInt(tokens[8]);
            double tyre3Pressure = Double.parseDouble(tokens[9]);
            int tyre3Age = Integer.parseInt(tokens[10]);
            double tyre4Pressure = Double.parseDouble(tokens[11]);
            int tyre4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tyre1Pressure, tyre1Age, tyre2Pressure, tyre2Age,
                    tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);
            Car car = new Car(model, engine, cargo, tires);

            if (cargoType.equals("fragile")) {
                fragileCargo.putIfAbsent("fragile", new ArrayList<>());
                fragileCargo.get("fragile").add(car);
            } else if (cargoType.equals("flamable")) {
                flamableCargo.putIfAbsent("flamable", new ArrayList<>());
                flamableCargo.get("flamable").add(car);
            }
        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                for (Map.Entry<String, List<Car>> entry : fragileCargo.entrySet()) {
                    for (Car car : entry.getValue()) {
                        if (car.getTires().getTyre1Pressure() < 1 || car.getTires().getTyre2Pressure() < 1 ||
                                car.getTires().getTyre3Pressure() < 1 || car.getTires().getTyre4Pressure() < 1) {
                            System.out.println(car.getModel());
                        }
                    }
                }
                break;
            case "flamable":
                for (Map.Entry<String, List<Car>> entry : flamableCargo.entrySet()) {
                    for (Car car : entry.getValue()) {
                        if (car.getEngine().getEnginePower() > 250) {
                            System.out.println(car.getModel());
                        }
                    }
                }
                break;
        }
    }
}