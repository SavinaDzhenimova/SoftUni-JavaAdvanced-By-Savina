package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Parrot> getData() {
        return data;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrotToReturn = null;

        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                parrotToReturn = parrot;
            }
        }

        return parrotToReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotsToSell = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrotsToSell.add(parrot);
                parrot.setAvailable(false);
            }
        }

        return parrotsToSell;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        this.data.stream()
                .filter(Parrot::isAvailable)
                .forEach(p -> sb.append(p).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}