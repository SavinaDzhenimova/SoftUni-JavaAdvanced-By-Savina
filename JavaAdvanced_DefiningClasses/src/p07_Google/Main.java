package p07_Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];

            people.putIfAbsent(personName, new Person(personName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    people.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parent = new Parents(parentName, parentBirthday);
                    people.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children child = new Children(childName, childBirthday);
                    people.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    people.get(personName).setCar(car);
                    break;
            }

            command = scanner.nextLine();
        }

        String personName = scanner.nextLine();
        people.get(personName).printFormat();
    }
}