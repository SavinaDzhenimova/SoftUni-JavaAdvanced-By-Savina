package p05_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    @Override
    public int compareTo(Person otherPerson) {
        if (this.name.equals(otherPerson.name)) {
            if (this.age == otherPerson.age) {
                if (this.town.equals(otherPerson.town)) {
                    return 0;
                }
            }
        }
        return -1;
    }
}