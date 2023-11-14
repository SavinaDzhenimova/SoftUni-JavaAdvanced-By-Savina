package p05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String data = scanner.nextLine();

        while (!data.equals("END")) {
            String[] tokens = data.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);

            data = scanner.nextLine();
        }

        int equalPeopleCount = 0;
        int notEqualPeopleCount = 0;
        int personIndex = Integer.parseInt(scanner.nextLine());
        if (personIndex >= 0 && personIndex < people.size()) {
            Person otherPerson = people.get(personIndex);
            for (Person p : people) {
                if (otherPerson.compareTo(p) == 0) {
                    equalPeopleCount++;
                } else {
                    notEqualPeopleCount++;
                }
            }
        }

        if (equalPeopleCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalPeopleCount, notEqualPeopleCount, people.size());
        }
    }
}