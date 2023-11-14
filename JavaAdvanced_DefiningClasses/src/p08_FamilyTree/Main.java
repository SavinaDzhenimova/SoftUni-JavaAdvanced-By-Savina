package p08_FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String personName = scanner.nextLine();
        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();
        LinkedHashMap<String, List<String>> parentChildren = new LinkedHashMap<>();
        while (!input.equals("End")) {
            if (input.contains(" - ")) {
                String[] tokens = input.split(" - ");
                String parentId = tokens[0];
                String childId = tokens[1];
                parentChildren.putIfAbsent(parentId, new ArrayList<>());
                parentChildren.get(parentId).add(childId);
            } else {
                String[] tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthDate = tokens[2];
                people.add(new Person(name, birthDate));
            }

            input = scanner.nextLine();
        }

        parentChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(childId -> findPerson(people, childId))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personName);

        System.out.println(getFamilyTreeFor(forPerson));
    }

    private static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

    public static String getFamilyTreeFor(Person person) {
        return person.toString() + System.lineSeparator() +
                "Parents:" + System.lineSeparator() +
                person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())) +
                (person.getParents().isEmpty() ? "" : System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}