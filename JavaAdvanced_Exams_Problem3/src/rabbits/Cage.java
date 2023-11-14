package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    //o
    //{Rabbit 1}
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findAny().orElse(null);
        if (rabbit != null) {
            rabbit.setAvailable();
            this.data.remove(rabbit);
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitsToSell = new ArrayList<>();

        for (Rabbit r : this.data) {
            if (r.getSpecies().equals(species)) {
                rabbitsToSell.add(r);
            }
        }
        removeSpecies(species);

        return rabbitsToSell;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at ").append(this.name).append(":").append(System.lineSeparator());
        this.data.forEach(r -> sb.append(r.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}