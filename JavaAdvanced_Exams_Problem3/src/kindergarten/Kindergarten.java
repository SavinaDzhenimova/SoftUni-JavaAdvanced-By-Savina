package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        setRegistry(new ArrayList<>());
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRegistry(ArrayList<Child> registry) {
        this.registry = registry;
    }

    public boolean addChild(Child child) {
        if (this.getChildrenCount() == this.capacity) {
            return false;
        }

        this.registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                getRegistry().remove(child);
                return true;
            }
        }

        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        List<Child> orderedList = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");

        for (Child child : orderedList) {
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(child.toString());
        }

        return sb.toString().trim();
    }
}