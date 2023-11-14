package p08_FamilyTree;

import java.util.ArrayList;
public class Person {
    private final String name;
    private final String birthDate;
    private final ArrayList<Person> parents = new ArrayList<>();
    private final ArrayList<Person> children = new ArrayList<>();

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }
}