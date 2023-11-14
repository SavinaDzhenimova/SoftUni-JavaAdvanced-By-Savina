package p07_EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int hashCode =  this.getName().length() * 10000;
        hashCode += this.getAge() * 10000;

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass()!= this.getClass()) return false;

        Person person = (Person) obj;
        return (person.getName().equals(this.getName()) && person.getAge() == this.getAge());
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), other.getAge());
        }
        return result;
    }
}